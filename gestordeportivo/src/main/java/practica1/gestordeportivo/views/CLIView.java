package practica1.gestordeportivo.views;

import java.io.Console;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.User;

public class CLIView {
    private CommandLineInterpreter cli;
    private User user;
    private String prompt = user.getRole().name().concat("~>");
    private Console console;

    public void initialize() {
    this.user = new User("", "");
    //faltan cosas
    }

    public void getCommand() {
        System.out.println(prompt);
        String string = console.readLine();        
        string.split(" ");
    }

    public User getUser() {
        return user;
    }
}