package practica1.gestordeportivo.models;

public enum Error {
    
    COMMAND_NOT_FOUND,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }
}
