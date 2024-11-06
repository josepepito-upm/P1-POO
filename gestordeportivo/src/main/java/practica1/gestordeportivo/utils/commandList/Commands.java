package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;

public abstract class Commands {

    private String title;
    private String description;

    public Commands(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(String[] action, Manager manager);

    public Commands() {
        this.title = "default";
        this.description = "default description";
    }
}
