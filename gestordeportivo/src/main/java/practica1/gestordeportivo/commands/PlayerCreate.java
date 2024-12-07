package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;

public class PlayerCreate extends AdminCommands {

    CommandLineInterpreter cli;

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        String[] playerData = parts[1].split(";");

        if (parts.length < 2) {
            return Errors.FORMAT_ERROR;
        }
        if (playerData.length != 5) {
            return Errors.FORMAT_ERROR;
        }
        for (Player player : cli.getPlayerList().getPlayers()) {
            if (player.getId().equals(playerData[4])) {
                return Errors.EXISTING_PLAYER;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] playerData = parts[1].split(";");

        if(validate(command) == null) {
            new PlayerController(cli).create(playerData[0], playerData[1], playerData[2], playerData[3], playerData[4]);
            return null;
        } else return validate(command);
        
    }
}
