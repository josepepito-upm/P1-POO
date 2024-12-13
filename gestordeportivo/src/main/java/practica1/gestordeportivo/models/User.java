package practica1.gestordeportivo.models;

import practica1.gestordeportivo.types.Role;

public class User {

    private String username;
    private String password;
    private Role role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = Role.GUEST;
    }

    protected String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
           "username='" + (username != null ? username : "Guest") + '\'' +
           ", role=" + (role != null ? role : "No role") +
           '}';
    }

}
