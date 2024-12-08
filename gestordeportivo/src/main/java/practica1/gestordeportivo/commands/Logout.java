package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.types.Errors;

public class Logout extends PublicCommands {

    private UserController userController;
    
    public Logout(UserController userController) {
        this.userController = userController;
    }

    public Errors validate(String command) {
        super.validate(command);

        if (!command.equals("logout")) {
            return Errors.FORMAT_ERROR;
        }   
        return null;
    }

    public Errors execute(String command) {
        Errors validationErrors = validate(command);
        if (validationErrors != null) {
            return validationErrors;
        }
        userController.logout();
        return Errors.NULL;
    }
}
