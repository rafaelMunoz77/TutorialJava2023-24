package tutorialJava.capitulo4_Arrays.ejercicios.bloque09;

import tutorialJava.UtilsArrays;

public class Ejercicio04_countOccurrences {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[] {97, 98, 99, 100, 99, 98};

		UtilsArrays.imprimeArray(a);
		System.out.println("Ocurrencias de 99: " + countOcurrences(a, 99));
		
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	public static int countOcurrences (int b[], int occurrence) {
		int cont = 0;
		
		for (int i : b) {
			if (i == occurrence) cont++;
		}
		return cont;
	}

}
