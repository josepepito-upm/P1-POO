package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.models.lists.TeamList;
import practica1.gestordeportivo.types.Errors;

public class TeamDelete extends AdminCommands {
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        //no caigo ahora en como poner la playerlist ajskdjas
        if(!TeamList.contains(parts[2])) {
            return Errors.NON_EXISTING_TEAM;
        }
        if(/*comprobar que el equipo no este en un torneo en curso */) {
            return Errors.TEAM_IN_TOURNAMENT;
        }
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            new TeamController(cli).delete("");
            return null;
        } else return validate(command);
    }
}
