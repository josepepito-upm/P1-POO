package practica1.gestordeportivo.commands;

public interface CommandInterface {
    abstract Error execute(String command);
    abstract boolean validate();

}
