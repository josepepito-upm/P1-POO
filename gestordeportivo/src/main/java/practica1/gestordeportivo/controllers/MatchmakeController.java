package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.Matchmake;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.models.lists.MatchmakeList;
import practica1.gestordeportivo.models.lists.PlayerList;

public class MatchmakeController {

    private MatchmakeList matchmakeList;
    private PlayerList playerList;
    
    public MatchmakeController(PlayerList playerList, MatchmakeList matchmakeList) {
        this.playerList = playerList;
        this.matchmakeList = matchmakeList;
    }

    // Emparejamiento manual
    public Matchmake manualMatchmake(String player1Name, String player2Name) {
        try {
            Player player1 = playerList.getPlayer(player1Name); // Obtener los jugadores por nombre
            Player player2 = playerList.getPlayer(player2Name);

            // Crear el emparejamiento
            Matchmake match = new Matchmake(player1, player2);
            matchmakeList.add(match); // Añadir el emparejamiento a la lista
            return match;

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

    // Emparejamiento automático
    public Matchmake autoMatchmake() {
        try {
            // Crear el emparejamiento automático
            Matchmake match = playerList.matchMakeAuto();
            matchmakeList.add(match); // Añadir el emparejamiento a la lista
            return match;

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

    // Mostrar el emparejamiento
    public void showMatch(Matchmake match) {
        if (match != null) {
            System.out.println("Emparejamiento creado: " + match);
        } else {
            System.out.println("No se ha podido crear el emparejamiento.");
        }
    }
}
