package tutorialJava.examenes.examen_20231024;

import tutorialJava.UtilsArrays;

public class EjercicioD_CantidadPrimosEnArray {

	public static void main(String[] args) {
		int a[] = new int[100];
		int contadorPrimos = 0;
		
		UtilsArrays.inicializaArray(a, 0, 100);
		UtilsArrays.imprimeArray(a);

		for (int i = 0; i < a.length; i++) {
			if (esPrimo(a[i])) {
				contadorPrimos++;
				System.out.print(a[i] + " ");
			}
		}
		
		// Imprimo la cantidad de primos encontrados
		System.out.println("\nPrimos encontrados: " + contadorPrimos);
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static boolean esPrimo (int n) {
		if (n == 0 || n == 1) return false;
		
		for(int i = 2; i < n; i++) {
			if (n % i == 0) { // He encontado un divisor
				return false;
			}
		}
		return true;
	}

}














