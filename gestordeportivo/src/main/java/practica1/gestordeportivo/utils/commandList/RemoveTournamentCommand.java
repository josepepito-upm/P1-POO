package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.tournament.Tournament;

public class RemoveTournamentCommand extends Command {
    
    public RemoveTournamentCommand(String title, String description) {
        super(title, description);
        super.setTitle("tournament-remove");
        super.setDescription("Da de baja al jugador autenticado de un torneo o a su equipo (-t)");
    }

    public void remove(Tournament tournament) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
