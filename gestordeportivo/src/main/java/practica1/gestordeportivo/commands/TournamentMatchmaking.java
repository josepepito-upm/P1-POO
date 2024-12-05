package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;

public class TournamentMatchmaking extends AdminCommands {
    
    public Errors validate(String command) {
        super.validate(command);

        //ERRORES: FORMATO INCORRECTO POR ESPACIOS, FORMATO INCORRECTO POR ARGUMENTOS, UNO DE LOS JUGADORES YA ESTA EMPAREJADO, EL TORNEO NO ESTA EN CURSO
        //los errores ya estan en el enumerado
        /*String[] parts = command.split(" ");
        if (parts.length < 2) {
            return Errors.FORMAT_ERROR;
        }
        String[] playerData = parts[1].split(";");
        if (playerData.length < 4) {
            return Errors.FORMAT_ERROR;
        }
        for (Player existingPlayer : playerList.getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) { // Compara el DNI
                return Errors.EXISTING_PLAYER;
            }
        }*/
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            //comando de matchmakecontroller
            return null;
        } else return validate(command);
    }
}
