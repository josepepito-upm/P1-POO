package practica1.gestordeportivo.models;

public enum Role {
    
    ADMIN,
    PLAYER,
    NULL;

    private Role() {
    }

    public boolean isNull() {
        return this == Role.NULL;
    }
}
