package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.tournament.Tournament;

public class CreateTournamentCommand extends Command {
    
    public CreateTournamentCommand(String title, String description) {
        super(title, description);
        super.setTitle("tournament-create");
        super.setDescription("Crea un torneo");
    }

    public void create(Tournament tournament) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
