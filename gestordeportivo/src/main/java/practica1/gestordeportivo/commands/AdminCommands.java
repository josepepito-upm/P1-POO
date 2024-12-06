package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.models.User;
import practica1.gestordeportivo.types.Role;
import practica1.gestordeportivo.types.Errors;

abstract class AdminCommands implements CommandInterface {
    public abstract Errors execute(String command);

    public Errors validate(String command) {
        //comprobar que el rol del usuario es admin, no se como hacerlo
        User user = new User(command, command);        
     
        if(user.getRole() != Role.ADMIN) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return null;
    }
     
}
