package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.types.Errors;

public class TournamentDelete extends AdminCommands {

    CommandLineInterpreter cli;
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        for (Tournament tournament : cli.getTournamentList().getTournaments()) {
            if (!(tournament.getName().equals(parts[1]))) {
                return Errors.NON_EXISTING_TOURNAMENT;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        if(validate(command) == null) {
            new TournamentController(cli).delete(cli.getTournamentList().getTournament(parts[1]));
            return null;
        } else return validate(command);
    }
}
