package practica1.gestordeportivo;
public class Manager {
    private final PlayerList playerList;
    private final MatchmakeList matchmakeList;

    public Manager() {
        playerList = new PlayerList();
        matchmakeList = new MatchmakeList();

    }

    public Manager(PlayerList player_list, MatchmakeList matchmake_list) {
        playerList = player_list;
        matchmakeList = matchmake_list;
    }
    
    public void Commands (String command) {
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
                System.out.println("--------------------------- COMANDOS DISPONIBLES -----------------------------");
                System.out.println(" create [player]:               Crea un jugador en el sistema");
                System.out.println(" remove [player]:               Elimina un jugador del sistema");
                System.out.println(" show:                          Muestra la lista de jugadores");
                System.out.println(" rank:                          Clasifica a los jugadores segun su puntuación");
                System.out.println(" score [player];[score]:        Asigna una puntuación a un jugdador");
                System.out.println(" show_matchmake:                Muestra los emparejamientos");
                System.out.println(" clear_matchmake:               Borra los emparejamientos");
                System.out.println(" matchmake [player1];[player2]: Crea emparejamiento entre dos jugadores");
                System.out.println(" random_matchmake:              Crea emparejamientos aleatorios");

            default:
                System.out.println("ERROR: comando desconocido. Escriba 'help' para todas las opciones disponibles");
                break;
        }
    }
    
}
