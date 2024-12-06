package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.types.Errors;

public class TournamentAdd extends PlayerCommands {
    
    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        //torneo en curso
        String[] playerData = parts[1].split(";");
        if (playerData.length < 4) {
            return Errors.TOURNAMENT_ACTIVE;
        }
        //jugador en torneo
        for (Player existingPlayer : playerList.getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) { // Compara el DNI
                return Errors.PLAYER_IN_TOURNAMENT;
            }
        }
        //equipo en torneo
        //return Errors.TEAM_IN_TOURNAMENT;
        return null;
    }

    public Errors execute(String command) {
        if(validate(command) == null) {
            //
            return null;
        } else return validate(command);
        
    }
}
