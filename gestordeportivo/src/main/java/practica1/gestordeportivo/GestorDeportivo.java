package practica1.gestordeportivo;

public class GestorDeportivo {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Player player = new Player("Luisa");
        PlayerList playerList = new PlayerList(player);
        Player p2 = new Player("Paco");
        playerList.addPlayer(p2);

    }
}