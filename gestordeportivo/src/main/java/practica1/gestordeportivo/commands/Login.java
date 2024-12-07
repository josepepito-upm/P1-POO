package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.types.Errors;

public class Login extends PublicCommands {

    CommandLineInterpreter cli;
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        String[] commandData = parts[1].split(";");
        String[] username = commandData[0].split("@");

        if (parts.length != 2 || commandData.length != 2) {
            return Errors.FORMAT_ERROR;
        }   
        
        if(!username[1].equals("alumnos.upm.es") || !username[1].equals(".upm.es")) {
            return Errors.WRONG_MAIL;
        }
        return null;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");
        String[] commandData = parts[1].split(";");

        if(validate(command) == null) {
            new UserController(cli).login(commandData[0], commandData[1]);
            return null;
        } else return validate(command);
    }
}
