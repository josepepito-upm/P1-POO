package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;

public abstract class Controller {
    private CommandLineInterpreter cli;

    public Controller() {
        this.cli = new CommandLineInterpreter(); // Inicialización por defecto
    }

    public CommandLineInterpreter getCli() {
        if (cli == null) {
            cli = new CommandLineInterpreter(); // Inicialización perezosa si es necesario
        }
        return cli;
    }
}
