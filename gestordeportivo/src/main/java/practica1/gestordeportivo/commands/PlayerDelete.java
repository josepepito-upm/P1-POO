package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;

public class PlayerDelete extends AdminCommands {
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        //no caigo ahora en como poner la playerlist ajskdjas
        if(!PlayerList.contains(parts[2])) {
            return Errors.NON_EXISTING_PLAYER;
        }
        if(/*comprobar que el jugador no este en un torneo en curso */) {
            return Errors.PLAYER_IN_TOURNAMENT;
        }
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            new PlayerController(cli).delete(.....);
            return null;
        } else return validate(command);
        
    }
}
