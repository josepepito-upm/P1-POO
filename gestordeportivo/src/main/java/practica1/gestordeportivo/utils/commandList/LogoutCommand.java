package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;

public class LogoutCommand extends Command {
    
    public LogoutCommand(String title, String description) {
        super(title, description);
        super.setTitle("logout");
        super.setDescription("Desautentica al usuario en el sistema.");
    }

    public void logout() {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
