package tutorialJava.examenes.examen_20240130.ejercicio3;

import java.util.ArrayList;
import java.util.List;

import tutorialJava.Utils;

public class Principal {
	
	
	private static List<EventoMeteorologicoListener> listeners = new ArrayList<EventoMeteorologicoListener>();
	
	public static void addEventoMeteorologicoListener (EventoMeteorologicoListener l) {
		listeners.add(l);
	}
	
	public static void removeEventoMeteorologicoListener (EventoMeteorologicoListener l) {
		listeners.remove(l);
	}
	
	public static void fireEventoLlueve () {
		for(EventoMeteorologicoListener l : listeners) {
			l.comienzaALlover();
		}
	}
	
	public static void fireEventoDejaDeLlover () {
		for(EventoMeteorologicoListener l : listeners) {
			l.terminaDeLlover();
		}
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String tiempoActual = "", tiempoAnterior = "";
		
		Dummy d = new Dummy();
		addEventoMeteorologicoListener(d);
		
		do {
			tiempoAnterior = tiempoActual;
			tiempoActual = Utils.obtenerCadenaConDescripcion("Dime el tiempo que hace ('lluvia',"
					+ "'soleado' o 'nublado':");
			
			if (tiempoAnterior.equalsIgnoreCase("lluvia") && tiempoActual.equalsIgnoreCase("soleado")) {
				fireEventoDejaDeLlover();
			}
			else {
				if (tiempoActual.equalsIgnoreCase("lluvia")) {
					fireEventoLlueve();
				}
			}
			
		} while (true);

	}

}
