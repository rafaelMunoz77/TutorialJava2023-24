package tutorialJava.capitulo1.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio05_PidoValorParaDosVariablesEIntercambioSusValores {

	public static void main(String[] args) {
		int num1, num2, aux;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca un número: ");
		num1 = sc.nextInt();
		System.out.println("El número es: " + num1);

		System.out.println("Introduzca otro número: ");
		num2 = sc.nextInt();
		System.out.println("El número es: " + num2);

		System.out.println("Num1: " + num1 + " - num2: " + num2);
		
		aux = num1;
		num1 = num2;
		num2 = aux;
		
		System.out.println("Num1: " + num1 + " - num2: " + num2);
		
	}

}
