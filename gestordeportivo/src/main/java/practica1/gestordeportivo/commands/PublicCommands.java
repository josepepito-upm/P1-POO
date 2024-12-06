package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;
abstract class PlayerCommands implements CommandInterface {
    
    public abstract Errors execute(String command);
}
