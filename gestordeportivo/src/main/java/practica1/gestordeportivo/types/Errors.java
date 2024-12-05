package practica1.gestordeportivo.types;

public enum Errors {
    
    COMMAND_NOT_FOUND,
    SYNTAX_ERROR,
    FORMAT_ERROR,
    UNAUTHORIZED_COMMAND,
    EXISTING_PLAYER,
    NON_EXISTING_PLAYER,
    PLAYER_IN_TOURNAMENT,
    EXISTING_TEAM,
    NON_EXISTING_TEAM,
    TEAM_IN_TOURNAMENT,
    EXISTING_TOURNAMENT,
    NON_EXISTING_TOURNAMENT,
    PLAYER_IN_TEAM,
    PLAYER_NOT_IN_TEAM,
    PLAYER_MATCHED,
    TOURNAMENT_NOT_ACTIVE,
    NULL;

    public boolean isNull() {
        return this == Errors.NULL;
    }
}
