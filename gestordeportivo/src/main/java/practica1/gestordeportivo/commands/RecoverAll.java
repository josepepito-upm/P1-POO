package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.models.CommandLineInterpreter;
public class RecoverAll extends AdminCommands {

    private PlayerController playerController = new PlayerController(cli);
    private TeamController teamController = new TeamController(cli);
    private TournamentController tournamentController = new TournamentController(cli);

    public RecoverAll(CommandLineInterpreter cli) {
        super(cli);
    }
    
    public Errors validate(String command) {
        super.validate(command);

        if (command != "recover-all") {
            return Errors.FORMAT_ERROR; 
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        if(validate(command).isNull()) {
            playerController.recoverAllPlayers();
            teamController.recoverAllTeams();
            tournamentController.recoverAllTournaments();
            return Errors.NULL;
        } else return validate(command);
    }
}
