package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.types.Errors;

public class TournamentCreate extends AdminCommands {

    private TournamentController tournamentController;

    // Constructor que recibe el controlador
    public TournamentCreate(TournamentController tournamentController) {
        this.tournamentController = tournamentController;
    }

    // Método de validación
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

        // if (tournamentController.tournamentExists(tournamentData[0])) {
        //     return Errors.EXISTING_TOURNAMENT;
        // }

        return null;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] tournamentData = parts[1].split(";");

        Errors validationError = validate(command);
        if (validationError != null) {
            return validationError; 
        }

        tournamentController.create(tournamentData[0], tournamentData[1], tournamentData[2], tournamentData[3], tournamentData[4]);

        return Errors.NULL; 
    }
}
