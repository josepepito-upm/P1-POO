package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.user.User;

public class LoginCommand extends Command{
    
    public LoginCommand(String title, String description) {
        super(title, description);
        super.setTitle("login");
        super.setDescription("Autentica al usuario en el sistema.");
    }

    public void login(User username) {

    }

    public void execute(String[] action, Manager manager) {
        
    }
}
