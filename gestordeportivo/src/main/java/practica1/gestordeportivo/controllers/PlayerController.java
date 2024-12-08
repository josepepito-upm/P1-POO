package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.views.Message;

public class PlayerController extends Controller{
   
    private Message message;
    
    public void create(String username, String password, String forename, String surname, String id) {
        getCli().getPlayerList().getPlayers().add(new Player(username, password, forename, surname, id));
        message.writeMessage(Message.PLAYER_CREATED);
    }

    public void delete(Player player) {
        getCli().getPlayerList().getPlayers().remove(player);
        message.writeMessage(Message.PLAYER_DELETED);
    }

    //Esto va a Views
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