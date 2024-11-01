package practica1.gestordeportivo.commands;

public class Command {
    
    private String title;
    private String description;

    public Command(String title, String description) {
        this.title = title;
        this.description = description;
    }

    protected String getTitle() {
        return this.title;
    }

    protected String getDescription() {
        return this.description;
    }

    protected void showCommand() {
        System.out.println(title + "\t" + description);
    }
}


//ignorar esto que es una prueba 