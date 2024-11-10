package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;

public class StatisticShowCommand extends Command {
    
    public StatisticShowCommand(String title, String description) {
        super(title, description);
        super.setTitle("statistics-show");
        super.setDescription("Muestra las estadísticas del jugador autenticado.");
    }

    public void show() {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
