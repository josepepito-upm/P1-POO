package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.types.Errors;

public class TournamentDelete extends AdminCommands {

    private TournamentController tournamentController;

    public TournamentDelete(TournamentController tournamentController) {
        this.tournamentController = tournamentController;
    }

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        return null; 
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        Errors validationError = validate(command);
        if (validationError != null) {
            return validationError; 
        }

        // Ejecutamos la lógica del controlador
        tournamentController.delete(parts[1]);
        return Errors.NULL;
    }
}
