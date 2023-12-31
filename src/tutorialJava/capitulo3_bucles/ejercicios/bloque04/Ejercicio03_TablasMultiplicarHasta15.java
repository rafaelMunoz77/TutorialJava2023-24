package tutorialJava.capitulo3_bucles.ejercicios.bloque04;

public class Ejercicio03_TablasMultiplicarHasta15 {

	public static void main(String[] args) {
		// Declaro las variables
		int num = 1; // Número al que se le calculará su tabla de multiplicar
		int factor; // Factor por el que se multiplicará al número "num"
		
		// En lugar de bucles "for" usaré bucles while
		
		do {
			factor = 1;
			System.out.println("\nTabla de multiplicar del " + num);
			do {
				System.out.println("\t" + num + " x " + factor + " = " + (num * factor));
				factor++; // Aumento el factor
			} while (factor <= 10);
			
			num++; // Prepara para que se calcule la tabla de multiplicar del siguiente número;
		} while (num <= 15);
	}

}
