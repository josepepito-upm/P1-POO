package practica1.gestordeportivo;
import java.io.Console;
import java.util.Scanner;

public class GestorDeportivo {
    public static void main(String[] args) {
        Console console = System.console();
        Manager manager = new Manager();

        String command = console.readLine("Introduzca un comando disponible: ");
        while (!command.equalsIgnoreCase("exit")) {
            System.out.println("Comando ingresado: " + command);
            command = console.readLine("Introduce otro comando o 'exit' para salir: ");
        }

        Player player = new Player("Luisa");
        PlayerList playerList = new PlayerList(player);
        Player p2 = new Player("Paco");
        playerList.add(p2);

        playerList.show();

    }
}