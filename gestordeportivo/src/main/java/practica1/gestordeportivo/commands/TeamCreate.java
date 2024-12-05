package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.models.Team;
import practica1.gestordeportivo.types.Errors;

public class TeamCreate extends AdminCommands {
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length < 2) {
            return Errors.FORMAT_ERROR;
        }
        //comprobar que no existe el equipo
        for (Team existingTeam : teamList.getTeams()) {
            if (existingTeam.getName().equals(playerData[2])) { // Compara el DNI
                return Errors.EXISTING_TEAM;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            new TeamController(cli).create("");
            return null;
        } else return validate(command);
    }
}
