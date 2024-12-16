package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.User;
import practica1.gestordeportivo.types.Role;

public class UserController extends Controller{

    public void login(String username, String password) {
        String[] parts = username.split("@");
        Role role;

        switch (parts[1]) {
            case "alumnos.upm.es" -> role = Role.PLAYER;
            case "upm.es" -> role = Role.ADMIN;
            default -> role = Role.GUEST;
        }

        User user = new User(username, password);
        user.setRole(role);

        getCli().setAuthenticatedUser(user);
        System.out.println("Usuario autenticado: " + getCli().getAuthenticatedUser());


    }

    public void logout() {
        User guest = new User("Guest", null);
        guest.setRole(Role.GUEST);
        getCli().setAuthenticatedUser(guest);    }
}
