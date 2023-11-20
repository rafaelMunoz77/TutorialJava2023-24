package tutorialJava.capitulo4_Arrays.ejercicios.bloque09;

import tutorialJava.UtilsArrays;

public class Ejercicio03_addInteger {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[] {97, 98, 99, 100};

		UtilsArrays.imprimeArray(a);
		UtilsArrays.imprimeArray(addInteger(a, 99));
		
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	public static int[] addInteger (int b[], int agregado) {
		int c[] = new int[b.length + 1];
		
		for (int i = 0; i < b.length; i++) {
			c[i] = b[i];
		}
		
		c[c.length - 1] = agregado;
		return c;
	}

}
