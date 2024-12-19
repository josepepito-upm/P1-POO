package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;

public abstract class Controller {
    private final CommandLineInterpreter cli;

    public Controller(CommandLineInterpreter cli) {
        this.cli = cli;
    }
    

    public CommandLineInterpreter getCli() {
        return cli;
    }
}
