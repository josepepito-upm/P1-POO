package practica1.gestordeportivo.types;

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
    LOGOUT("logout");

    private final String name;
    
    Commands(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Commands get(int index) {
        assert index >= 0 && index <= Commands.LOGOUT.ordinal();
        return Commands.values()[index];
    }
}
