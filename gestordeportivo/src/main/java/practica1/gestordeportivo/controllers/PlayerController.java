package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;

public class PlayerController {
   
    protected CommandLineInterpreter cli;
    
    PlayerController (CommandLineInterpreter cli) {
        this.cli = cli;
    }

    public void add(String name) {
        cli.getPlayerList().add(new Player(name, name, name));
    }



}
