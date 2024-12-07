package practica1.gestordeportivo.views;

import practica1.gestordeportivo.types.Errors;

public class ErrorView {

  public final String[] MESSAGES = {
    "Comando no encontrado.", 
    "Error de sintaxis.",
    "Error de formato.",
    "Comando no autorizado.",
    "Ya existe el jugador.",
    "No existe el jugador.",
    "El jugador se encuentra en un torneo en curso.",
    "Ya existe el equipo.",
    "No existe el equipo.",
    "El jugador se encuentra en el equipo.",
    "El jugador no se encuentra en el equipo.",
    "Un jugador ya está emparejado.",
    "El torneo no está en curso.",
    "El torneo está en curso.",
    "El jugador no está inscrito en el torneo.",
    "El equipo no está inscrito en el torneo.",
    "El formato del correo es incorrecto."
  };
                                  
  public void writeError(Errors error) {
    System.out.println(MESSAGES[error.ordinal()]);
  } 
}
