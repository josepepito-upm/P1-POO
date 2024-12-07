package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;
import practica1.gestordeportivo.views.CLIView;

abstract class PlayerCommands implements CommandInterface {
    
    CLIView cliView;

    public abstract Errors execute(String command);

    public Errors validate(String command) {  
        if(cliView.getUser().getRole() != Role.PLAYER) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return null;
    }
}
