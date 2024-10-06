package practica1.gestordeportivo;

public class Matchmake {
    
    private final Player p1;
    private final Player p2;

    public Matchmake(Player p1, Player p2) {
        this.p1 = p1;
            p1.setMatched(true);
        this.p2 = p2;
            p2.setMatched(true);        
    }

    public void unmatch () {
        p1.setMatched(false);
        p2.setMatched(false);
    }

    public String toString() {
        return p1.getName() + " (" + p1.getScore() + ") vs. " + p2.getName() + " (" + p2.getScore() + ")";
    }
    
}