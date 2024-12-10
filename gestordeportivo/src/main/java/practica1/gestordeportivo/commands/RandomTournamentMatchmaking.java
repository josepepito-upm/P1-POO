package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.MatchmakeModes;
import practica1.gestordeportivo.controllers.MatchmakeController;

public class RandomTournamentMatchmaking extends TournamentMatchmaking{

    public Errors validate(String command) {
        super.validate(command);        
        
        String[] parts = getParts(command);
        
        for (String string : parts) {
                if(string.equals(MatchmakeModes.RANDOM.getMode()))
                    return Errors.NULL;               
        }
        return Errors.WRONG_MATCHMAKING_MODE;
    }

    public Errors execute(String command) {
        MatchmakeController matchmakeController = new MatchmakeController();  
        if(validate(command).isNull()) {
            matchmakeController.autoMatchmake();
            return Errors.NULL;
        } else return validate(command);
    }
}