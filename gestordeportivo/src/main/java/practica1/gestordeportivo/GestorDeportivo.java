package practica1.gestordeportivo;
import java.io.Console;

public class GestorDeportivo {
    public static void main(String[] args) {
        Console console = System.console();
        Manager manager = new Manager();
        MatchmakeList matchmakes = new MatchmakeList();
        PlayerList playerList = new PlayerList();

        Player p1 = new Player("Luisa");
        Player p2 = new Player("Manuel");
        Player p3 = new Player("Kurt");
        Player p4 = new Player("Sofia");
        Player p5 = new Player("Robert");

        p1.setScore(4.5);
        p2.setScore(2.7);
        p3.setScore(4.0);
        p4.setScore(3.8);
        p5.setScore(3.8);

        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        playerList.add(p5);
        
        String command = console.readLine("Introduzca un comando disponible: ");
        while (!command.equalsIgnoreCase("exit")) {
            manager.Commands(command);
            command = console.readLine("Introduzca otro comando o 'exit' para salir: ");
        }

    }
}