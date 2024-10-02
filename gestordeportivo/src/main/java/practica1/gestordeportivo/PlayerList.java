package practica1.gestordeportivo;

public class PlayerList {

private Player[] players;
private int size;

public PlayerList(Player player) {
    size = 10;  
    this.players = new Player[size];
    players[0] = player;
}

public void addPlayer (Player player) {
   int count = 0; boolean added = false; 
   while(count < players.length && !added) {  
      assert players[count] != player : "ERROR: player already added.";
      
      if(players[count] == null) {
         players[count] = player;
         added = true;
      }

      count++;
   }

   this.resize(count);   
}

public void removePlayer (Player player) {
   int count = players.length; boolean removed = false;

   while (count > 0 && !removed) {
      if (players[count] == player) {
               
      }
      count--;
   }

}

private void resize (int index) {
   if (index == players.length) {
      int aux = size + 10;
      Player[] auxPlayers = new Player[aux];
      for (int i = 0; i < players.length ; i++) {
         auxPlayers[i] = players [i]; 
      }

      size+=10;
      players = auxPlayers;

   }
}




}
