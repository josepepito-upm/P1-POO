package practica1.gestordeportivo.models;

import practica1.gestordeportivo.commands.CommandInterface;
import practica1.gestordeportivo.commands.ListTournaments;
import practica1.gestordeportivo.models.lists.MatchmakeList;
import practica1.gestordeportivo.models.lists.PlayerList;
import practica1.gestordeportivo.models.lists.TeamList;
import practica1.gestordeportivo.models.lists.TournamentList;

public class CommandLineInterpreter {

    
    PlayerList playerList;
    MatchmakeList matchmakeList;
    TeamList teamList;
    TournamentList tournamentList;

    public CommandLineInterpreter() {
        playerList = new PlayerList();
        matchmakeList = new MatchmakeList();
        teamList = new TeamList();
        tournamentList = new TournamentList();
    }

    public PlayerList getPlayerList() {
        return playerList;
    }


        public void executeCommand(String command) {
        CommandInterface cmd = null;

        if (command.startsWith("tournament-list")) {
            cmd = new ListTournaments();
        }

        if (cmd != null && cmd.validate()) {
            Error error = cmd.execute(command);
            if (error != null) {
                System.out.println("Error: " + error.getMessage());
            }
        } else {
            System.out.println("Comando no válido o no reconocido.");
        }
    }

}
