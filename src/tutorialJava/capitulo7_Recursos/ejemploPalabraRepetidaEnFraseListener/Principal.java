package tutorialJava.capitulo7_Recursos.ejemploPalabraRepetidaEnFraseListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	private static List<PalabraRepetidaListener> listeners = 
			new ArrayList<PalabraRepetidaListener>();
	
	
	private static void firePalabraRepetidaEncontrada(String palabra) {
		PalabraRepetidaEvent event = new PalabraRepetidaEvent(palabra);
		for (PalabraRepetidaListener listener : listeners) {
			listener.palabraRepetidaEncontrada(event);
		}
	}
	
	
	public static void addPalabraRepetidaListener(PalabraRepetidaListener l) {
		listeners.add(l);
	}
	
	public static void removePalabraRepetidaListener(PalabraRepetidaListener l) {
		listeners.remove(l);
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = "";
		
		CorrectorOrtografico alejandro = new CorrectorOrtografico("Alejandro");
		CorrectorOrtografico sergio = new CorrectorOrtografico("Sergio");
		Informatica carmen = new Informatica("Carmen");
		
		
		do {
			System.out.println("Dame una frase: ");
			frase = sc.nextLine();
			String palabras[] = frase.split("[\s]+");
			List<String> listaPalabras = Arrays.asList(palabras);
			
			for (int i = 0; i < palabras.length; i++) {
				String palabra = palabras[i];
				if (listaPalabras.subList(0, i).contains(palabra)) {
					System.out.println("La palabra " + palabra + " está "
							+ "repetida");
					firePalabraRepetidaEncontrada(palabra);
				}
			}
			
		} while (!frase.equals(""));

	}

}









