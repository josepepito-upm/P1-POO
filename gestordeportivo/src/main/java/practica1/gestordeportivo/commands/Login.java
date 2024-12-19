package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.types.Errors;

public class Login extends PublicCommands {

    private UserController userController = new UserController(cli);

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
        System.out.println("Ejecutando comando login: " + command); // Depuración

        Errors validationResult = validate(command);
        if (!validationResult.isNull()) {
            return validationResult;
        }

        String[] commandData = command.split(" ")[1].split(";");
        userController.login(commandData[0], commandData[1]);

        System.out.println("Usuario autenticado exitosamente.");

        return Errors.NULL; 
        }

}
