package practica1.gestordeportivo.types;

import practica1.gestordeportivo.commands.*;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import java.util.HashMap;

public enum Commands {
    CREATE_PLAYER("player-create"),
    CREATE_TEAM("team-create"),
    CREATE_TOURNAMENT("tournament-create"),
    DELETE_PLAYER("player-delete"),
    DELETE_TEAM("team-delete"),
    DELETE_TOURNAMENT("tournament-delete"),
    ADD_TEAM("team-add"),
    REMOVE_TEAM("team-remove"),
    MATCHMAKING("tournament-matchmaking"),
    ADD_TOURNAMENT("tournament-add"),
    REMOVE_TOURNAMENT("tournament-remove"),
    SHOW_STATISTICS("statistics-show"),
    LIST("tournament-list"),
    LOGIN("login"),
    LOGOUT("logout"),
    SAVEALL("save-all"),
    RECOVERALL("recover-all");

    private static final CommandInterface[] generateCommands(CommandLineInterpreter cli, String modes) {
        assert cli != null : "Error: CommandLineInterpreter es null";
        
        return new CommandInterface[] {
            new PlayerCreate(cli),
            new TeamCreate(cli),
            new TournamentCreate(cli),
            new PlayerDelete(cli),
            new TeamDelete(cli),
            new TournamentDelete(cli),
            new TeamAdd(cli),
            new TeamRemove(cli),
            MatchmakeModes.getCommandInterface(cli, modes), //revisar
            new TournamentAdd(cli),
            new TournamentRemove(cli),
            new StatisticsShow(cli),
            new ListTournaments(cli),
            new Login(cli),
            new Logout(cli),
            new SaveAll(cli),
            new RecoverAll(cli)
        };
    }

    private final String name;

    Commands(String name) {
        this.name = name;
    }

    private static Commands getCommandForInput(String input) {
        for (Commands command : Commands.values()) {
            if (input.startsWith(command.name)) {
                return command;
            }
        }
        return null; // No se encontró un comando válido
    }

    public String getName() {
        return name;
    }

    private static HashMap<String, CommandInterface> generateHash(CommandLineInterpreter cli, String modes) {
        HashMap<String, CommandInterface> commandMap = new HashMap<>();
        CommandInterface[] commandList = generateCommands(cli, modes);
        for (Commands command : Commands.values()) {
            commandMap.put(command.getName(), commandList[command.ordinal()]);       
        }
        return commandMap;
    }

    public static Errors executeCommand(String command, CommandLineInterpreter cli) {
        //Generamos la lista de comandos (Tabla hash)
        HashMap<String, CommandInterface> commandMap = generateHash(cli, command);
        //Obtenemos el comando
        Commands cmd = getCommandForInput(command);
        if (cmd == null) {
            //Si es nulo, devolvemos el error de comando no encontrado
            return Errors.COMMAND_NOT_FOUND;
        } else if(cmd == Commands.MATCHMAKING && commandMap.get(Commands.MATCHMAKING.getName()) == null){
            return Errors.WRONG_MATCHMAKING_MODE;
        }   
        //Si no hay ningún problema, ejecutamos el comando
        return commandMap.get(cmd.getName()).execute(command);
    }
}
