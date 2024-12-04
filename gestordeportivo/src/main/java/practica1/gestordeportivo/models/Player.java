package practica1.gestordeportivo.models;

import practica1.gestordeportivo.types.Role;

public class Player extends User {

    private final String forename;
    private final String surname;
    private final String id;
    private boolean matched;
    private Statistics stats;
    private Role role;

    public Player(String[] data) {
        super(data[0], data[1]); 
        this.forename = data[2];
        this.surname = "";
        this.id = "";       
        this.matched = false;
        this.stats = new Statistics();
        this.role = Role.PLAYER;
    }
    
    public String getForename() {
        return forename;
    }

    public Statistics getStats() {
        return stats;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean getMatched() {
        return matched;
    }

    public String getName() {
        return this.forename;
    }
}
