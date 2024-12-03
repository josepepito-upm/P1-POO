package practica1.gestordeportivo.models;

public class User {

    private String username;
    private String password;
    private Role role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = Role.NULL;
    }

    protected String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }
}
