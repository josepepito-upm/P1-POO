package practica1.gestordeportivo.models;

public enum Error {
    
    COMMAND_NOT_FOUND("ERROR: Comando no encontrado.\n"),
    SYNTAX_ERROR("ERROR: Error de sintaxis en los argumentos pasados.\n"),
    NULL("");
    
    private String message;

    Error(String message) {
        this.message = message;
    }

    void writeMsg(String message) {
        if(!this.isNull()) {
            System.out.println(message);            
        }
    }
    public boolean isNull() {
        return this == Error.NULL;
    }
}
