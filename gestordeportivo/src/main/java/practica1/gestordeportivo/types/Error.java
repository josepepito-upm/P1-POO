package practica1.gestordeportivo.types;

public enum Error {
    
    COMMAND_NOT_FOUND,
    SYNTAX_ERROR,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }
}
