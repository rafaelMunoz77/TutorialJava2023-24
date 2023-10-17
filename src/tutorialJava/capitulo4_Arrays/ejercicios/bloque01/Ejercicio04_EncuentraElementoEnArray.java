package tutorialJava.capitulo4_Arrays.ejercicios.bloque01;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ejercicio04_EncuentraElementoEnArray {

	public static void main(String[] args) {
		int array[] = new int[5];
		int numBuscado;
		
		UtilsArrays.inicializaArray(array, 0, 100);
		
		UtilsArrays.imprimeArray(array);
		
		numBuscado = Utils.pideNumeroEntero("Número que deseas encontrar: ");
		
		for (int i = 0; i < array.length; i++) {
			if (numBuscado == array[i]) {
				System.out.println("Encontrado en posición " + i);
				return;
			}
		}
		System.out.println("El número no existe en el array");
	}

}







