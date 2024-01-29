package tutorialJava.examenes.examen_cap_7_antiguo_20230209;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		int rojo =  pideNumeroEntero("Dame una cantidad de rojo: ", 0, 255);
		int verde =  pideNumeroEntero("Dame una cantidad de verde: ", 0, 255);
		int azul =  pideNumeroEntero("Dame una cantidad de azul: ", 0, 255);

		String rgb = "#" + Integer.toHexString(rojo) + Integer.toHexString(verde) +
				Integer.toHexString(azul);
		
		System.out.println("RGB: " + rgb);
	}

	
	
	
	/**
	 * Pide un número entero al usuario
	 * @param mensaje String que va a mostrarse en consola para pedir el número
	 * @return Número entero introducido por el usuario
	 */
	public static int pideNumeroEntero (String mensaje, int min, int max) {
		int n = 0;
		boolean esNumeroCorrecto;
		Scanner sc = new Scanner(System.in);
		
		do {
			esNumeroCorrecto = false;
			try {
				System.out.println(mensaje);
				n = Integer.parseInt(sc.nextLine());
				if (n >= min && n <= max) {
					esNumeroCorrecto = true;
				}
			}
			catch (Exception e) {
			}
			if (!esNumeroCorrecto) {
				System.out.println("No ha introducido un número entre el mín: " +
						min + " y el max: " + max);
			}
			
		} while (!esNumeroCorrecto);
		
		return n;
	}

}
