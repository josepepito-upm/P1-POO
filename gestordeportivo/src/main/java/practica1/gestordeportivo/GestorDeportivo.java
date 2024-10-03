package practica1.gestordeportivo;
import java.io.Console;

public class GestorDeportivo {
    public static void main(String[] args) {

        Console console = System.console();

        Player player = new Player("Luisa");
        PlayerList playerList = new PlayerList(player);
        Player p2 = new Player("Paco");
        playerList.add(p2);

        playerList.showPlayers();

    }
}