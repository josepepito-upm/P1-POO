package practica1.gestordeportivo.models;

import practica1.gestordeportivo.commands.CommandInterface;
import practica1.gestordeportivo.models.lists.MatchmakeList;
import practica1.gestordeportivo.models.lists.PlayerList;
import practica1.gestordeportivo.models.lists.TeamList;
import practica1.gestordeportivo.models.lists.TournamentList;
import practica1.gestordeportivo.types.Commands;
import practica1.gestordeportivo.types.Errors;

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
    public MatchmakeList getMatchmakeList() {
        return matchmakeList;
    }
    public TeamList getTeamList() {
        return teamList;
    }
    public TournamentList getTournamentList() {
        return tournamentList;
    }

    public Errors executeCommand(String command, CommandInterface cmdCommandInterface, Commands commandList) {
        int i = 0;
        while (i <= commandList.values().length) {
            if(command.contains(commandList.get(i).getName())) {
                return cmdCommandInterface.execute(command);
            }
            i++;
        }

        return Errors.COMMAND_NOT_FOUND;
    }

}
