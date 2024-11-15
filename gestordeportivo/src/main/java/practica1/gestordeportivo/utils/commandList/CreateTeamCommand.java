package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.team.Team;

public class CreateTeamCommand extends Command {
    
    public CreateTeamCommand(String title, String description) {
        super(title, description);
        super.setTitle("team-create");
        super.setDescription("Da de alta un equipo en el sistema.");
    }

    public void create(Team team) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
