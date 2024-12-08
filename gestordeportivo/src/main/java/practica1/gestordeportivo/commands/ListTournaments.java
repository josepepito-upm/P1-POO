package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.types.Errors;

public class ListTournaments extends PublicCommands {
    private TournamentController tournamentController;

    public ListTournaments(TournamentController tournamentController) {
        this.tournamentController = tournamentController;
    }

    public Errors execute(String command) {
        Errors validationErrors = validate(command);

        if (validationErrors != null) {
            return validationErrors;
        }

        tournamentController.listTournaments();
        return null;
    }

    public Errors validate(String command){
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 1) {
            return Errors.FORMAT_ERROR; 
        }

        return null;
        
    }
}
