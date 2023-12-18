package tutorialJava.capitulo7_Recursos.ejemploInsultoRecibidoListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PideFrasesAlUsuario {

	private static List<SobreFraseListener> listeners = new ArrayList<SobreFraseListener>();
	private static String insultos[] = new String[] {"tonto", "tonta", "tonte", "tontx"};
	
	/**
	 * 
	 * @param l
	 */
	public static void addSobreFraseListener (SobreFraseListener l) {
		listeners.add(l);
	}
	
	/**
	 * 
	 * @param l
	 */
	public static void removeSobreFraseListener (SobreFraseListener l) {
		listeners.remove(l);
	}
	
	/**
	 * 
	 */
	private static void fireFraseVacia() {
		for (SobreFraseListener l : listeners) {
			l.fraseVacia();
		}
	}
	
	/**
	 * 
	 */
	private static void fireFraseDemasiadoCorta(SobreFraseEvent e) {
		for (SobreFraseListener l : listeners) {
			l.fraseDemasiadoCorta(e);
		}
	}
	
	/**
	 * 
	 */
	private static void fireInsultoRecibido(SobreFraseEvent e) {
		for (SobreFraseListener l : listeners) {
			l.insultoRecibido(e);
		}
	}
	
	/**
	 * 
	 * @param frase
	 */
	private static void procesaFrase(String frase) {
		// Comprobamos si la frase esta vacía
		if (frase.trim().equals("")) {
			fireFraseVacia();
			return;
		}
		// Comprobamos frase demasiado corta
		String palabras[] = frase.split("[ ]+");
		if (palabras.length < 2) {
			SobreFraseEvent e = new SobreFraseEvent();
			e.setFraseCompleta(frase);
			fireFraseDemasiadoCorta(e);
			return;
		}
		// Comprobar insultos
		for (int i = 0; i < insultos.length; i++) {
			SobreFraseEvent e = new SobreFraseEvent();
			e.setFraseCompleta(frase);
			if (frase.indexOf(insultos[i]) != -1) {
				e.setInsultoRecibido(insultos[i]);
				fireInsultoRecibido(e);
				return;
			}
		}
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = "";
		
		Jesus j = new Jesus();
		
		do {
			System.out.println("Usuario, dame una frase: ");
			frase = sc.nextLine();
			procesaFrase(frase);
		} while (!frase.toLowerCase().equals("bye"));
		System.out.println("Adiós");
	}

}
