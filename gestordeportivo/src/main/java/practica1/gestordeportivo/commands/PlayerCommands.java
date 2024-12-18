package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;

abstract class PlayerCommands implements CommandInterface {
    
    protected final PlayerController playerController;

    public PlayerCommands(PlayerController playerController) {
        this.playerController = playerController;
    }
    public abstract Errors execute(String command);

    public Errors validate(String command) {  
        if(playerController.getCli().getAuthenticatedUser().getRole() != Role.ADMIN) { 
            return Errors.UNAUTHORIZED_COMMAND;
        } else return Errors.NULL;
    }
}
