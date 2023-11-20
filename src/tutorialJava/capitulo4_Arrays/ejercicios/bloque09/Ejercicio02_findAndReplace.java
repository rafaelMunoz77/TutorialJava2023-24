package tutorialJava.capitulo4_Arrays.ejercicios.bloque09;

import tutorialJava.UtilsArrays;

public class Ejercicio02_findAndReplace {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[] {97, 98, 99, 100};

		UtilsArrays.imprimeArray(a);
		findAndReplace(a, 99, 115);
		UtilsArrays.imprimeArray(a);
		
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	public static void findAndReplace (int b[], int buscado, int reemplazo) {
		StringBuffer sb = new StringBuffer();
				
		for (int i = 0; i < b.length; i++) {
			if (b[i] == buscado) {
				b[i] = reemplazo;
			}
		}
	}

}
