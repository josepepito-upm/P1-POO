package practica1.gestordeportivo.types;

public enum MatchmakeModes {
    RANDOM("-a"),
    MANUAL("-m");

    private String modeFormat;

    MatchmakeModes(String mode) {
        this.modeFormat = mode;
    }

    public String getMode() {
        return modeFormat;
    }
 
    public static MatchmakeModes get(int index) {
        assert index >= 0 && index <= MatchmakeModes.values().length;
        return MatchmakeModes.values()[index];
    }
}
