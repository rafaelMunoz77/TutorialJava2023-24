package tutorialJava.capitulo4_Arrays.ejercicios.bloque02;

import tutorialJava.UtilsArrays;

public class Ejercicio01_ParesCambianSignoEnArray {

	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		int a[] = new int[15];
		UtilsArrays.inicializaArray(a, -100, 100);
		UtilsArrays.imprimeArray(a);
		cambiaSignoEnValores(a);
		UtilsArrays.imprimeArray(a);
	}
	
	/**
	 * 
	 * @param array
	 */
	public static void cambiaSignoEnValores(int array[]) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				array[i] = -array[i];
			}
		}
	}
	
}
