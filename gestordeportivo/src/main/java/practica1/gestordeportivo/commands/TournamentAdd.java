package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.types.Errors;
public class TournamentAdd extends PlayerCommands {
    
    private TournamentController tournamentController = new TournamentController();

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }

        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        if(validate(command).isNull()) {
            tournamentController.addPlayer(parts[1]);
            return Errors.NULL;
        } else return validate(command);
    }
}
