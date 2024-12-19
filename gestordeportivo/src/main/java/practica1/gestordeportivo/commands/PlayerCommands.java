package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;

abstract class PlayerCommands implements CommandInterface {
    protected final CommandLineInterpreter cli;
    private final UserController userController;

    public PlayerCommands(CommandLineInterpreter cli) {
        this.cli = cli;
        this.userController = new UserController(cli);
    }

    public abstract Errors execute(String command);

    public Errors validate(String command) {  
        if(userController.getCli().getAuthenticatedUser().getRole() != Role.ADMIN) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return Errors.NULL;
    }
}
