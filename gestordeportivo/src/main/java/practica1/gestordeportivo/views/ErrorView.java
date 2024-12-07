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
    "No existe el usuario",
    "El jugador se encuentra en un torneo en curso.",
    "Ya existe el equipo.",
    "No existe el equipo.",
    "Ya hay un torneo con el mismo nombre",
    "El jugador se encuentra en el equipo.",
    "El jugador no se encuentra en el equipo.",
    "Un jugador ya está emparejado.",
    "El torneo no está en curso.",
    "El torneo está en curso.",
    "El jugador no está inscrito en el torneo.",
    "El equipo no está inscrito en el torneo.",
    "El formato del correo es incorrecto.",
    "Datos introducidos del equipo incorrectos.",
    "Datos introducidos del jugador incorrectos.",
    "Datos introducidos del torneo incorrectos.",
    "Emparejamiento invalido.",
    "Insuficientes participantes para el torneo.",
    "Permisos insuficientes para ejecutar este comando.",
    "Datos insuficientes para ejecutar esta operacion",
    "Operacion fallida.",
    "Datos no encontrados.",
    "Opcion de emparejamiento invalida/desconocida"
  };
                                  
  public void writeError(Errors error) {
    System.out.println(MESSAGES[error.ordinal()]);
  } 
}
