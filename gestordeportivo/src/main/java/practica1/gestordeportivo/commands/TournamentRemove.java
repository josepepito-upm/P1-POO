package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;

public class TournamentRemove extends PlayerCommands {
    private TournamentController tournamentController;
    private PlayerController playerController; 

    public TournamentRemove(TournamentController tournamentController) {
        this.tournamentController = tournamentController; 
    }

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }

        String[] playerData = parts[1].split(";");

        Player player = playerController.getPlayerById(playerData[0]); 
        if (player == null) {
            return Errors.PLAYER_NOT_IN_TOURNAMENT; 
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        Errors validationError = validate(command);
        if (validationError != null) {
            return validationError; 
        }
        String[] parts = command.split(" ");
        String[] playerData = parts[1].split(";");
        
        tournamentController.removePlayer(playerData[0]);

        return Errors.NULL;
        
    }

}
