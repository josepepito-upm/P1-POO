package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.models.CommandLineInterpreter;
public class TournamentRemove extends PlayerCommands {
    
    private TournamentController tournamentController = new TournamentController(cli);
    public TournamentRemove(CommandLineInterpreter cli) {
        super(cli);
    }
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        for (Player player : tournamentController.getCli().getTournamentList().getTournament(parts[1]).getParticipants()) {
            if (!(player.getId().equals(parts[0]))) {
                return Errors.PLAYER_NOT_IN_TOURNAMENT;
            }
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        if(validate(command).isNull()) {
            tournamentController.removePlayer(parts[1]);
            return Errors.NULL;
        } else return validate(command);
        
    }

}
