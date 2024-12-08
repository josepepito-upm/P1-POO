package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.types.Errors;

public class StatisticsShow extends PlayerCommands {
    
    private CommandLineInterpreter cli;

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");
        if (parts.length != 1) {
            return Errors.FORMAT_ERROR;
        }

        if (!(cli.getAuthenticatedUser() instanceof Player)) {
            return Errors.UNAUTHORIZED_COMMAND;
        }

        return null; // Validación exitosa
    }

    public Errors execute(String command) {
        Errors validationErrors = validate(command);
        if (validationErrors!=null){
            return validationErrors;
        }
        Player player = (Player) cli.getAuthenticatedUser();
        System.out.println("Estadísticas de " + player.getForename() + " " + player.getSurname() + ":");
        String[] statsNames = {
            "Puntos marcados", 
            "Partidos ganados", 
            "Puntos de asistencia", 
            "Torneos ganados", 
            "Dinero generado"
        };
        double[] statsValues = player.getStats().getStats();
        
        for (int i = 0; i < statsNames.length; i++) {
            System.out.println(statsNames[i] + ": " + statsValues[i]);
        }

        return null;
    }

    public StatisticsShow(CommandLineInterpreter cli){
        this.cli = cli;
    }


}
