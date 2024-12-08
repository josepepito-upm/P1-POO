package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.types.Errors;

public class PlayerCreate extends AdminCommands {

    private PlayerController playerController = new PlayerController();

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        String[] playerData = parts[1].split(";");
        if (playerData.length != 5 || parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }

        if (playerController.getCli().getPlayerList().getPlayer(playerData[4]) != null) {
            return Errors.EXISTING_PLAYER;
        }

        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] playerData = parts[1].split(";");

        if(validate(command).isNull()) {
            playerController.create(playerData[0], playerData[1], playerData[2], playerData[3], playerData[4]);
            return Errors.NULL;
        } else return validate(command);
    }
}    

