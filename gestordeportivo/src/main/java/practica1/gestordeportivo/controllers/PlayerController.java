package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.views.Message;

public class PlayerController {
   
    protected CommandLineInterpreter cli;
    private Message message;
    
    public PlayerController (CommandLineInterpreter cli) {
        this.cli = cli;
    }

    public Player getPlayerById(String playerId) {
        for (Player player : cli.getPlayerList().getPlayers()) {
            if (player.getId().equals(playerId)) {
                return player;
            }
        }
        return null;
    }

    public void create(String username, String password, String forename, String surname, String id) {
        cli.getPlayerList().getPlayers().add(new Player(username, password, forename, surname, id));
        message.writeMessage(Message.PLAYER_CREATED);
    }

    public void delete(Player player) {
        cli.getPlayerList().getPlayers().remove(player);
        message.writeMessage(Message.PLAYER_DELETED);
    }

    public Errors showStatistics(Player player) {
        if (player == null) {
            System.out.println("Jugador no encontrado.");
            return Errors.NON_EXISTING_PLAYER;
        }

        System.out.println("Estadísticas de " + player.getForename() + " " + player.getSurname() + ":");
        
        // Accede a las estadísticas del jugador (basado en la clase Player)
        String[] statsNames = {"Puntos marcados", "Partidos ganados", "Puntos de asistencia", "Torneos ganados", "Dinero generado"};
        double[] statsValues = player.getStats().getStats(); // Suponiendo que getStats() devuelve un array de valores estadísticos

        for (int i = 0; i < statsNames.length; i++) {
            System.out.println(statsNames[i] + ": " + statsValues[i]);
        }
        return null;
        
    }
}