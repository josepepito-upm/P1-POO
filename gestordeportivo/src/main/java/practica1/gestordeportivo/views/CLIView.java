package practica1.gestordeportivo.views;

import java.io.Console;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.User;

public class CLIView {
    private CommandLineInterpreter cli;
    private User usr;
    private String prompt = usr.getRole().name().concat("~>");
    private Console console;

    public void initialize() {
    this.usr = new User("", "");
    //faltan cosas
    }

    public void getCommand() {
        System.out.println(prompt);
        String string = console.readLine();        
        string.split(" ");
    }
}