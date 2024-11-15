package practica1.gestordeportivo.utils.commandList;

import practica1.gestordeportivo.utils.Manager;

public abstract class Command {

    private String title;
    private String description;

    public Command(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void execute(String[] action, Manager manager);
}
