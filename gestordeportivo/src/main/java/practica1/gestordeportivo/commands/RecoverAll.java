package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.types.Errors;

public class RecoverAll extends AdminCommands {

    private UserController userController = new UserController();
    
    public Errors validate(String command) {
        super.validate(command);

        if (command != "recover-all") {
            return Errors.FORMAT_ERROR; 
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        if(validate(command).isNull()) {
            userController.recoverAll();
            return Errors.NULL;
        } else return validate(command);
    }
}
