package practica1.gestordeportivo;
public class Manager {
    private PlayerList playerList;
    private MatchmakeList matchmakeList;

    public Manager() {
        playerList = new PlayerList();
        matchmakeList = new MatchmakeList();

        playerList.add(new Player("Luisa", 4.5));
        playerList.add(new Player("Manuel", 2.7));
        playerList.add(new Player("Kurt", 4.0));
        playerList.add(new Player("Sofia", 3.8));
        playerList.add(new Player("Robert", 3.8));
    }
    
    public void createPlayer(String name) {
        if (!playerList.exists(name)) {
            playerList.add(new Player(name));
            System.out.println("Jugador " + name + " creado.");
        } else {
            System.out.println("El jugador ya existe.");
        }
    }

    public void removePlayer(Player player) {
        if (playerList.exists(player.getName())) {
            playerList.remove(player);
            System.out.println("Jugador " + player + " eliminado.");
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    public void showPlayers() {
        playerList.show();
    }
}
