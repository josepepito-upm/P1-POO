package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.user.player.Player;

public class TournamentMatchmakingCommand extends Command {
    
    public TournamentMatchmakingCommand(String title, String description) {
        super(title, description);
        super.setTitle("tournament-matchmaking");
        super.setDescription("Emparejamiento manual (-m) o automático aleatorio (-a).");
    }

    public void match(Player player1, Player player2) {

    }

    public void random() {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
