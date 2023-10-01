package tutorialJava.capitulo1.ejercicios.bloque01;

import java.util.Scanner;

public class Ejercicio06_CalculoCuotaMensualHipoteca {

	public static void main(String[] args) {
		int meses;
		float capital, euribor, diferencial, interesAnual, interesMensual;
		float calcIntermedio, cuotaMensual;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca los meses: ");
		meses = sc.nextInt();

		System.out.println("Introduzca el capital: ");
		capital = sc.nextFloat();

		System.out.println("Introduzca el euribor: ");
		euribor = sc.nextFloat();

		System.out.println("Introduzca el diferencial: ");
		diferencial = sc.nextFloat();

		interesAnual = euribor + diferencial;
		interesMensual = interesAnual / 12 / 100;
		calcIntermedio = (float) Math.pow(1 + interesMensual, meses);
		cuotaMensual = capital * (interesMensual * calcIntermedio) / 
				(calcIntermedio - 1);
		
		System.out.println("Cuota mensual: " + cuotaMensual + " €");		
	}

}





