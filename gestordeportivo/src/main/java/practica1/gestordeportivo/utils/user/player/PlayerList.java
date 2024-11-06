package practica1.gestordeportivo.utils.user.player;

public class PlayerList {
   //cambiar array por lista (?)
   private Player[] players; //se cambia por private List<Player> players;
   private int size; //desaparece
   private int numPlayers; //desaparece

   //se cambia por el constructor de la lista
   public PlayerList() {
    size = 10;  
     players = new Player[size];
     numPlayers = 0;
   }

   //desaparece (api de java)
   public void add(Player player) {
      boolean added = false; 
      int count = 0; 
   
      while(count < players.length && !added) {  
         assert players[numPlayers] != player : "ERROR: el jugador ya ha sido añadido.";
      
         if(players[numPlayers] == null) {
           players[numPlayers] = player;
           added = true;
           numPlayers++;
         }
         count++;
      }
      this.resize();   
   }

   //desaparece (api de java)
   public void remove(String name) {
      boolean removed = false;
      int i = 0;
      while (i < numPlayers && !removed) {
         if (players[i].getName().equals(name)) {
            players[i] = players[numPlayers - 1];
            players[numPlayers - 1] = null;
            numPlayers--;
            removed = true;
         }
         i++;
      }
      assert removed : "ERROR: jugador no encontrado.";
   }

   //desaparece
   private void resize() {
      if (numPlayers == players.length) {
         int aux = size + 10;
         Player[] auxPlayers = new Player[aux];
         for (int i = 0; i < players.length ; i++) {
            auxPlayers[i] = players [i]; 
         }

         size = aux;
         players = auxPlayers;
      } 
   }

   //rehacer para listas (no se si hay comando de la api de java para esto)
   public void show() {
      for (int i = 0; i < numPlayers; i++) {
         System.out.println(players[i]);
      }
   }

   //rehacer para listas
   public void rank()  {
      Player[] playersAux = players;
      Player auxPlayer;
      for (int i = 1; i < playersAux.length; i++) {
         int point = i;

         if (playersAux[i] != null) {
            auxPlayer = playersAux[i];
      
            while (point > 0 && playersAux[point - 1].getScore() < auxPlayer.getScore()) {
               playersAux[point] = playersAux[point - 1];
         
               point--;
            }

         playersAux[point] = auxPlayer;
      
         }
      }

      for (int i = 0; i < playersAux.length; i++) {
         if(playersAux[i] != null)
            System.out.println(i+1 + "º " + playersAux[i].toString());
      }
      
   
   }

   //desaparece
   public int getNumPlayers() {
      return numPlayers;
   }

   //no se si desaparece
   public Player[] getPlayers() {
      return players;
   }

   //rehacer para listas + assert
   public Player getPlayer(String name) {
      Player foundPlayer = null;
      int i = 0;
      while (i < numPlayers && foundPlayer == null) {
         if (players[i].getName().equals(name)) {
            foundPlayer = players[i];
         }
         i++;
      }
      assert foundPlayer != null : "ERROR: jugador no encontrado.";
      return foundPlayer;
   }

}
