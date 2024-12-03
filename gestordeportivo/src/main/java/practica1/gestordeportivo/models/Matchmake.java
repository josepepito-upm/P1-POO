package practica1.gestordeportivo.models;

public class Matchmake {
 
    private Player[] members;

    public Matchmake(String player1, String player2) {
        members = new Player[2];
        addMembers(player1, player2);
    }

    private void addMembers(String player1, String player2) {
        members[0] = .getPlayer(player1); //poner la playerlist que se crea al principio de la ejecucion
        members[1] = .getPlayer(player2);
        for (int i = 0; i < members.length; i++) {
            members[i].setMatched(true);
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
    
}