package practica1.gestordeportivo.views;

import practica1.gestordeportivo.types.Commands;

public enum Message {
    
    PLAYER_CREATED("Jugador creado.", Commands.CREATE_PLAYER),
    PLAYER_DELETED("Jugador borrado.", Commands.DELETE_PLAYER),
    TEAM_CREATED("Equipo creado.", Commands.CREATE_TEAM),
    TEAM_DELETED("Equipo borrado.", Commands.DELETE_TEAM),
    TOURNAMENT_CREATED("Torneo creado.", Commands.CREATE_TOURNAMENT),
    TOURNAMENT_DELETED("Torneo borrado.", Commands.DELETE_TOURNAMENT),
    PLAYER_ADDED("Jugador inscrito al torneo.", Commands.ADD_TOURNAMENT),
    PLAYER_REMOVED("Jugador dado de baja del torneo.", Commands.REMOVE_TOURNAMENT),
    PLAYER_ADDED_TEAM("Jugador añadido al equipo.", Commands.ADD_TEAM),
    PLAYER_REMOVED_TEAM("Jugador eliminado del equipo.", Commands.REMOVE_TEAM),
    LOGGED_IN("Usuario autenticado en el sistema.", Commands.LOGIN),
    LOGGED_OUT("Usuario desautenticado del sistema.", Commands.LOGOUT);

    private final String message;
    private final Commands command;

    Message(String message, Commands command) {
        this.message = message;
        this.command = command;
    }

    public Commands getCommand() {
        return command;
    }
    public void writeMessage(Message message) {
        System.out.println(message.toSring());
    }
    
    public String toSring() {
        return message;
    }
}
