package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;

public abstract class TournamentMatchmaking extends AdminCommands {
    protected TournamentController tournamentController; 
    protected String[] getParts (String command) {
        return command.split(" ");
    }        
    protected String[] getPlayerData (String[] parts) {
            return parts[3].split(";");
    }
    public Errors validate(String command) {        
        super.validate(command);
        //ERRORES: FORMATO INCORRECTO POR ESPACIOS, FORMATO INCORRECTO POR ARGUMENTOS, UNO DE LOS JUGADORES YA ESTA EMPAREJADO, EL TORNEO NO ESTA EN CURSO
        //los errores ya estan en el enumerado
        String[] parts = this.getParts(command);
        String[] playerData = this.getPlayerData(parts);        
        if (playerData.length < 4 || parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }

        for (Player existingPlayer : tournamentController.getCli().getPlayerList().getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) { // Compara el DNI
                return Errors.EXISTING_PLAYER;
            }
        }
        return Errors.NULL;
    }


    public abstract Errors execute(String command); 
            

    
}
