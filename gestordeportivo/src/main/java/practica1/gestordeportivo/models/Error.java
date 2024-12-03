package practica1.gestordeportivo.models;

public enum Error {
    
    COMMAND_NOT_FOUND(0),
    SYNTAX_ERROR(1),
    NULL(2);
    
    int position;

    Error(int position) {
        this.position = position;
    } 

    
    public boolean isNull() {
        return this == Error.NULL;
    }
}
