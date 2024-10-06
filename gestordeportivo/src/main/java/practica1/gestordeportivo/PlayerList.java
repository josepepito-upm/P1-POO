package practica1.gestordeportivo;
public class PlayerList {

private Player[] players;
private int size;
private int numPlayers;

public PlayerList() {
   size = 10;  
   players = new Player[size];
   numPlayers = 0;
}

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

public void show() {
   for (int i = 0; i < numPlayers; i++) {
      System.out.println(players[i]);
   }
}

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

public int getNumPlayers() {
   return numPlayers;
}

public Player[] getPlayers() {
   return players;
}

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
