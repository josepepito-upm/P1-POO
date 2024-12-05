package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.models.User;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;

abstract class PlayerCommands implements CommandInterface {
    
    public abstract Errors execute(String command);

    public Errors validate(String command) {
        //comprobar que el rol del usuario es guest, no se como hacerlo
        if(User.getRole() != Role.GUEST) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return null;
    }
}
