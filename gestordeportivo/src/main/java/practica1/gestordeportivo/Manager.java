package practica1.gestordeportivo;
public class Manager {
    private PlayerList playerList;
    private MatchmakeList matchmakeList;

    public Manager() {
        playerList = new PlayerList();
        matchmakeList = new MatchmakeList();

    }
    
    public void createPlayer(String name) {
        if (!playerList.exists(name)) {
            playerList.add(new Player(name));
            System.out.println("Jugador " + name + " creado.");
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
    
    
    /**
     * A grosso modo mi idea 
     * 
     * public void command (String string) {
     *   switch (String.contains(string)) {
     *       case "add": playerList.add(string.split(" "));
     *       case ... : 
     *          ...
     *      si no: "ERROR: comando no especificado. "           
     *  }
     * }
     * 
     */
    
}
