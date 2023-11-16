package tutorialJava.capitulo4_Arrays.ejercicios.bloque08;

import tutorialJava.UtilsArrays;

public class Ejercicio01_arrayImparesYPares {

	public static void main(String[] args) {
		int a[] = new int[20];
		
		UtilsArrays.inicializaArray(a, 0, 100);
		UtilsArrays.imprimeArray(a);
		
		ordenaParesEImpares(a);
		
		UtilsArrays.imprimeArray(a);
	}

	/**
	 * 
	 * @param a
	 */
	public static void ordenaParesEImpares (int a[]) {
		
		while ( !(posicionUltimoPar(a) < posicionPrimerImpar(a))) {
			int primeraPosImpar = posicionPrimerImpar(a);
			int ultimaPosPar = posicionUltimoPar(a);
			
			int aux = a[primeraPosImpar];
			a[primeraPosImpar] = a[ultimaPosPar];
			a[ultimaPosPar] = aux;			
		}
	}
	
	
	public static int posicionUltimoPar (int a[]) {
		int posicion = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				posicion = i;
			}
		}
		return posicion;
	}
	
	
	public static int posicionPrimerImpar (int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 1) {
				return i;
			}
		}
		return -1;
	}
	
	
	
}









