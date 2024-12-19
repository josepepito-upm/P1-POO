package practica1.gestordeportivo.types;

import java.util.function.Function;

import practica1.gestordeportivo.commands.*;
import practica1.gestordeportivo.models.CommandLineInterpreter;

public enum Commands {
    CREATE_PLAYER("player-create", PlayerCreate::new),
    CREATE_TEAM("team-create", TeamCreate::new),
    CREATE_TOURNAMENT("tournament-create", TournamentCreate::new),
    DELETE_PLAYER("player-delete", PlayerDelete::new),
    DELETE_TEAM("team-delete", TeamDelete::new),
    DELETE_TOURNAMENT("tournament-delete", TournamentDelete::new),
    ADD_TEAM("team-add", TeamAdd::new),
    REMOVE_TEAM("team-remove", TeamRemove::new),
    MATCHMAKING("tournament-matchmaking", MatchmakeModes.commandInterface),
    DD_TOURNAMENT("tournament-add", TournamentAdd::new),
    REMOVE_TOURNAMENT("tournament-remove", TournamentRemove::new),
    SHOW_STATISTICS("statistics-show", StatisticsShow::new),
    LIST("tournament-list", ListTournaments::new),
    LOGIN("login", new Login()),
    LOGOUT("logout", new Logout()),
    SAVEALL("save-all", SaveAll::new),
    RECOVERALL("recover-all", RecoverAll::new);
    private final String name;
    private final CommandInterface commandInterface;    
    private final Function<CommandLineInterpreter, CommandInterface> commandFactory;

    
    Commands(String name, Function<CommandLineInterpreter, CommandInterface> commandFactory) {
        this.name = name;
        this.commandFactory = commandFactory;
    }
    
    public void initialize(CommandLineInterpreter cli) {
        this.commandInterface = commandFactory.apply(cli);
    }
    
    public CommandInterface getCommand() {
        return commandInterface;
    }

    public String getName() {
        return name;
    }
    
}
