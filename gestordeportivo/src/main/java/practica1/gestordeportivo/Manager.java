package practica1.gestordeportivo;
public class Manager {
    private PlayerList playerList;
    private MatchmakeList matchmakeList;

    public Manager() {
        playerList = new PlayerList();
        matchmakeList = new MatchmakeList();

    }
    /* 
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
    */
    
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

     public void command (String command) {
        String action[] = command.split(" ");

        switch (action[0]) {
            case "create":
                playerList.add(new Player(action[1]));
                break;
            case "remove":
                playerList.remove(action[1]);
                break;
            case "show":
                playerList.show();
                break;
            case "score":
                String aux[] = action[1].split(";");
                playerList.getPlayer(aux[0]).setScore(Float.parseFloat(aux[1]));
                break;
            case "rank":
                playerList.rank();
                break;
            case "show_matchmake":
                matchmakeList.show();
            case "clear_matchmake":
                matchmakeList.clear();
                break;
            case "matchmake":
                String aux2[] = action[1].split(";");
                matchmakeList.match(playerList.getPlayer(aux2[0]), playerList.getPlayer(aux2[1]));
                break;
            case "random_matchmake":
                matchmakeList.random(playerList);
                break;
            case "help":
                System.out.println("------------------- COMANDOS DISPONIBLES --------------------");
                System.out.println("> create [player]:              crea un jugador en el sistema");
                /**
                 * El resto lo hacéis mañana, yo me voy a dormir ya que tengo sueño
                 * Fdo. Rubén
                 */
            default:
                System.out.println("ERROR: comando desconocido. Escriba 'help' para todas las opciones disponibles");
                break;
        }
     }
    
}
