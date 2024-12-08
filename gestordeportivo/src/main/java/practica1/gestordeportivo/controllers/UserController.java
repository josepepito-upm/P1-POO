package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.types.Role;

public class UserController extends Controller{

    public void login(String username, String password) {
        String[] parts = username.split("@");

        switch(parts[1]) {
            case "alumnos.upm.es" -> getCli().getAuthenticatedUser().setRole(Role.PLAYER);
            case "upm.es" -> getCli().getAuthenticatedUser().setRole(Role.ADMIN);
        }
    }

    public void logout() {
        getCli().getAuthenticatedUser().setRole(Role.GUEST);
    }
}
