// package practica1.gestordeportivo;

// import practica1.gestordeportivo.commands.CommandInterface;
// import practica1.gestordeportivo.commands.PlayerCreate;
// import practica1.gestordeportivo.controllers.PlayerController;
// import practica1.gestordeportivo.models.CommandLineInterpreter;

// import java.util.ArrayList;
// import java.util.List;

// public class Manager {
//     private final List<CommandInterface> commands;
//     public PlayerController playerController;  // Añadir la instancia de PlayerController

//     public Manager() {
//         // Inicializa el controlador de jugadores
//         playerController = new PlayerController(new CommandLineInterpreter());

//         // Inicializa la lista de comandos y añade el comando PlayerCreate
//         commands = new ArrayList<>();
//         commands.add(new PlayerCreate(this));  // Pasa 'this' para acceder a 'Manager'
//     }

//     // Método para acceder al controlador de jugadores
//     public PlayerController getPlayerController() {
//         return playerController;
//     }

//     public void executeCommand(String command) {
//         for (CommandInterface cmd : commands) {
//             if (command.startsWith(cmd.getTitle())) {
//                 Error error = cmd.execute(command);
//                 if (error != null) {
//                     System.out.println("ERROR: " + error.getMessage());
//                 }
//                 return;
//             }
//         }
//         System.out.println("ERROR: Comando desconocido.");
//     }
// }



// /*import java.util.ArrayList;
// import java.util.List;

// import practica1.gestordeportivo.models.lists.MatchmakeList;
// import practica1.gestordeportivo.models.lists.PlayerList;
// import practica1.gestordeportivo.utils.commandList.Command; 



// import java.io.Console;

// import practica1.gestordeportivo.utils.user.player.Player;
// public class Manager {
//     private final PlayerList playerList;
//     private final MatchmakeList matchmakeList;
//     private final List<Command> commands;


//     //la que hay que montar aqui para hacer el menu con polimorfismo aksjdkas

//     public Manager() {
//         playerList = new PlayerList();
//         matchmakeList = new MatchmakeList();
//         commands = new ArrayList<>();
//         commands.add(new CreateCommand());

//     }

//     public Manager(PlayerList player_list, MatchmakeList matchmake_list) {
//         playerList = player_list;
//         matchmakeList = matchmake_list;
//         commands = new ArrayList<>();
//         commands.add(new CreateCommand());

//     }

//     //no se como hacerlo sin este getter así que me tendreis que ayudar o yo pensarlo en un futuro ASJAJSJAS
//     public PlayerList getPlayerList() {
//         return this.playerList;
//     }
    

//     public void Commands(String command) {
//         String[] action = command.split(" ");

//         for (Command cmd : commands) {
//             if (cmd.getTitle().equalsIgnoreCase(action[0])) {
//                 cmd.execute(action, this);
//                 return;
//             }
//         }

//         System.out.println("ERROR: comando desconocido. Escriba 'help' para todas las opciones disponibles");
//     }
//     // public void Commands (String command) {
//     //     String action[] = command.split(" ");

//     //     switch (action[0]) {
//     //         case "create":
//     //             playerList.add(new Player(action[1]));
//     //             System.out.println("Jugador '" + action[1] + "' creado.");
//     //             break;
//     //         case "remove":
//     //             playerList.remove(action[1]);
//     //             System.out.println("Jugador '" + action[1] + "' borrado.");
//     //             break;
//     //         case "show":
//     //             System.out.println("> JUGADORES EN EL SISTEMA <");
//     //             playerList.show();
//     //             break;
//     //         case "score":
//     //             String aux[] = action[1].split(";");
//     //             playerList.getPlayer(aux[0]).setScore(Float.parseFloat(aux[1]));
//     //             break;
//     //         case "rank":
//     //             System.out.println("> RANKING DE JUGADORES EN EL SISTEMA (mayor a menor puntuación) <");
//     //             playerList.rank();
//     //             break;
//     //         case "show_matchmake":
//     //             matchmakeList.show();
//     //         case "clear_matchmake":
//     //             matchmakeList.clear();
//     //             break;
//     //         case "matchmake":
//     //             String aux2[] = action[1].split(";");
//     //             matchmakeList.match(playerList.getPlayer(aux2[0]), playerList.getPlayer(aux2[1]));
//     //             System.out.println("Emparejamiento entre '" + action[0] + "' y '" + action[1] + "' creado.");
//     //             break;
//     //         case "random_matchmake":
//     //             matchmakeList.random(playerList);
//     //             System.out.println("Emparejamiento aleatorio hecho.");
//     //             break;
//     //         case "help":
//     //             System.out.println("--------------------------- COMANDOS DISPONIBLES -----------------------------");
//     //             System.out.println(" create [player]:                                Crea un jugador en el sistema");
//     //             System.out.println(" remove [player]:                               Elimina un jugador del sistema");
//     //             System.out.println(" show:                                           Muestra la lista de jugadores");
//     //             System.out.println(" rank:                           Clasifica a los jugadores segun su puntuación");
//     //             System.out.println(" score [player];[score]:                    Asigna una puntuación a un jugador");
//     //             System.out.println(" show_matchmake:                                   Muestra los emparejamientos");
//     //             System.out.println(" clear_matchmake:                                    Borra los emparejamientos");
//     //             System.out.println(" matchmake [player1];[player2]:        Crea emparejamiento entre dos jugadores");
//     //             System.out.println(" random_matchmake:                             Crea emparejamientos aleatorios");
//     //         default:
//     //             System.out.println("ERROR: comando desconocido. Escriba 'help' para todas las opciones disponibles");
//     //             break;
//     //     }
//     // }
       
//     public void manage() {
//         Console console = System.console();
               
//         playerList.add(new Player("Luisa", 4.5));
//         playerList.add(new Player("Manuel", 2.7));
//         playerList.add(new Player("Kurt", 4.0));
//         playerList.add(new Player("Sofia", 3.8));
//         playerList.add(new Player("Robert", 3.8));

//         String command = console.readLine("Introduzca un comando disponible: ");
//         while (!command.equalsIgnoreCase("exit")) {
//             this.Commands(command);
//             command = console.readLine("Introduzca otro comando o 'exit' para salir: ");
//         }
//     }
    
// }
// */