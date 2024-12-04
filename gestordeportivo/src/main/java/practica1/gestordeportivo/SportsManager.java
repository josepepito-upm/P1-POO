package practica1.gestordeportivo;

import practica1.gestordeportivo.models.CommandLineInterpreter;

public class SportsManager {
    
    public static void main(String[] args) {
        CommandLineInterpreter cli = new CommandLineInterpreter();
        cli.executeCommand("tournament-list");
    }
}