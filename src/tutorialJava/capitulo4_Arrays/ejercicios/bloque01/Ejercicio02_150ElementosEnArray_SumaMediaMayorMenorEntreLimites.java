package tutorialJava.capitulo4_Arrays.ejercicios.bloque01;

import java.util.Scanner;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ejercicio02_150ElementosEnArray_SumaMediaMayorMenorEntreLimites {

	public static void main(String[] args) {
		int array[] = new int[5], suma = 0, mayor, menor;
		int limInf, limSup;
		float media;		
		
		limInf = Utils.pideNumeroEntero("Introduzca límite inferior: ");
		limSup = Utils.pideNumeroEntero("Introduzca límite superior: ");
		
		UtilsArrays.inicializaArray(array, limInf, limSup);
		
		UtilsArrays.imprimeArray(array);
		
	}

	
	
}













