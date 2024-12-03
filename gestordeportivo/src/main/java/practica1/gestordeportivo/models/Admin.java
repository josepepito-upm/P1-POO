package practica1.gestordeportivo.models;

public class Admin extends User {
    
    private Role role;
    
    public Admin(String username, String password) {
        super(username, password);
        this.role = Role.ADMIN;
    }
}
