package tutorialJava.capitulo1.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio02_PidoTresNumerosYMuestroAContinuacion {

	public static void main(String[] args) {
		int num1;
		float num2;
		double num3;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca un número: ");
		num1 = sc.nextInt();
		System.out.println("El número es: " + num1);

		System.out.println("Introduzca otro número: ");
		num2 = sc.nextFloat();
		System.out.println("El número es: " + num2);

		System.out.println("Introduzca otro número: ");
		num3 = sc.nextDouble();
		System.out.println("El número es: " + num3);
		
	}

}
