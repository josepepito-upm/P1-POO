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
 
}
