package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.types.Errors;
public class TournamentCreate extends AdminCommands {
    public TournamentCreate(CommandLineInterpreter cli) {
        super(cli);
    }
    private TournamentController tournamentController = new TournamentController(cli);
    
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
        for (Tournament tournament : tournamentController.getCli().getTournamentList().getTournaments()) {
            if (tournament.getName().equals(tournamentData[0])) { 
                return Errors.EXISTING_TOURNAMENT;
            }
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] tournamentData = parts[1].split(";");
        
        if(validate(command).isNull()) {
            tournamentController.create(tournamentData[0], tournamentData[1], tournamentData[2], tournamentData[3], tournamentData[4]);
            return Errors.NULL;
        } else return validate(command);
    }
}
