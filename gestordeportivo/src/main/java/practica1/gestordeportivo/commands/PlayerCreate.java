package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.Manager;

public class PlayerCreate extends AdminCommands {

    private Manager manager;

    public PlayerCreate(Manager manager) {
        this.manager = manager;
    }

    public Error execute(String command) {
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

        // Llama al controlador para crear el jugador
        manager.getPlayerController().add(playerData);
        System.out.println("Jugador creado: " + playerData[0] + " " + playerData[1]);
        return null;
    }

    public Error validate(String loqsea) {
        return null; 
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }
}
