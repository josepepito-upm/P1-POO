package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.team.Team;
import practica1.gestordeportivo.utils.user.player.Player;

public class AddTeamCommand extends Command {
    
    public AddTeamCommand(String title, String description) {
        super(title, description);
        super.setTitle("team-add");
        super.setDescription("Añade un jugador a un equipo.");
    }

    public void add(Player player, Team team) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
