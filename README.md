-- P1 POO: GESTOR DEPORTIVO --
*DESCRIPCIÓN:* 
Implementación de la primera práctica de POO hecha por alejandro Rosado, Mario Reyes y Rubén Nuño. Contiene todas las funcionalidades básicas y utilidades adicionales que pensamos que pueden ser útiles para alguien que utilice por primera vez el programa

*CLASES:*
 - GestorDeportivo.java: _(MAIN)_ contiene toda la interpretación de comandos y llamadas a clases públicas 
    *TODO:*
    * Incluir todas las funcionalidades que se requieren en la práctica (llamadas a clases y creación de objetos) [] 
    * Llamadas a comandos personalizados []
    * Interfaz de consola para llamar a estos comandos []
    * Rubén: Comando "help" que imprima por pantalla todos los comandos disponibles []
    * Rubén: Título nada más ejecutar el programa "algo como: GESTOR DEPORTIVO Vx.x: Introduzca "help" para saber comandos " []

- Player.java: Creación y uso de un jugador en la app ( algo como Player player(nombre, puntuación); ) 
    *TODO:*
    * Incluir todas las funcionalidades que se requieren (clase con nombre y puntuación) [] 
    * Nombre único y requerido por el usuario. La puntuación se añadiría después (A lo mejor establecer una puntuación mínima de base?) []
    * funcion que establezca la puntuación (float mínimo -999999.0) []

- PlayerList.java: Lista de jugadores en el sistema
    *TODO:*
    * toString: imprime los jugadores presentes en el sistema (lista)[] 
    * Añadir y eliminar jugadores con esta funcionalidad (Aquí entra el nombre único). []
    * Podría ser clase pública y Player una clase privada? []
    * Para el método de rankear, se ordenaría la lista en base a la puntuación en vez de los nombre de los jugadores []
- Matchmake.class: Hace un matchmaking entre 2 jugadores
    *TODO:*
    * Un método que lo llame. Se especifican los 2. Hay que ver que los jugadores no estén emparejados ya a la hora de hacerlo. []
    * Método que muestre todos los emparejamientos. [] 
- MatchmakeList.class: Lista de matchmakings en curso
    *TODO:*
    * Si no existe previamente, a la hora de hacer un matchmaking se deberá de crear una lista de cero si es el primero. []
    * Con esto se podrán mostrar todos los emparejamientos. [] 
    * Método que borre todos los emparejamientos
    * para el emparejamiento random, comprobar que el número de jugadores en la lista pasada sea par. Si no, no se podrá hacer. []
    * Emparejamiento normal entre 2 jugadores presentes en la lista (se deberá de comprobar que existe en la lista) []
*APUNTES:*

*AUTOEVALUACIÓN:*
