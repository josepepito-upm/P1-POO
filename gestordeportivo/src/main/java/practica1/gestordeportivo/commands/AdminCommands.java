package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;
import practica1.gestordeportivo.views.CLIView;

abstract class AdminCommands implements CommandInterface {

    CLIView cliView;

    public abstract Errors execute(String command);

    public Errors validate(String command) {  
        if(cliView.getUser().getRole() != Role.ADMIN) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return null;
    }
     
}
