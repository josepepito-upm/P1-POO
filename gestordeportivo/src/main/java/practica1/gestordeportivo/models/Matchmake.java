package practica1.gestordeportivo.models;

import practica1.gestordeportivo.models.lists.PlayerList;

public class Matchmake {
 
    private Player[] members;
    
    public Matchmake(String player1, String player2, PlayerList playerList) {
        members = new Player[2];
        addMembers(player1, player2, playerList);
    }

    private void addMembers(String player1, String player2, PlayerList playerList) {
        // for (int i = 0; i < members.length; i++) {
        //     for (int j = 0; j < /*longitud de la lista de jugadores; j++)*/; j++) {
        //         members[i] = //posicion del jugador en la lista
        //     }
        // }
        members[0] = playerList.getPlayer(player1); // Busca y asigna el primer jugador
        members[1] = playerList.getPlayer(player2);
    }

    public void unmatch () {
        if (members[0] != null) members[0].setMatched(false);
        if (members[1] != null) members[1].setMatched(false);
    }

    public String toString() {
        return members[0] + "vs." + members[1];
    }
    
}