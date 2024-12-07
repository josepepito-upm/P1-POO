package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;

public class TeamAdd extends AdminCommands {

    CommandLineInterpreter cli;
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        String[] commandData = parts[1].split(";");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }   
        if (commandData.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        for (Player player : cli.getTeamList().getTeam(commandData[1]).getMembers()) {
            if (player.getId().equals(commandData[0])) {
                return Errors.PLAYER_IN_TEAM;
            }
        }
        return null;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] commandData = parts[1].split(";");

        if(validate(command) == null) {
            new TeamController(cli).add(commandData[0], commandData[1]);
            cli.getTeamList().getTeam(commandData[1]).updateStats();
            return null;
        } else return validate(command);
    }
}
