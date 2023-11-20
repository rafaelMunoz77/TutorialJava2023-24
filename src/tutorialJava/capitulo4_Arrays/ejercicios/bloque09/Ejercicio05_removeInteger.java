package tutorialJava.capitulo4_Arrays.ejercicios.bloque09;

import tutorialJava.UtilsArrays;

public class Ejercicio05_removeInteger {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[] {99, 98, 99, 100, 99, 98};

		UtilsArrays.imprimeArray(a);
		UtilsArrays.imprimeArray(removeInteger(a, 99));
		
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	public static int[] removeInteger (int b[], int forRemove) {
		int contOccurrences = 
				Ejercicio04_countOccurrences.countOcurrences(b, forRemove);
		int c[] = new int[b.length - contOccurrences];
	
		int j = 0; // Sólo se utiliza en el nuevo array creado
		for (int num : b) {
			if (num != forRemove) {
				c[j] = num;
				j++;
			}
		}
		return c;
	}

}




