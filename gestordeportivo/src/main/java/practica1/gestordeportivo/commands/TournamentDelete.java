package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.types.Errors;

public class TournamentDelete extends AdminCommands {
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        //no caigo ahora en como poner la tournamentlist ajskdjas
        if(!TournamentList.contains(parts[2])) {
            return Errors.NON_EXISTING_TOURNAMENT;
        }
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            new TournamentController(cli).delete(.....);
            return null;
        } else return validate(command);
        
    }
}
