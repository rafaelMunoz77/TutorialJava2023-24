package tutorialJava.examenes.examen_cap_7_antiguo_20230209;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		String frase = "Rafa1$  Darío9%      \n      alejandro Jose74#";

//		Scanner sc = new Scanner(System.in);
//		System.out.println("Dame una frase: ");
//		String frase = sc.nextLine();
		
		String[] palabras = frase.split("[\\s]+");
		
		for (String p : palabras) {
			int mayus = 0, minus = 0, digit = 0, noAlfaNum = 0;
			
			for (int i = 0; i < p.length(); i++) {
				if (Character.isLowerCase(p.charAt(i))) 		minus++;
				if (Character.isUpperCase(p.charAt(i))) 		mayus++;
				if (Character.isDigit(p.charAt(i))) 			digit++;
				if (!Character.isLetterOrDigit(p.charAt(i))) 	noAlfaNum++;
			}
			
			if (minus > 1 && mayus > 0 && digit > 0 && noAlfaNum > 0) {
				System.out.println(p);
			}
		}

	}

}
