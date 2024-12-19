package practica1.gestordeportivo.types;

import practica1.gestordeportivo.commands.CommandInterface;
import practica1.gestordeportivo.commands.RandomTournamentMatchmaking;
import practica1.gestordeportivo.commands.ManualTournamentMatchmaking;
import practica1.gestordeportivo.controllers.PlayerController;

public enum MatchmakeModes {
    RANDOM("-a", null),
    MANUAL("-m", null);

    private final String modeFormat;
    private CommandInterface commandInterface;

    // Constructor que toma un mode y un commandInterface
    MatchmakeModes(String mode, CommandInterface commandInterface) {
        this.modeFormat = mode;
        this.commandInterface = commandInterface;
    }

    // Método para inicializar los commandInterface
    public static void setCommandInterface(PlayerController playerController) {
        RANDOM.commandInterface = new RandomTournamentMatchmaking(playerController);
        MANUAL.commandInterface = new ManualTournamentMatchmaking(playerController);
    }

    public String getMode() {
        return modeFormat;
    }

    public CommandInterface getCommandInterface() {
        return commandInterface;
    }
}
