package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.user.player.Player;

public class CreatePlayerCommand extends Command {
    
    public CreatePlayerCommand(String title, String description) {
        super(title, description);
        super.setTitle("player-create");
        super.setDescription("Da de alta un jugador en el sistema.");
    }

    public void create(Player player) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
