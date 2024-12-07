package practica1.gestordeportivo.models.lists;

import java.util.ArrayList;
import java.util.Random;

import practica1.gestordeportivo.models.Matchmake;
import practica1.gestordeportivo.models.Player;

public class PlayerList {

   private ArrayList<Player> players;

   public PlayerList() {
      players = new ArrayList<>();
   }

   public ArrayList<Player> getPlayers() {
      return players;
   }

   public Player getPlayer(String id) {
      for (Player player : players) {
         if (player.getId().equals(id)) {
            return player;
         }
      }
      return null;
   }

   //hay que hacerlo bien porq se usa en el comando tournament-list
   public void rank(int statCategory) {
      players.sort((player1, player2) -> {
        double stat1 = player1.getStats().getStat(statCategory);
        double stat2 = player2.getStats().getStat(statCategory);
        return Double.compare(stat2, stat1); // Orden descendente
    });

    for (int i = 0; i < players.size(); i++) {
        System.out.println((i + 1) + ") " + players.get(i).getForename() + " - Stat[" + statCategory + "]: " +
         players.get(i).getStats().getStat(statCategory));
    }
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
