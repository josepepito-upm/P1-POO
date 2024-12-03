package practica1.gestordeportivo.views;

public class ErrorView {

    private final String ERRORMESSAGES[] = {"comando no encontrado.", 
                                      "error de sintaxis",
                                    };
    private Error error;                                 

   void writeMsg(String message) {
        
            System.out.println(message);            
        
    } 
}
