package tutorialJava.capitulo2_condicionales;

import java.util.Scanner;

public class Ejemplo00_PrimerCondicional {

	public static void main(String[] args) {
		int num;

		num = (int) Math.round(Math.random() * 100);
		
		System.out.println("El número al azar es: " + num);
				
		if (num < 0) {
			System.out.println("El número es negativo");
		}
		else { // Si entro en el else el número puede ser cero o positivo
			if (num == 0) {
				System.out.println("El número es neutro");
			}
			else {
				System.out.println("El número es positivo");
			}
		}
	}
}






