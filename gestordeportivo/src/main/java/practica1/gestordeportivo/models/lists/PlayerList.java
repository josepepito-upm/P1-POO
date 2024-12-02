package practica1.gestordeportivo.models.lists;

import practica1.gestordeportivo.models.Player;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayerList {
   //cambiar array por lista (?)
   private List<Player> players; //se cambia por private List<Player> players;

   //se cambia por el constructor de la lista
   public PlayerList() {
    players = new ArrayList<>();
   }

   //desaparece (api de java)
   public void add(Player player) {
      assert !players.contains(player) : "ERROR: el jugador ya ha sido añadido.";
      players.add(player);
   }

   //desaparece (api de java)
   public void remove(String name) {
      boolean removed = players.removeIf(player -> player.getName().equals(name));
      assert removed : "ERROR: jugador no encontrado.";
   }

 
   //rehacer para listas (no se si hay comando de la api de java para esto)
   public String show() {
      StringBuilder stringBuilder = new StringBuilder();
      for (Player player : players) {
         stringBuilder.append(player).append("\n");
      }
      return stringBuilder.toString();
   }

   //rehacer para listas
   public void rank() {
      players.sort(Comparator.comparingDouble(Player::getScore).reversed());
      for (int i = 0; i < players.size(); i++) {
         System.out.println((i + 1) + ") " + players.get(i).toString());
      }
   }


   public List<Player> getPlayers() {
      return players;
   }

   public Player getPlayer(String name) {
      return players.stream()
         .filter(player -> player.getName().equals(name))
         .findFirst()
         .orElseThrow(() -> new AssertionError("ERROR: jugador no encontrado."));
   }

}
