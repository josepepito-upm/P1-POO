package practica1.gestordeportivo;

import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.initializer.DataInitializer;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.views.CLIView;

public class SportsManager {

    public static void main(String[] args) {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        UserController userController = new UserController(cli); 
        DataInitializer.initializeUsers(userController); 
        new CLIView(cli).initialize();
    }
}
