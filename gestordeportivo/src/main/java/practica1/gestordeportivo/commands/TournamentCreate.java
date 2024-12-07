package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.types.Errors;

public class TournamentCreate extends AdminCommands {

    CommandLineInterpreter cli;
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        String[] tournamentData = parts[1].split(";");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        if (tournamentData.length != 5) {
            return Errors.FORMAT_ERROR;
        }
        for (Tournament tournament : cli.getTournamentList().getTournaments()) {
            if (tournament.getName().equals(tournamentData[0])) { 
                return Errors.EXISTING_TOURNAMENT;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] tournamentData = parts[1].split(";");
        
        if(validate(command) == null) {
            new TournamentController(cli).create(tournamentData[0], tournamentData[1], tournamentData[2], tournamentData[3], tournamentData[4]);
            return null;
        } else return validate(command);
    }
}
