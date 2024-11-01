package practica1.gestordeportivo;
import java.io.Console;

import practica1.gestordeportivo.utils.Manager;
import practica1.gestordeportivo.utils.matchmake.MatchmakeList;
import practica1.gestordeportivo.utils.player.Player;
import practica1.gestordeportivo.utils.player.PlayerList;

public class SportsManager {
    public static void main(String[] args) {
        Console console = System.console();
        MatchmakeList matchmakes = new MatchmakeList();
        PlayerList playerList = new PlayerList();

        playerList.add(new Player("Luisa", 4.5));
        playerList.add(new Player("Manuel", 2.7));
        playerList.add(new Player("Kurt", 4.0));
        playerList.add(new Player("Sofia", 3.8));
        playerList.add(new Player("Robert", 3.8));

        Manager manager = new Manager(playerList, matchmakes);
        
        String command = console.readLine("Introduzca un comando disponible: ");
        while (!command.equalsIgnoreCase("exit")) {
            manager.Commands(command);
            command = console.readLine("Introduzca otro comando o 'exit' para salir: ");
        }

    }
}