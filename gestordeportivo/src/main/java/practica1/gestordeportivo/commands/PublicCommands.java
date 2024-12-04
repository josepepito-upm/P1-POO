package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.types.Role;

abstract class PublicCommands implements CommandInterface {
    
    public abstract Error execute(String command);

    public boolean validate() {
        return (CommandLineInterpreter.getRole() == Role.GUEST); //donde se ubique el usuario para acceder a su rol
    }
}
