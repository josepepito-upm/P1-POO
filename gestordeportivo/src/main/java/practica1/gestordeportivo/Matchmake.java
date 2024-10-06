package practica1.gestordeportivo;

public class Matchmake {
    
    private Player p1;
    private Player p2;

    public Matchmake(Player p1, Player p2) {
        this.p1 = p1;
            p1.setMatchmaking(true);
        this.p2 = p2;
            p2.setMatchmaking(true);        
    }

    public void unmatch () {
        p1.setMatchmaking(false);
        p2.setMatchmaking(false);
    }

    public String toString() {
        return p1.getName() + "(" + p1.getScore() + ") vs. " + p2.getName() + "(" + p2.getScore() + ")";
    }
    
}