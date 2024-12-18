package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.types.Errors;

public class SaveAll extends AdminCommands {
    

    public SaveAll(PlayerController playerController) {
        super(playerController); 
    }    
    public Errors validate(String command) {
        super.validate(command);

        if (command != "save-all") {
            return Errors.FORMAT_ERROR; 
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        if(validate(command).isNull()) {
            playerController.saveAll();
            return Errors.NULL;
        } else return validate(command);
    }
}
