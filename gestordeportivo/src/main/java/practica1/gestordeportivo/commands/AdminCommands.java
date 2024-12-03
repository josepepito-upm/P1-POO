package practica1.gestordeportivo.commands;

abstract class AdminCommands implements CommandInterface {

    public abstract Error execute(String command);

    public Error validate(String loqsea) {
        System.out.println("Validando: " + loqsea);
        return null;
    } 
     
}