package tutorialJava.capitulo7_Recursos.ejemploEntraPersonaListener;

import java.util.ArrayList;
import java.util.List;

import tutorialJava.Utils;

public class Principal {

	private static List<PersonaEntraListener> listeners = new ArrayList<PersonaEntraListener>();
	
	public static void addPersonaEntraListener (PersonaEntraListener p) {
		listeners.add(p);
	}
	
	public static void removePersonaEntraListener (PersonaEntraListener p) {
		listeners.remove(p);
	}
	
	private static void fireEntraPersona(String nombrePer) {
		for (PersonaEntraListener l : listeners) {
			l.entraPersona(new PersonaEntraEvent(nombrePer));
		}
	}
	
	public static void main(String[] args) {
		
		Padre p = new Padre();
		Madre m = new Madre();
		
		do {
			String nombrePer = Utils.obtenerCadenaConDescripcion("Quién ha entrado?: ");
			
			if (nombrePer.equalsIgnoreCase("maría") || nombrePer.equalsIgnoreCase("jesús")) {
				// Lanzo notificació a la lista de listeners
				fireEntraPersona(nombrePer);
			}
			
		} while(true);
	}

}
