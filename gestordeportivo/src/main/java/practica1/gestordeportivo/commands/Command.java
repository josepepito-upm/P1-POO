package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.utils.Manager;

public abstract class Command {

    private String title;
    private String description;

    // Constructor
    public Command(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Métodos getter
    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    // Método para mostrar la información del comando
    public void showCommand() {
        System.out.println(title + "\t" + description);
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract void execute(String[] action, Manager manager);
}
