package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;

public interface CommandInterface {

    abstract Errors execute(String command);

    abstract Errors validate(String command);

}