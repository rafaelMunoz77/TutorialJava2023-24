package tutorialJava.examenes.examen_20231024;

import tutorialJava.Utils;

public class EjercicioE_CifrasEnUnNumero {

	public static void main(String[] args) {
		int azar = Utils.obtenerNumeroAzar(0, 10000);		
		
		int contCifras = 0;
		System.out.println(azar);

		if (azar == 0) {
			System.out.println("Tiene un dígito");
		}
		while (azar > 0) {
			contCifras++;
			azar/=10;
		}
		System.out.println("Tiene " + contCifras + " cifras");
	}

}
