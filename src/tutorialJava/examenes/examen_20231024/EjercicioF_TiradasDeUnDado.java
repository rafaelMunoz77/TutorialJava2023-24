package tutorialJava.examenes.examen_20231024;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class EjercicioF_TiradasDeUnDado {

	public static void main(String[] args) {
		int tiradas[] = new int[10];
		int valorBuscado, contadorOcurrencias = 0;
		
		UtilsArrays.inicializaArray(tiradas, 1, 6);
		UtilsArrays.imprimeArray(tiradas);
		
		do {
			valorBuscado = Utils.pideNumeroEntero("¿Qué valor deseas buscar?: ");
			
			if (valorBuscado < 1 || valorBuscado > 6) {
				System.out.println("Error. El valor debe estar entre 1 y 6");
			}
		} while (valorBuscado < 1 || valorBuscado > 6);

		for (int i = 0; i < tiradas.length; i++) {
			if (valorBuscado == tiradas[i]) {
				contadorOcurrencias++;
			}
		}
		System.out.println("El valor " + valorBuscado + " tiene " + contadorOcurrencias +
				" ocurrencias");
	}

}








