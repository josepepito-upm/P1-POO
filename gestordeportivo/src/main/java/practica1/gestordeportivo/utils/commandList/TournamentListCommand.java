package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;

public class TournamentListCommand extends Command {
    
    public TournamentListCommand(String title, String description) {
        super(title, description);
        super.setTitle("tournament-list");
        super.setDescription("Lista los torneos del sistema.");
    }

    public void list() {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
