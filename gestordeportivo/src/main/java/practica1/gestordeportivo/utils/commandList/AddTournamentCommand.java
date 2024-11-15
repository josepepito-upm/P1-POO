package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.tournament.Tournament;

public class AddTournamentCommand extends Command {
    
    public AddTournamentCommand(String title, String description) {
        super(title, description);
        super.setTitle("tournament-add");
        super.setDescription("Añade al jugador autenticado a un torneo o a su equipo (-t).");
    }

    public void add(Tournament tournament) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
