package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Matchmake;

public class MatchmakeController extends Controller{

    public MatchmakeController(CommandLineInterpreter cli) {
        super(cli);
    }
    
    public Matchmake manualMatchmake(String player1Name, String player2Name) {
            Matchmake match = new Matchmake(getCli().getPlayerList(), player1Name, player2Name);
            getCli().getMatchmakeList().add(match); 
            return match;
   }

    public Matchmake autoMatchmake() {
        Matchmake match = getCli().getPlayerList().matchMakeAuto();
        getCli().getMatchmakeList().add(match); 
        return match;
    }
}
