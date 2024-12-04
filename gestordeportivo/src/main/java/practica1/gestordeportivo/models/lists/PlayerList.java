package practica1.gestordeportivo.models.lists;

import practica1.gestordeportivo.models.Matchmake;
import practica1.gestordeportivo.models.Player;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class PlayerList {

   private ArrayList<Player> players;

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
   public void rank(int statCategory) {
      players.sort((player1, player2) -> {
        double stat1 = player1.getStats().getStat(statCategory);
        double stat2 = player2.getStats().getStat(statCategory);
        return Double.compare(stat2, stat1); // Orden descendente
    });

    // Mostrar ranking
    for (int i = 0; i < players.size(); i++) {
        System.out.println((i + 1) + ") " + players.get(i).getName() + " - Stat[" + statCategory + "]: " +
            players.get(i).getStats().getStat(statCategory));
    }
   }

 
   public ArrayList<Player> getPlayers() {
      return players;
   }

   public Player getPlayer(String name) {
      return players.stream()
         .filter(player -> player.getName().equals(name))
         .findFirst()
         .orElseThrow(() -> new AssertionError("ERROR: jugador no encontrado."));
  }

   public Matchmake matchMakeAuto() {
      if (players.size() < 2) {
            throw new IllegalArgumentException("ERROR: No hay suficientes jugadores para emparejar.");
      }

      // Seleccionar dos jugadores aleatorios
      Random rand = new Random();
      int index1 = rand.nextInt(players.size());
      int index2 = rand.nextInt(players.size());

      while (index1 == index2) {
            index2 = rand.nextInt(players.size()); // Asegurarse de que los dos jugadores sean diferentes
      }

      Player player1 = players.get(index1);
      Player player2 = players.get(index2);

      return new Matchmake(player1, player2); // Emparejamiento automático
    }

}
