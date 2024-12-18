package practica1.gestordeportivo;

import practica1.gestordeportivo.initializer.DataInitializer;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.views.CLIView;

public class SportsManager {

    private static CommandLineInterpreter cli;
    public static void main(String[] args) {
        cli = new CommandLineInterpreter();

        DataInitializer.initializeUsers(cli);

        CLIView cliView = new CLIView(cli);
        cliView.initialize();
    }


}

