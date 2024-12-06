package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;

public class TournamentRemove extends PlayerCommands {
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        //jugador no en torneo
        for (Player existingPlayer : playerList.getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) { // Compara el DNI
                return Errors.PLAYER_NOT_IN_TOURNAMENT;
            }
        }
        //equipo no en torneo
        //return Errors.TEAM_NOT_IN_TOURNAMENT;
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            //
            return null;
        } else return validate(command);
        
    }
}
