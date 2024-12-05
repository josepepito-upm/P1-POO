package practica1.gestordeportivo.views;

public enum Message {
    
    PLAYER_CREATED("Jugador creado."),
    PLAYER_DELETED("Jugador borrado."),
    TEAM_CREATED("Equipo creado."),
    TEAM_DELETED("Equipo borrado."),
    TOURNAMENT_CREATED("Torneo creado."),
    TOURNAMENT_DELETED("Torneo borrado.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void writeMessage(Message message) {
        System.out.println(message.toSring());
    }

    public String toSring() {
        return message;
    }
}
