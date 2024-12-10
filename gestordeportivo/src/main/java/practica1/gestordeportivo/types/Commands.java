package practica1.gestordeportivo.types;

import practica1.gestordeportivo.commands.*;

public enum Commands {
   //pull request 
    CREATE_PLAYER("player-create", new PlayerCreate()), 
    CREATE_TEAM("team-create", new TeamCreate()),
    CREATE_TOURNAMENT("tournament-create", new TournamentCreate()),
    DELETE_PLAYER("player-delete", new PlayerDelete()),
    DELETE_TEAM("team-delete", new TeamDelete()),
    DELETE_TOURNAMENT("tournament-delete", new TournamentDelete()),
    ADD_TEAM("team-add", new TeamAdd()),
    REMOVE_TEAM("team-remove", new TeamRemove()),
    MATCHMAKING("tournament-matchmaking", MatchmakeModes.commandInterface),
    ADD_TOURNAMENT("tournament-add", new TournamentAdd()),
    REMOVE_TOURNAMENT("tournament-remove", new TournamentRemove()),
    SHOW_STATISTICS("statistics-show", new StatisticsShow()),
    LIST("tournament-list", new ListTournaments()),
    LOGIN("login", new Login()),
    LOGOUT("logout", new Logout());

    private final String name;
    private final CommandInterface commandInterface;    
    
    Commands(String name, CommandInterface commandInterface) {
        this.name = name;
        this.commandInterface = commandInterface;
    }

    
        public CommandInterface getCommand() {
        return commandInterface;
    }

    public String getName() {
        return name;
    }
    
}
