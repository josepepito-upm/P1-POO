package practica1.gestordeportivo.models;

import practica1.gestordeportivo.models.lists.PlayerList;

public class Matchmake {
 
    private Player[] members;
    private Player player;

    public Matchmake(String player1, String player2) {
        members = new Player[2];
        addMembers();
    }

    private void addMembers() {
        for (int i = 0; i < members.length; i++) {
            for (int j = 0; j < /*longitud de la lista de jugadores; j++)*/; j++) {
                members[i] = //posicion del jugador en la lista
            }
        }
    }

    public void unmatch () {
        
    }

    public String toString() {
        return members[0] + "vs." + members[1];
    }
    
}