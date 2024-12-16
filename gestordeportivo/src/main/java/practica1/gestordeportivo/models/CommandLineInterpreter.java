package practica1.gestordeportivo.models;

import practica1.gestordeportivo.models.lists.MatchmakeList;
import practica1.gestordeportivo.models.lists.PlayerList;
import practica1.gestordeportivo.models.lists.TeamList;
import practica1.gestordeportivo.models.lists.TournamentList;
import practica1.gestordeportivo.types.Commands;
import practica1.gestordeportivo.types.Errors;
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
        System.out.println("Usuario autenticado después del login: " + getAuthenticatedUser());
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

    public Errors executeCommand(String command) {
        System.out.println("Comando recibido: " + command); // Depuración

        if (command == null || command.trim().isEmpty()) {
            System.out.println("Error: Comando vacío o nulo.");
            return Errors.SYNTAX_ERROR; 
            
        }

        for (Commands commands : Commands.values()) {
            System.out.println("Verificando comando: " + commands.getName()); // Depuración
            if (command.startsWith(commands.getName())) { 
                System.out.println("Comando reconocido: " + commands.getName()); // Confirmar coincidencia
                return commands.getCommand().execute(command); 
            }
        }
        System.out.println("Error: Comando no encontrado.");
        return Errors.COMMAND_NOT_FOUND;
    }
}
