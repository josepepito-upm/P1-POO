package practica1.gestordeportivo.types;

import practica1.gestordeportivo.commands.CommandInterface;
import practica1.gestordeportivo.commands.RandomTournamentMatchmaking;
import practica1.gestordeportivo.commands.ManualTournamentMatchmaking;

public enum MatchmakeModes {
    RANDOM("-a", new RandomTournamentMatchmaking()),
    MANUAL("-m", new ManualTournamentMatchmaking());

    private final String modeFormat;
    public static CommandInterface commandInterface;
    
    MatchmakeModes(String mode, CommandInterface commandInterface) {
            this.modeFormat = mode;
            this.setCommand(commandInterface);
    }
    
    private void setCommand(CommandInterface command) {
        commandInterface = command;
    }

    public String getMode() {
        return modeFormat;
    }
 
}
