package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.types.Errors;

public class Login extends PublicCommands {

    private UserController userController = new UserController();

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }

        String[] commandData = parts[1].split(";");
        if (commandData.length != 2 || !commandData[0].contains("@")) {
            return Errors.WRONG_MAIL;
        }

        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] commandData = parts[1].split(";");

        if(validate(command).isNull()) {
            userController.login(commandData[0], commandData[1]);
            return Errors.NULL;
        } else return validate(command);
    }
}
