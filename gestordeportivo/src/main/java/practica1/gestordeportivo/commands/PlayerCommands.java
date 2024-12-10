package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;

abstract class PlayerCommands implements CommandInterface {
    
    UserController userController = new UserController();

    public abstract Errors execute(String command);

    public Errors validate(String command) {  
        if(userController.getCli().getAuthenticatedUser().getRole() != Role.ADMIN) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return Errors.NULL;
    }
}
