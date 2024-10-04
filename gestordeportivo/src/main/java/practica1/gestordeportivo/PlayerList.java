package practica1.gestordeportivo;
public class PlayerList {

private Player[] players;
private int size;
private int numPlayers;
private boolean added;

public PlayerList() {
   size = 10;  
   players = new Player[size];
   added = false;
}

public PlayerList(Player player) {
    size = 10;  
    players = new Player[size];
    players[0] = player;
}

public void add(Player player) {
   
   while(numPlayers < players.length && !added) {  
      assert players[numPlayers] != player : "ERROR: el jugador ya ha sido añadido.";
      
      if(players[numPlayers] == null) {
         players[numPlayers] = player;
         added = true;
      }

      numPlayers++;
   }

   this.resize(numPlayers);   
}

public void remove(Player player) {
   boolean removed = false;

   while (numPlayers > 0 && !removed) {
      if (players[numPlayers] == player) {
         players[numPlayers] = null;
         removed = true;         
      }
      numPlayers--;
   }

   assert removed : "ERROR: jugador no encontrado.";

}

private void resize(int index) {
   if (index == players.length) {
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
   
}

public boolean exists(String name) {
   for (Player player : players) {
       if (player != null && player.getName().equals(name)) {
           return true;
       }
   }
   return false;
}

public int getNumPlayers() {
   return numPlayers;
}

}
