package tutorialJava.capitulo2_condicionales;

import java.util.Scanner;

public class Ejemplo00_PrimerCondicional {

	public static void unMetodo() {
		int num;

		num = (int) Math.round(Math.random() * 100);
		
		System.out.println("El número al azar es: " + num);
				
		if (num >= 0 && num <= 25) {
			System.out.println("El número está entre 0 y 25");
		}
		else {
			if (num > 25 && num <= 50) {
				System.out.println("El número está entre 26 y 50");
			}
			else {
				System.out.println("El número es mayor de 50");
			}
		}
	}
	
	public static void main(String[] args) {
		unMetodo();
	}
}













