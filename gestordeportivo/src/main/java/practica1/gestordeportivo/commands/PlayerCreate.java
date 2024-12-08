package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.types.Errors;

public class PlayerCreate extends AdminCommands {

    private PlayerController playerController;

    public PlayerCreate(PlayerController playerController) {
        this.playerController = playerController;
    }

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }

        String[] playerData = parts[1].split(";");
        if (playerData.length != 5) {
            return Errors.FORMAT_ERROR;
        }

        if (playerController.playerExists(playerData[4])) {
            return Errors.EXISTING_PLAYER;
        }

        return null;
    }

    public Errors execute(String command) {
        Errors validationErrors = validate(command);
        if (validationErrors != null) {
            return validationErrors;
        }

        String[] parts = command.split(" ");
        String[] playerData = parts[1].split(";");
        playerController.create(playerData[0], playerData[1], playerData[2], playerData[3], playerData[4]);
        return null;
    }
}
