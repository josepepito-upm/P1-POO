package practica1.gestordeportivo.models;

import practica1.gestordeportivo.commands.CommandInterface;
import practica1.gestordeportivo.models.lists.MatchmakeList;
import practica1.gestordeportivo.models.lists.PlayerList;
import practica1.gestordeportivo.models.lists.TeamList;
import practica1.gestordeportivo.models.lists.TournamentList;
import practica1.gestordeportivo.types.Commands;
import practica1.gestordeportivo.types.Errors;

public class CommandLineInterpreter {
    
    private PlayerList playerList;
    private MatchmakeList matchmakeList;
    private TeamList teamList;
    private TournamentList tournamentList;
    private User user;

    public CommandLineInterpreter(User user) {
        playerList = new PlayerList();
        matchmakeList = new MatchmakeList();
        teamList = new TeamList();
        tournamentList = new TournamentList();
        this.user = user;
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
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;    
    }

    public Errors executeCommand(String command, CommandInterface cmdCommandInterface, Commands commandList) {
        for (Commands commands : Commands.values()) {
            if(command.contains(commands.getName())) {
                return cmdCommandInterface.execute(command);
            }
        }
        return Errors.COMMAND_NOT_FOUND;
    }

}
