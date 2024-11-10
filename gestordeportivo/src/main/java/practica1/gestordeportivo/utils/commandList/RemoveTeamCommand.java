package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.team.Team;
import practica1.gestordeportivo.utils.user.player.Player;

public class RemoveTeamCommand extends Command {
    
    public RemoveTeamCommand(String title, String description) {
        super(title, description);
        super.setTitle("team-remove");
        super.setDescription("Elimina a un jugador de un equipo");
    }

    public void remove(Player player, Team team) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
