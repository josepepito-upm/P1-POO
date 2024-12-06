package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.models.User;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;

abstract class PlayerCommands implements CommandInterface {
    
    public abstract Errors execute(String command);

    public Errors validate(String command) {
        //posibilidad de mejora
        User user = new User(command, command);
        if(user.getRole() == Role.GUEST) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return null;
    }
}
