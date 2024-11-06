package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.user.player.Player;

public class CreateCommand extends Commands {
    public CreateCommand() {
        super("create", "Crea un nuevo jugador en el sistema");
    }
    public void execute(String[] args, Manager manager) {
        if (args.length > 1) {
            manager.getPlayerList().add(new Player(args[1]));
            System.out.println("Jugador '" + args[1] + "' creado.");
        } else {
            System.out.println("ERROR: Falta el nombre del jugador.");
        }
    }
}
