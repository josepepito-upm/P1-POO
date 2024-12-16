package practica1.gestordeportivo.commands;
import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.models.User;
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

    @Override
public Errors execute(String command) {
    System.out.println("Ejecutando comando login: " + command); // Depuración

    String[] parts = command.split(" ");

    // Validar que el comando tenga al menos dos partes
    if (parts.length < 2) {
        System.out.println("Error: El formato del comando es incorrecto.");
        return Errors.FORMAT_ERROR;
    }

    String[] commandData = parts[1].split(";");

    // Validar que el correo y la contraseña estén presentes
    if (commandData.length != 2) {
        System.out.println("Error: Falta el correo o la contraseña.");
        return Errors.FORMAT_ERROR;
    }

    Errors validationResult = validate(command); // Realizar la validación una sola vez
    if (validationResult.isNull()) {
        userController.login(commandData[0], commandData[1]); // Ejecutar login
        System.out.println("Usuario autenticado exitosamente.");
        return Errors.NULL; // Login exitoso
    }
    return validationResult; // Retornar el error si la validación falla
    }

}
