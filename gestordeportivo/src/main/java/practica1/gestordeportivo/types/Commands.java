package practica1.gestordeportivo.types;

import practica1.gestordeportivo.commands.*;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import java.util.HashMap;
import java.util.Map;

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

    private final String name;
    private CommandInterface commandInterface;

    Commands(String name) {
        this.name = name;
    }

    public static void initializeCommands(CommandLineInterpreter cli) {
        Map<String, CommandInterface> commandMap = new HashMap<>();
        commandMap.put("player-create", new PlayerCreate(cli));
        commandMap.put("team-create", new TeamCreate(cli));
        commandMap.put("tournament-create", new TournamentCreate(cli));
        commandMap.put("player-delete", new PlayerDelete(cli));
        commandMap.put("team-delete", new TeamDelete(cli));
        commandMap.put("tournament-delete", new TournamentDelete(cli));
        commandMap.put("team-add", new TeamAdd(cli));
        commandMap.put("team-remove", new TeamRemove(cli));
        commandMap.put("tournament-matchmaking", MatchmakeModes.commandInterface);
        commandMap.put("tournament-add", new TournamentAdd(cli));
        commandMap.put("tournament-remove", new TournamentRemove(cli));
        commandMap.put("statistics-show", new StatisticsShow(cli));
        commandMap.put("tournament-list", new ListTournaments(cli));
        commandMap.put("login", new Login(cli));
        commandMap.put("logout", new Logout(cli));
        commandMap.put("save-all", new SaveAll(cli));
        commandMap.put("recover-all", new RecoverAll(cli));

        for (Commands command : Commands.values()) {
            command.commandInterface = commandMap.get(command.name);
        }
    }



    public static Commands getCommandForInput(String input) {
        for (Commands command : Commands.values()) {
            if (input.startsWith(command.name)) {
                return command;
            }
        }
        return null; // No se encontró un comando válido
    }
    public void initialize(CommandInterface commandInterface) {
        this.commandInterface = commandInterface;
    }

    public CommandInterface getCommand() {
        return commandInterface;
    }

    public String getName() {
        return name;
    }
}
