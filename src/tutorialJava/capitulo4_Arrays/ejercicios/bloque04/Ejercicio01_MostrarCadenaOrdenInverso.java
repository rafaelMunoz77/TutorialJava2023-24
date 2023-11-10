package tutorialJava.capitulo4_Arrays.ejercicios.bloque04;

import java.util.Scanner;

public class Ejercicio01_MostrarCadenaOrdenInverso {

	public static void main(String[] args) {
		String s;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca cadena: ");
		s = sc.nextLine();

		muestraCadenaOrdenInverso(s);
	}
	
	
	
	public static void muestraCadenaOrdenInverso(String str) {
		for (int i = str.length() - 1; i > -1; i--) {
			System.out.print(str.charAt(i));
		}
	}

}
