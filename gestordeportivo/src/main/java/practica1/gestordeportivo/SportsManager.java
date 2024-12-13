package practica1.gestordeportivo;

import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.initializer.DataInitializer;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.views.CLIView;

public class SportsManager {

    public static void main(String[] args) {
        UserController userController = new UserController(); 
        DataInitializer.initializeUsers(userController); 
        CommandLineInterpreter cli = new CommandLineInterpreter();//prueba
        new CLIView(cli).initialize();
    }
}
