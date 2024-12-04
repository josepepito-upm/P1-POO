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

    public String toString() {
        return "Marked points: " + this.markedPoints +
        "\nMatches won: " + this.matchesWon +
        "\nAssistance points: " + this.assistancePoints +
        "\nTournaments won: " + this.tournamentsWon +
        "\nGenerated money: " + this.generatedMoney;
    }


    public double[] getStats() {
        return stats;
    }

    public double getStat(int position) {
        return stats[position];
    }

    

    

}
