package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.commands.Command;
import practica1.gestordeportivo.utils.Manager;

public class ShowCommand extends Command {

    public ShowCommand() {
        super("show", "Muestra la lista de jugadores");
    }

    @Override
    public void execute(String[] args, Manager manager) {
        System.out.println("> JUGADORES EN EL SISTEMA <");
        manager.getPlayerList().show();
    }
}

