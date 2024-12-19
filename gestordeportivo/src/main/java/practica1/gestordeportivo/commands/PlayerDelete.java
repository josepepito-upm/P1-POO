package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.models.CommandLineInterpreter;
public class PlayerDelete extends AdminCommands {
    
    private PlayerController playerController = new PlayerController(cli);


    public PlayerDelete(CommandLineInterpreter cli) {
        super(cli);
    }
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        for (Player player : playerController.getCli().getPlayerList().getPlayers()) {
            if (!(player.getId().equals(parts[1]))) {
                return Errors.NON_EXISTING_PLAYER;
            }
        }
        for (Tournament tournament : playerController.getCli().getTournamentList().getTournaments()) {
            for (Player player : tournament.getParticipants()) {
                if (!player.getId().equals(parts[1])) {
                    return Errors.NON_EXISTING_PLAYER;
                }
            }
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        if(validate(command).isNull()) {
            playerController.delete(playerController.getCli().getPlayerList().getPlayer(parts[1]));
            return Errors.NULL;
        } else return validate(command);
    }
}
