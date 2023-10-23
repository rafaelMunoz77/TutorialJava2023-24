package tutorialJava.capitulo4_Arrays.ejercicios.bloque02;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ejercicio04_DeplazamientoCiclicoDerecha {

	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		int a[] = new int[] {1, 2, 3, 4, 5};
		
		UtilsArrays.imprimeArray(a);
		desplazaCiclicoDerecha(a);
		UtilsArrays.imprimeArray(a);
	}
	
	/**
	 * 
	 * @param a
	 * @param factor
	 */
	public static void desplazaCiclicoDerecha (int a[]) {
		int aux = a[a.length - 1];
		for (int i = (a.length - 1); i > 0; i--) {
			a[i] = a[i - 1];
		}
		a[0] = aux;
	}
	
}










