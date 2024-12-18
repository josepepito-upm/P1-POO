package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.MatchmakeController;
import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.types.Errors;

public class SaveAll extends AdminCommands {
    
    private PlayerController playerController = new PlayerController();
    private TeamController teamController = new TeamController();
    private TournamentController tournamentController = new TournamentController();
    private MatchmakeController matchmakeController = new MatchmakeController();
    
    public Errors validate(String command) {
        super.validate(command);

        if (command != "save-all") {
            return Errors.FORMAT_ERROR; 
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        if(validate(command).isNull()) {
            playerController.saveAllPlayers();
            teamController.saveAllTeams();
            tournamentController.saveAllTournaments();
            return Errors.NULL;
        } else return validate(command);
    }
}
