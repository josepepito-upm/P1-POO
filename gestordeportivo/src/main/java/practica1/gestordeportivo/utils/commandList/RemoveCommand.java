package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.commands.Command;
import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.player.Player;
import practica1.gestordeportivo.utils.player.PlayerList;

public class RemoveCommand extends Command {

    public RemoveCommand() {
        super("remove", "Elimina un jugador del sistema");
    }

    @Override
    public void execute(String[] args, Manager manager) {
        manager.getPlayerList().remove(args[1]);
        System.out.println("Jugador '" + args[1] + "' borrado.");
    }
}

