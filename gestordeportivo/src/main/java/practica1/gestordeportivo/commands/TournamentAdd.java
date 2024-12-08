package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.types.Errors;
public class TournamentAdd extends PlayerCommands {
    
    private TournamentController controller;
    public TournamentAdd(TournamentController controller) {
        this.controller = controller;
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
        Errors validationError = validate(command);
        if (validationError != null) {
            return validationError; // Retornar error si la validación falla
        }

        // Ejecutar la acción en el controlador
        String tournamentName = command.split(" ")[1];
        controller.addPlayer(tournamentName);
        return null;
    }
}
