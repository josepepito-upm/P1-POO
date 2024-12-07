package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.views.CLIView;

public class TournamentAdd extends PlayerCommands {

    CommandLineInterpreter cli;
    CLIView cliView;
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        if (cli.getTournamentList().getTournament(parts[1]).isInProgress()) {
            return Errors.TOURNAMENT_ACTIVE;
        }
        //jugador autenticado en torneo
        for (Player existingPlayer : playerList.getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) { // Compara el DNI
                return Errors.PLAYER_IN_TOURNAMENT;
            }
        }
        //equipo en torneo
        //return Errors.TEAM_IN_TOURNAMENT;
        return null;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        if(validate(command) == null) {
            new TournamentController(cli).addPlayer(parts[1]);
            return null;
        } else return validate(command);   
    }
}
