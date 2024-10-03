package practica1.gestordeportivo;
public class Manager {
    private PlayerList playerList;
    private MatchmakeList matchmakeList;

    public Manager() {
        playerList = new PlayerList();
        matchmakeList = new MatchmakeList();
    }
    
    public void addPlayer(String name){
        Player player = new Player (name);
        PlayerList.add(player);
    }

    public void removePlayer(String name) {
        Player player = playerList.findPlayerByName(name);
        if (player != null) {
            playerList.remove(player);
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    public void showPlayers() {
        playerList.show();
    }
}
