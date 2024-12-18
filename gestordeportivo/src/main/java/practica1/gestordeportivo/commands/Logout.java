package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.types.Errors;

public class Logout extends PublicCommands {

    public Logout(UserController userController) {
        super(userController); // Pasar UserController a la superclase
    }

    public Errors validate(String command) {
        super.validate(command);

        if (!command.equals("logout")) {
            return Errors.FORMAT_ERROR;
        }   
        return Errors.NULL;
    }

    public Errors execute(String command) {
        if(validate(command).isNull()) {
            userController.logout();
            return Errors.NULL;
        } else return validate(command);
    }
}
