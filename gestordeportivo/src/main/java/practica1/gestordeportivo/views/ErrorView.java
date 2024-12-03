package practica1.gestordeportivo.views;

import practica1.gestordeportivo.models.Error;

public class ErrorView {

  public final String[] MESSAGES = {
    "Comando no encontrado.", 
    "Error de sintaxis"
  };
                                  
  public void writeError(Error error) {
    System.out.println(MESSAGES[error.ordinal()]);
  } 
}
