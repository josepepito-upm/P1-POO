package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.MatchmakeController;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.MatchmakeModes;

public class ManualTournamentMatchmaking extends TournamentMatchmaking {
    
    public Errors validate(String command) {
        super.validate(command);        
        
        String[] parts = getParts(command);
        
        for (String string : parts) {
                //También se puede poner como parts[2] si queremos que el -m se ponga en un formato específico
                if(string.equals(MatchmakeModes.MANUAL.getMode()))
                    return Errors.NULL;               
        }

        return Errors.WRONG_MATCHAKING_MODE;
    }

    public Errors execute(String command) {
        MatchmakeController matchmakeController = new MatchmakeController(super.getCli());
        if(validate(command).isNull()) {
            matchmakeController.manualMatchmake(getPlayerData(getParts(command))[0], getPlayerData(getParts(command))[1]);
            return Errors.NULL;
        } else return validate(command);
    }   
}
