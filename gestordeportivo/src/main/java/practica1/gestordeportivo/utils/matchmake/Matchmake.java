package practica1.gestordeportivo.utils.matchmake;

import practica1.gestordeportivo.utils.user.player.Player;

public class Matchmake {
    
    private final Player player1;
    private final Player player2;

    //usar array de dos jugadores
    public Matchmake(Player p1, Player p2) {
        this.player1 = p1;
            p1.setMatched(true);
        this.player2 = p2;
            p2.setMatched(true);        
    }

    public void unmatch () {
        player1.setMatched(false);
        player2.setMatched(false);
    }

    public String toString() {
        return player1.getName() + " (" + player1.getScore() + ") vs. " + player2.getName() + " (" + player2.getScore() + ")";
    }
    
}