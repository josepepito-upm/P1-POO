package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.types.Errors;

public class TeamRemove extends PlayerCommands {

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        //comprobar que el jugador este en el equipo
        for (Player existingPlayer : playerList.getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) { 
                return Errors.PLAYER_NOT_IN_TEAM;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            new TeamController(cli).remove("");
            return null;
        } else return validate(command);
        
    }
}
