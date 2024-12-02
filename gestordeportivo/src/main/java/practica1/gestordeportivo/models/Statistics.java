package practica1.gestordeportivo.models;

public class Statistics {
    
    private double markedPoints;
    private double matchesWon;
    private double assistancePoints;
    private double tournamentsWon;
    private double generatedMoney;

    private double[] stats;

    public Statistics() {
        initialize();
    }

    private void initialize() {
        stats = new double[] {markedPoints, matchesWon, assistancePoints, tournamentsWon, generatedMoney};
        for (int i = 0; i < stats.length; i++) {
            stats[i] = 0;
        }
    }
}
