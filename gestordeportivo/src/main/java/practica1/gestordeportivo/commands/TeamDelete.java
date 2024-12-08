package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.types.Errors;

public class TeamDelete extends AdminCommands {

    private TeamController teamController;

    public TeamDelete(TeamController teamController) {
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

        teamController.delete(parts[1]);
        return Errors.NULL;
    }
}
