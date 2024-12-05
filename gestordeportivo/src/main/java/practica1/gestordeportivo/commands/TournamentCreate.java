package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.types.Errors;

public class TournamentCreate extends AdminCommands {
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        //comprobar que no existe el torneo
        for (Tournament existingTournament : tournamentList.getTeams()) {
            if (existingTournament.getName().equals("")) { 
                return Errors.EXISTING_TOURNAMENT;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            new TournamentController(cli).create("");
            return null;
        } else return validate(command);
    }
}
