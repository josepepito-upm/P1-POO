package practica1.gestordeportivo.models;

import practica1.gestordeportivo.models.lists.PlayerList;

public class Matchmake {
 
    private Player[] members;

    
    public Matchmake(PlayerList playerList, String player1, String player2) {
        members = new Player[2];
        addMembers(playerList, player1, player2);
    }


    private void addMembers(PlayerList playerList, String player1, String player2) {
        members[0] = playerList.getPlayer(player1);
        members[1] = playerList.getPlayer(player2);
        for (Player member : members) {
            if (member != null) {
                member.setMatched(true);
            }
        }
    }

    public void unmatch () {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null) members[i].setMatched(false);
        }
    }

    public String toString() {
        return members[0] + "vs." + members[1];
    }

    public Player[] getMembers() {
        return members;
    }
    
}