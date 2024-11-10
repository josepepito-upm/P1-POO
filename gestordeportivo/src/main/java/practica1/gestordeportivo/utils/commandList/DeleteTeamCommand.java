package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.team.Team;

public class DeleteTeamCommand extends Command {
    
    public DeleteTeamCommand(String title, String description) {
        super(title, description);
        super.setTitle("team-delete");
        super.setDescription("Borra un equipo del sistema.");
    }

    public void delete(Team team) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
