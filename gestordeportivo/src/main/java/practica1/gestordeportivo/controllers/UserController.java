package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.types.Role;
import practica1.gestordeportivo.views.CLIView;
import practica1.gestordeportivo.views.Message;

public class UserController {

    private CLIView cliView;
    private Message message;
    protected CommandLineInterpreter cli;

    public UserController (CommandLineInterpreter cli) {
        this.cli = cli;
    }
    
    public void login(String username, String password) {
        String[] parts = username.split("@");

        switch(parts[1]) {
            case "alumnos.upm.es" -> cliView.getUser().setRole(Role.PLAYER);
            case "upm.es" -> cliView.getUser().setRole(Role.ADMIN);
        }
        message.writeMessage(Message.LOGGED_IN);
    }

    public void logout() {
        cliView.getUser().setRole(Role.GUEST);
        message.writeMessage(Message.LOGGED_OUT);
    }
}
