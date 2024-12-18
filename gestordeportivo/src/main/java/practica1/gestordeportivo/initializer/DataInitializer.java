package practica1.gestordeportivo.initializer;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.User;
import practica1.gestordeportivo.types.Role;

public class DataInitializer {

    public static void initializeUsers(CommandLineInterpreter cli) {
        User admin = new User("admin@upm.es", "adminpass");
        admin.setRole(Role.ADMIN);
        cli.setAuthenticatedUser(admin);

        User player = new User("mario@alumnos.upm.es", "1234");
        player.setRole(Role.PLAYER);
        cli.setAuthenticatedUser(player);
    }
}
