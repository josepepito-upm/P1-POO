package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;

public abstract class Controller {
    private final CommandLineInterpreter cli;

    public Controller(CommandLineInterpreter cli) {
        this.cli = cli;
    }
    
    public Controller() {
        this.cli = new CommandLineInterpreter();
    }

    public CommandLineInterpreter getCli() {
        return cli;
    }
}
