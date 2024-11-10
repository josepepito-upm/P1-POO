package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.tournament.Tournament;

public class DeleteTournamentCommand extends Command {

    public DeleteTournamentCommand(String title, String description) {
        super(title, description);
        super.setTitle("tournament-delete");
        super.setDescription("Borra un torneo del sistema.");
    }

    public void delete(Tournament tournament) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
