package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;
import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.models.CommandLineInterpreter;

abstract class PublicCommands implements CommandInterface {
    protected CommandLineInterpreter cli;
    protected UserController userController = new UserController(cli);
    
    public abstract Errors execute(String command);

    public Errors validate(String command) {  
        if(userController.getCli().getAuthenticatedUser().getRole() != Role.GUEST) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return Errors.NULL;
    }
}
