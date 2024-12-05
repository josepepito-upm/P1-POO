package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.types.Errors;

public class TeamAdd extends AdminCommands {
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length < 2) {
            return Errors.FORMAT_ERROR;
        }
        String[] playerData = parts[1].split(";");
        if (playerData.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        //comprobar que el jugador no este en el equipo
        for (Player existingPlayer : playerList.getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) {
                return Errors.EXISTING_PLAYER;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            new TeamController(cli).add("");
            return null;
        } else return validate(command);
        
    }
}
