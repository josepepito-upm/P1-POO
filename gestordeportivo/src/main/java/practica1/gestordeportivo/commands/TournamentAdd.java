package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.types.Errors;

public class TournamentAdd extends PlayerCommands {

    private TournamentController tournamentController;

    public TournamentAdd(TournamentController tournamentController) {
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
        tournamentController.addPlayer(parts[1]);
        return Errors.NULL;
    }
}
