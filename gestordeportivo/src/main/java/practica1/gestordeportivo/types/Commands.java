package practica1.gestordeportivo.types;
import practica1.gestordeportivo.commands.*;
import practica1.gestordeportivo.views.CLIView;

public enum Commands {
    CREATE_PLAYER("player-create", null), 
    CREATE_TEAM("team-create", null),
    CREATE_TOURNAMENT("tournament-create", null),
    DELETE_PLAYER("player-delete", null),
    DELETE_TEAM("team-delete", null),
    DELETE_TOURNAMENT("tournament-delete", null),
    ADD_TEAM("team-add", null),
    REMOVE_TEAM("team-remove", null),
    MATCHMAKING("tournament-matchmaking", null),
    ADD_TOURNAMENT("tournament-add", null),
    REMOVE_TOURNAMENT("tournament-remove", null),
    SHOW_STATISTICS("statistics-show", null),
    LIST("tournament-list", null),
    LOGIN("login", null),
    LOGOUT("logout", null),
    SAVEALL("save-all", null),
    RECOVERALL("recover-all", null);

    private final String name;
    private CommandInterface commandInterface; 
    private static CLIView cliView;

    Commands(String name, CommandInterface commandInterface) {
        this.name = name;
        this.commandInterface = commandInterface;
    }

    public static void initialize(CLIView cliView) {
        Commands.cliView = cliView;
        
        CREATE_PLAYER.commandInterface = new PlayerCreate(cliView.getPlayerController());
        CREATE_TEAM.commandInterface = new TeamCreate(cliView.getPlayerController());
        CREATE_TOURNAMENT.commandInterface = new TournamentCreate(cliView.getPlayerController());
        DELETE_PLAYER.commandInterface = new PlayerDelete(cliView.getPlayerController());
        DELETE_TEAM.commandInterface = new TeamDelete(cliView.getPlayerController());
        DELETE_TOURNAMENT.commandInterface = new TournamentDelete(cliView.getPlayerController());
        ADD_TEAM.commandInterface = new TeamAdd(cliView.getPlayerController());
        REMOVE_TEAM.commandInterface = new TeamRemove(cliView.getPlayerController());
        MATCHMAKING.commandInterface = MatchmakeModes.commandInterface;
        ADD_TOURNAMENT.commandInterface = new TournamentAdd(cliView.getPlayerController());
        REMOVE_TOURNAMENT.commandInterface = new TournamentRemove(cliView.getPlayerController());
        SHOW_STATISTICS.commandInterface = new StatisticsShow(cliView.getPlayerController());
        LIST.commandInterface = new ListTournaments(cliView.getUserController());
        LOGIN.commandInterface = new Login(cliView.getUserController());
        LOGOUT.commandInterface = new Logout(cliView.getUserController());
        SAVEALL.commandInterface = new SaveAll(cliView.getPlayerController());
        RECOVERALL.commandInterface = new RecoverAll(cliView.getPlayerController());
    }

    public CommandInterface getCommand() {
        return commandInterface;
    }

    public String getName() {
        return name;
    }
}
