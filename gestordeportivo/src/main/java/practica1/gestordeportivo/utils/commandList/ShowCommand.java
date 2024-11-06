package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;

public class ShowCommand extends Commands {

    public void execute(String[] args, Manager manager) {
        System.out.println("> JUGADORES EN EL SISTEMA <");
        manager.getPlayerList().show();
    }
}

