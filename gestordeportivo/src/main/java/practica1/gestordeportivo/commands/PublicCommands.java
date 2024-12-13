package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;
import practica1.gestordeportivo.controllers.UserController;

abstract class PublicCommands implements CommandInterface {
    protected UserController userController;

    public PublicCommands() {
        this.userController = new UserController(); // Asegúrate de que userController se inicialice
    }
    
    public abstract Errors execute(String command);

    public Errors validate(String command) {  
        if(userController.getCli().getAuthenticatedUser().getRole() != Role.GUEST) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return Errors.NULL;
    }
}
