package practica1.gestordeportivo.types;

import java.util.concurrent.ConcurrentHashMap;

import practica1.gestordeportivo.commands.CommandInterface;
import practica1.gestordeportivo.commands.RandomTournamentMatchmaking;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.commands.ManualTournamentMatchmaking;

public enum MatchmakeModes {
    RANDOM("-a"),
    MANUAL("-m");

    private final String modeFormat;
    private static final CommandInterface[] generateModes(CommandLineInterpreter cli) {
        return new CommandInterface[] {new RandomTournamentMatchmaking(cli), 
                                       new ManualTournamentMatchmaking(cli)};
    }

    MatchmakeModes(String mode) {
            this.modeFormat = mode;
    }
    
    public String getMode() {
        return modeFormat;
    }

    private static ConcurrentHashMap<String, CommandInterface> generateHash(CommandLineInterpreter cli) {
        ConcurrentHashMap<String, CommandInterface> modeMap = new ConcurrentHashMap<>();
        CommandInterface[] commands = generateModes(cli);
        for (MatchmakeModes modes : MatchmakeModes.values()) {
            modeMap.put(modes.getMode(), commands[modes.ordinal()]);
        }
        return modeMap;
    }

    public static CommandInterface getCommandInterface(CommandLineInterpreter cli, String mode) {
        CommandInterface commandInterface;
        ConcurrentHashMap<String, CommandInterface> modeMap = generateHash(cli);
        for (MatchmakeModes modes : MatchmakeModes.values()) {
            if (mode.contains(modes.getMode())) {
                commandInterface = modeMap.get(modes.getMode());
                return commandInterface;
            }
        }        
        return null;
    }
}
