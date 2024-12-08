package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.Matchmake;
public class MatchmakeController extends Controller{

    // Emparejamiento manual
    public Matchmake manualMatchmake(String player1Name, String player2Name) {
            // Crear el emparejamiento
            Matchmake match = new Matchmake(getCli().getPlayerList(), player1Name, player2Name);
            getCli().getMatchmakeList().add(match); // Añadir el emparejamiento a la lista
            return match;
   }

    // Emparejamiento automático
    public Matchmake autoMatchmake() {
            // Crear el emparejamiento automático
            Matchmake match = getCli().getPlayerList().matchMakeAuto();
            getCli().getMatchmakeList().add(match); // Añadir el emparejamiento a la lista
            return match;
    }

    //Esto va a views
    // Mostrar el emparejamiento
    public void showMatch(Matchmake match) {
        if (match != null) {
            System.out.println("Emparejamiento creado: " + match);
        } else {
            System.out.println("No se ha podido crear el emparejamiento.");
        }
    }
}
