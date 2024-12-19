package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.MatchmakeController;
import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;

public abstract class TournamentMatchmaking extends AdminCommands {

    MatchmakeController matchmakeController = new MatchmakeController();
    public TournamentMatchmaking(PlayerController playerController) {
        super(playerController);
    }
    protected String[] getParts(String command) {
        return command.split(" ");
    }
    protected String[] getPlayerData(String[] parts) {
        return parts[2].split(";");
    }

    public Errors validate(String command) {
        super.validate(command);
        String[] parts = getParts(command);
        String[] playerData = getPlayerData(parts);
        
        if (playerData.length < 4 || parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }

        for (Player existingPlayer : matchmakeController.getCli().getPlayerList().getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) {
                return Errors.EXISTING_PLAYER;
            }
        }
        return Errors.NULL;
    }

    public abstract Errors execute(String command);

}
