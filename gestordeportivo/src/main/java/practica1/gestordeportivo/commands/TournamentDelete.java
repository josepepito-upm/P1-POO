package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.models.CommandLineInterpreter;
public class TournamentDelete extends AdminCommands {
    public TournamentDelete(CommandLineInterpreter cli) {
        super(cli);
    }
    private TournamentController tournamentController = new TournamentController(cli);
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        for (Tournament tournament : tournamentController.getCli().getTournamentList().getTournaments()) {
            if (!(tournament.getName().equals(parts[1]))) {
                return Errors.NON_EXISTING_TOURNAMENT;
            }
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        if(validate(command).isNull()) {
            tournamentController.delete(tournamentController.getCli().getTournamentList().getTournament(parts[1]));
            return Errors.NULL;
        } else return validate(command);
    }
}
