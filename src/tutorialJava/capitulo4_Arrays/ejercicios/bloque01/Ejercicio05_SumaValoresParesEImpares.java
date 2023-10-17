package tutorialJava.capitulo4_Arrays.ejercicios.bloque01;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ejercicio05_SumaValoresParesEImpares {

	public static void main(String[] args) {
		int array[] = new int[5];
		int suma = 0;
		
		UtilsArrays.inicializaArray(array, 0, 100);
		
		UtilsArrays.imprimeArray(array);
		
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0) {
				suma += array[i];
			}
		}
		
		System.out.println("Suma: " + suma);
	}

}







