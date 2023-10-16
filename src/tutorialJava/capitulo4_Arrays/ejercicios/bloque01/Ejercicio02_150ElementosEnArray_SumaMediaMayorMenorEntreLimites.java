package tutorialJava.capitulo4_Arrays.ejercicios.bloque01;

import java.util.Scanner;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ejercicio02_150ElementosEnArray_SumaMediaMayorMenorEntreLimites {

	public static void main(String[] args) {
		int array[] = new int[5], suma = 0, mayor, menor;
		int limInf, limSup;
		float media;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el límite inferior: ");
		limInf = sc.nextInt();
		System.out.println("Introduce el límite Superior: ");
		limSup = sc.nextInt();
		
		UtilsArrays.inicializaArray(array, limInf, limSup);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		// Calculo la suma
		menor = array[0];
		mayor = array[0];
		for (int i = 0; i < array.length; i++) {
			suma += array[i];
			if (array[i] > mayor) mayor = array[i];
			if (array[i] < menor) menor = array[i];
		}
		
		media = suma / (float) array.length;
		
		// Imprimo resultados
		System.out.println("Suma: " + suma + " - Media: " + media + 
				" - Menor: " + menor + " - Mayor: " + mayor);
		
	}

}













