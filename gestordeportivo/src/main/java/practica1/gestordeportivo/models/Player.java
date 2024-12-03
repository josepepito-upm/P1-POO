package practica1.gestordeportivo.models;

public class Player extends User {

    private final String forename;
    private final String surname;
    private final String id;
    private boolean matched;
    private Statistics stats;
    private Role role;

    public Player(String username, String password, String forename) {
        super(username, password); 
        this.forename = forename;
        this.surname = "";
        this.id = "";       
        this.matched = false;
        this.stats = new Statistics();
        this.role = Role.PLAYER;
    }

    public Player(String username, String password, String forename, double score) {
        super(username, password); 
        this.forename = forename;
        this.surname = ""; 
        this.id = "";               this.matched = false;
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
