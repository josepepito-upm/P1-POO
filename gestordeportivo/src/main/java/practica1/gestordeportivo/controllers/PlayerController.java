package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;

public class PlayerController {
   
    protected CommandLineInterpreter cli;
    
    public PlayerController (CommandLineInterpreter cli) {
        this.cli = cli;
    }

    public void add(String[] playerData) {
        cli.getPlayerList().add(new Player(playerData, playerData, playerData));
    }

	public void add(String[] playerData) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'add'");
	}



}
