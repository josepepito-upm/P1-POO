package practica1.gestordeportivo.utils.commandList;
import practica1.gestordeportivo.utils.Manager;


public class RemoveCommand extends Commands {

    public RemoveCommand() {
        super("remove", "Elimina un jugador del sistema");
    }

    @Override
    public void execute(String[] args, Manager manager) {
        manager.getPlayerList().remove(args[1]);
        System.out.println("Jugador '" + args[1] + "' borrado.");
    }
}

