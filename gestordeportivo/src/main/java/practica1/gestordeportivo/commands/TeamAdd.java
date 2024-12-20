package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.models.CommandLineInterpreter;
public class TeamAdd extends AdminCommands {
   protected TeamController teamController = new TeamController(cli); 
    public TeamAdd(CommandLineInterpreter cli) {
        super(cli);
    }
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
        for (Player player : teamController.getCli().getTeamList().getTeam(commandData[1]).getMembers()) {
            if (player.getId().equals(commandData[0])) {
                return Errors.PLAYER_IN_TEAM;
            }
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] commandData = parts[1].split(";");

        if(validate(command).isNull()) {
            new TeamController(cli).add(commandData[0], commandData[1]);
            teamController.getCli().getTeamList().getTeam(commandData[1]).updateStats();
            return Errors.NULL;
        } else return validate(command);
    }
}
