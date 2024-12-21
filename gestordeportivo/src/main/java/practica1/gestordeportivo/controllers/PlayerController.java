package practica1.gestordeportivo.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;

public class PlayerController extends Controller{

    public PlayerController(CommandLineInterpreter cli) {
        super(cli);
    }
   
    public void create(String username, String password, String forename, String surname, String id) {
        Player player = new Player(username, password, forename, surname, id);
        getCli().getPlayerList().getPlayers().add(player);
        player.setCreator(getCli().getAuthenticatedAdmin());
    }

    public void delete(Player player) {
        getCli().getPlayerList().getPlayers().remove(player);
    }

    public void saveAllPlayers() {
        BufferedWriter bwPlayer = getCli().getPlayerList().createPlayersFile();

        for(Player player : getCli().getPlayerList().getPlayers()) {
            try {
                bwPlayer.write(player.getUsername() + "," + player.getPassword() + "," + 
                                player.getForename() + "," + player.getSurname() + "," + player.getId());
                bwPlayer.newLine();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    public void recoverAllPlayers() {
        File playersFile = new File("playerFile.txt");
        try (Scanner scanner = new Scanner(playersFile)) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                create(parts[0], parts[1], parts[2], parts[3], parts[4]);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}