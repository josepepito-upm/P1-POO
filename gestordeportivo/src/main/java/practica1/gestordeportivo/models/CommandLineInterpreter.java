package practica1.gestordeportivo.models;

import practica1.gestordeportivo.models.lists.MatchmakeList;
import practica1.gestordeportivo.models.lists.PlayerList;
import practica1.gestordeportivo.models.lists.TeamList;
import practica1.gestordeportivo.models.lists.TournamentList;
import practica1.gestordeportivo.types.Role;

public class CommandLineInterpreter {
    
    private PlayerList playerList;
    private MatchmakeList matchmakeList;
    private TeamList teamList;
    private TournamentList tournamentList;
    private User authenticatedUser;

    public CommandLineInterpreter() {
        playerList = new PlayerList();
        matchmakeList = new MatchmakeList();
        teamList = new TeamList();
        tournamentList = new TournamentList();
        authenticatedUser = new User("Guest", null);
        authenticatedUser.setRole(Role.GUEST);
    
        //Commands.initializeCommands(this);
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

    public void setAuthenticatedUser(User user) {
        this.authenticatedUser = user;
    }
    
    public User getAuthenticatedUser() {
        return this.authenticatedUser;
    }
    public Admin getAuthenticatedAdmin() {
        return authenticatedUser.getRole() == Role.ADMIN ? (Admin)authenticatedUser : null;
    }

    public Player getAuthenticatedPlayer() {
        return authenticatedUser.getRole() == Role.PLAYER ? (Player)authenticatedUser : null;
    }

    public boolean isAuthenticatedPlayer() {
        return authenticatedUser instanceof Player;
    }
}
