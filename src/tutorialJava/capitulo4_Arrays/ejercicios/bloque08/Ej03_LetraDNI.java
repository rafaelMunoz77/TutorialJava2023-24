package tutorialJava.capitulo4_Arrays.ejercicios.bloque08;

import java.util.Scanner;

public class Ej03_LetraDNI {

	public static void main(String[] args) {
		String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		Scanner sc = new Scanner(System.in);
		int valorDni = 0;
		
		boolean dniIntroducidoValido;
		do { 
			try {
				System.out.println("Introduzca su DNI sin letra: ");
				String dniSinLetra = sc.nextLine();				
				valorDni = Integer.parseInt(dniSinLetra);
				dniIntroducidoValido = true;
			}
			catch (Exception e) {
				System.err.println("DNI introducido no es válido");
				dniIntroducidoValido = false;
			}
		} while (!dniIntroducidoValido);
		
		System.out.println();
		
		char letraDni = letrasDNI.charAt(valorDni % 23);
		System.out.println("Letra DNI: " + letraDni);
	}

}
