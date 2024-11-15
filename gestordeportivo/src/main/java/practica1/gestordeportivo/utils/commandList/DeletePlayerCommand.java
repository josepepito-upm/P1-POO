package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.user.player.Player;

public class DeletePlayerCommand extends Command {
    
    public DeletePlayerCommand(String title, String description) {
        super(title, description);
        super.setTitle("player-delete");
        super.setDescription("Borra un jugador del sistema.");
    }

    public void delete(Player player) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
