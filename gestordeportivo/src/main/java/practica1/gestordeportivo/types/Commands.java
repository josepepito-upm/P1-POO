package practica1.gestordeportivo.types;

import practica1.gestordeportivo.commands.*;
import practica1.gestordeportivo.models.CommandLineInterpreter;

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

    public void initialize(CommandLineInterpreter cli) {
        for (Commands command : Commands.values()) {
            command.commandInterface = switch (command) {
                case CREATE_PLAYER -> new PlayerCreate(cli);
                case CREATE_TEAM -> new TeamCreate(cli);
                case CREATE_TOURNAMENT -> new TournamentCreate(cli);
                case DELETE_PLAYER -> new PlayerDelete(cli);
                case DELETE_TEAM -> new TeamDelete(cli);
                case DELETE_TOURNAMENT -> new TournamentDelete(cli);
                case ADD_TEAM -> new TeamAdd(cli);
                case REMOVE_TEAM -> new TeamRemove(cli);
                case MATCHMAKING -> MatchmakeModes.commandInterface;
                case ADD_TOURNAMENT -> new TournamentAdd(cli);
                case REMOVE_TOURNAMENT -> new TournamentRemove(cli);
                case SHOW_STATISTICS -> new StatisticsShow(cli);
                case LIST -> new ListTournaments(cli);
                case LOGIN -> new Login(cli);
                case LOGOUT -> new Logout(cli);
                case SAVEALL -> new SaveAll(cli);
                case RECOVERALL -> new RecoverAll(cli);
            };
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
