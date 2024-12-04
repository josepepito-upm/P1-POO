package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.models.lists.PlayerList;

public class PlayerCreate extends AdminCommands {

    private String arguments;
    
    public PlayerCreate(String arguments) {
        this.arguments = arguments;
    }

    @Override
    public Error execute(String command) {

        // Verifica que el rol actual sea ADMIN
        if (!validate()) {
            return new Error("");
        }

        // Divide el comando en partes
        String[] parts = command.split(" ");
        if (parts.length < 2) {
            return new Error("Formato incorrecto. Usa: player-create nombre;apellidos;DNI;correo");
        }

        // Extrae los datos del jugador del comando
        String[] playerData = parts[1].split(";");
        if (playerData.length < 4) {
            return new Error("Se requieren al menos 4 valores: nombre, apellidos, DNI y correo.");
        }

        // Verifica si el jugador ya existe
        for (Player existingPlayer : playerList.getPlayers()) {
            if (existingPlayer.getId().equals(playerData[2])) { // Compara el DNI
                return new Error("El comando ya existe");
            }
        }

        // Llama al controlador para crear el jugador
        new PlayerController(cli).add(playerData);
        System.out.println("Jugador creado: " + playerData[0] + " " + playerData[1]);
        return null;
    }
}
