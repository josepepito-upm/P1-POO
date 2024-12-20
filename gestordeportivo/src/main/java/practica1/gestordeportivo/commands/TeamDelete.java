package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.models.Team;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.models.CommandLineInterpreter;
public class TeamDelete extends AdminCommands {

    private TeamController teamController = new TeamController(cli);
    public TeamDelete(CommandLineInterpreter cli) {
        super(cli);
    } 
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        for (Team team : teamController.getCli().getTeamList().getTeams()) {
            if (!(team.getName().equals(parts[1]))) {
                return Errors.NON_EXISTING_TEAM;
            }
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        if(validate(command).isNull()) {
            teamController.delete(teamController.getCli().getTeamList().getTeam(parts[1]));
            return Errors.NULL;
        } else return validate(command);
    }
}
