package practica1.gestordeportivo.models;

import practica1.gestordeportivo.types.Role;

public class Admin extends User {
    
    private Role role;
    
    public Admin(String username, String password) {
        super(username, password);
        this.role = Role.ADMIN;
    }
    
    public Role getRole() {
        return role;
    }
}
