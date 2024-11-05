package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.commands.Command;
import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.player.Player;

public class CreateCommand extends Command {

    // Llamada al constructor de la clase base Command con los parámetros necesarios
    public CreateCommand() {
        super("create", "Crea un jugador en el sistema");
    }

    @Override
    public void execute(String[] args, Manager manager) {
        if (args.length > 1) {
            manager.getPlayerList().add(new Player(args[1]));
            System.out.println("Jugador '" + args[1] + "' creado.");
        } else {
            System.out.println("ERROR: Falta el nombre del jugador.");
        }
    }
}
