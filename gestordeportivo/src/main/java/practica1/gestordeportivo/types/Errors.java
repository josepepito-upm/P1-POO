package practica1.gestordeportivo.types;

public enum Errors {
    
    COMMAND_NOT_FOUND,
    SYNTAX_ERROR,
    FORMAT_ERROR,
    UNAUTHORIZED_COMMAND,
    EXISTING_PLAYER,
    NON_EXISTING_PLAYER,
    NON_EXISTING_USER,
    PLAYER_IN_TOURNAMENT,
    EXISTING_TEAM,
    NON_EXISTING_TEAM,
    TEAM_ALREADY_FULL,
    EXISTING_TOURNAMENT,
    NON_EXISTING_TOURNAMENT,
    PLAYER_IN_TEAM,
    PLAYER_NOT_IN_TEAM,
    PLAYER_MATCHED,
    TOURNAMENT_NOT_ACTIVE,
    TOURNAMENT_ACTIVE,
    PLAYER_NOT_IN_TOURNAMENT,
    TEAM_NOT_IN_TOURNAMENT,
    WRONG_MAIL,
    INVALID_TEAM_DATA,
    INVALID_PLAYER_DATA,
    INVALID_TOURNAMENT_DATA,
    INVALID_MATCHMAKING,
    INSUFFICIENT_PARTICIPANTS,
    INSUFFICIENT_PERMISSIONS,
    INSUFFICIENT_DATA,
    OPERATION_FAILED,
    DATA_NOT_FOUND,
    NULL;
    


    public boolean isNull() {
        return this == Errors.NULL;
    }
}
