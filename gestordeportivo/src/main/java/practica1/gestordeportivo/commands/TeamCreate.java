package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Team;
import practica1.gestordeportivo.types.Errors;

public class TeamCreate extends AdminCommands {

    CommandLineInterpreter cli;
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        for (Team team : cli.getTeamList().getTeams()) {
            if (team.getName().equals(parts[1])) {
                return Errors.EXISTING_TEAM;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        
        if(validate(command) == null) {
            new TeamController(cli).create(parts[1]);
            return null;
        } else return validate(command);
    }
}
