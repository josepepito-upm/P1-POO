package practica1.gestordeportivo.views;

import practica1.gestordeportivo.models.CommandLineInterpreter;

public class StatsView {

    private CommandLineInterpreter cli;

    private final String DELIMITER = "---------------------------------------------------------------------------------------------------";
    public void showStatisticsCSV() {
        
        String[] statsNames = {"Puntos marcados", "Partidos ganados", "Puntos de asistencia", "Torneos ganados", "Dinero generado"};
        double[] statsValues = cli.getAuthenticatedPlayer().getStats().getStats();

        for (int i = 0; i < statsNames.length; i++) {
            System.out.println(statsNames[i] + "\t");
        }
        System.out.println(DELIMITER);
        for (int i = 0; i < statsNames.length; i++) {
            System.out.println(statsValues[i] + "\t");
        }
        
    }

    public void showStatisticsJSON() {
        cli.getAuthenticatedPlayer().getStats().toString();
    }
}