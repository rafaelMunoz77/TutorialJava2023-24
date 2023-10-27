package tutorialJava.examenes.examen_20231024;

import tutorialJava.Utils;

public class EjercicioC_NesimoTerminoDeFibonacci {

	public static void main(String[] args) {
		int n = 0, n_1 = 1, n_2 = 1;
		int contTerminosPedidos;
		
		contTerminosPedidos = Utils.pideNumeroEntero("¿Qué término de la serie deseas?");

		switch (contTerminosPedidos) {
			case 1:
			case 2: 
				System.out.print("1 "); 
				break;
			default:
				for (int i = 3; i <= contTerminosPedidos ; i++) {
					n = n_1 + n_2;
					n_2 = n_1;
					n_1 = n;
				}
				System.out.print(n);
		}
		
	}

}
