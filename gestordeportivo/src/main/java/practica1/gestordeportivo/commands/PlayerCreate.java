package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;

public class PlayerCreate extends AdminCommands {

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length < 2) {
            return Errors.FORMAT_ERROR;
        }
        String[] playerData = parts[1].split(";");
        if (playerData.length < 4) {
            return Errors.FORMAT_ERROR;
        }
        for (Player existingPlayer : playerList.getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) { // Compara el DNI
                return Errors.EXISTING_PLAYER;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            new PlayerController(cli).create(playerData);
            return null;
        } else return validate(command);
        
    }
}
