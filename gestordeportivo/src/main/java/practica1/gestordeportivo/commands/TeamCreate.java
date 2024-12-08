package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.types.Errors;

public class TeamCreate extends AdminCommands {

    private TeamController teamController;

    public TeamCreate(TeamController teamController) {
        this.teamController = teamController;
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

        teamController.create(parts[1]);
        return Errors.NULL;
    }
}
