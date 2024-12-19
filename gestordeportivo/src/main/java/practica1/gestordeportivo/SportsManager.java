package practica1.gestordeportivo;

import practica1.gestordeportivo.initializer.DataInitializer;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.types.Commands;
import practica1.gestordeportivo.views.CLIView;

public class SportsManager {

    public static void main(String[] args) {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        CLIView cliView = new CLIView(cli);

        DataInitializer.initializeUsers(cli);
        Commands.initialize(cliView);

        cliView.initialize();
    }


}

