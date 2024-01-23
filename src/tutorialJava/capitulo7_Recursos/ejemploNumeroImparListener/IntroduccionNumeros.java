package tutorialJava.capitulo7_Recursos.ejemploNumeroImparListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntroduccionNumeros {

	private static List<NumeroImparListener> listNumeroImparListeners = 
			new ArrayList<NumeroImparListener>();
	
	/**
	 * 
	 * @param l
	 */
	public static void addNumeroImparListener(NumeroImparListener l) {
		listNumeroImparListeners.add(l);
	}
	
	/**
	 * 
	 * @param l
	 */
	public static void removeNumeroImparListener(NumeroImparListener l) {
		listNumeroImparListeners.remove(l);
	}
	
	/**
	 * 
	 */
	private static void fireNumeroImparListener(int numeroImparIntroducido) {
		NumeroImparEvent event = new NumeroImparEvent(numeroImparIntroducido);
		for (int i = listNumeroImparListeners.size() - 1; i >= 0; i--) {
			listNumeroImparListeners.get(i).numeroImparIntroducido(event);
		}
	}
	
	
	public static void main(String[] args) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		// doy de alta los listeners que quieren saber que se ha introducido un número impar
		Mesa mesa1 = new Mesa();
		addNumeroImparListener(mesa1);
		Perro perro1 = new Perro();
		addNumeroImparListener(perro1);
		Mesa mesa2 = new Mesa();
		addNumeroImparListener(mesa2);
		
		do {
			System.out.println("Introduzca un número, por favor: ");
			num = sc.nextInt();
			System.out.println("\tEl número introducido es " + num); 
			
			if (num % 2 == 1) {
				fireNumeroImparListener(num);
			}
			
		} while (num != 0);
	}

}
