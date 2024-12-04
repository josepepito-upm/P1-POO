package practica1.gestordeportivo.types;

enum Commands {
    CREATE_PLAYER("player-create"), 
    CREATE_TEAM,
    CREATE_TOURNAMENT;

    private String name;
    
    enum Commands(String name) {
        this.name = name;
    }
}
