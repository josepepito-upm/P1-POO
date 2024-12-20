package practica1.gestordeportivo.models;
import practica1.gestordeportivo.types.Role;

public class Player extends User {

    private final String forename;
    private final String surname;
    private final String id;
    private boolean matched;
    private Statistics stats;
    private Role role;
    private Admin creator;

    public Player(String username, String password, String forename, String surname, String id) {
        super(username, password); 
        this.forename = forename;
        this.surname = surname;
        this.id = id;       
        this.matched = false;
        this.stats = new Statistics();
        this.role = Role.PLAYER;
    }
    public String getForename(){
        return forename;
    }
    public String getSurname(){
        return surname;
    }
    
    public Statistics getStats() {
        return stats;
    }

    public boolean getMatched() {
        return matched;
    }

    public String getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }
    public void setCreator(Admin creator) {
        this.creator = creator;
    }
} 
