package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.types.Errors;

public class TeamRemove extends AdminCommands {

    private TeamController teamController; 

    public TeamRemove(TeamController teamController) {
        this.teamController = teamController; 
    }
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        String[] commandData = parts[1].split(";");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR; 
        }
        if (commandData.length != 2) {
            return Errors.FORMAT_ERROR; 
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] commandData = parts[1].split(";");

        Errors validationError = validate(command); 
        if (validationError != null) {
            return validationError;
        }
        teamController.remove(commandData[0], commandData[1]);
        return Errors.NULL;
    }
}
