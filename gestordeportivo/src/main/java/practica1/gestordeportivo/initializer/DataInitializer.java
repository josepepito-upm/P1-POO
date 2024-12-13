package practica1.gestordeportivo.initializer;

import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.models.User;
import practica1.gestordeportivo.types.Role;

public class DataInitializer {

    public static void initializeUsers(UserController userController) {
        User admin = new User("admin@upm.es", "adminpass");
        admin.setRole(Role.ADMIN);
        userController.getCli().setAuthenticatedUser(admin);

        User player = new User("mario@alumnos.upm.es", "1234");
        player.setRole(Role.PLAYER);
        userController.getCli().setAuthenticatedUser(player);
    }
}
