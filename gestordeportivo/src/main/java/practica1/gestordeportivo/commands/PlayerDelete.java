package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.types.Errors;

public class PlayerDelete extends AdminCommands {

    CommandLineInterpreter cli;
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        for (Player player : cli.getPlayerList().getPlayers()) {
            if (!(player.getId().equals(parts[1]))) {
                return Errors.NON_EXISTING_PLAYER;
            }
        }
        for (Tournament tournament : cli.getTournamentList().getTournaments()) {
            for (Player player : tournament.getParticipants()) {
                if (!player.getId().equals(parts[1])) {
                    return Errors.NON_EXISTING_PLAYER;
                }
            }
        }
        return null;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        if(validate(command) == null) {
            new PlayerController(cli).delete(cli.getPlayerList().getPlayer(parts[1]));
            return null;
        } else return validate(command);
    }
}
