package tutorialJava.examenes.examen_20231205_arrays_objetos;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ejercicio02_SumaDeSubmatrizRectangular {

	public static void main(String[] args) {
		int m[][] = UtilsArrays.creaEInicializaMatrizAlAzar(5, 5, 0, 100);
		
		UtilsArrays.imprimeMatriz(m);
		
		int x1 = Utils.obtenerEnteroConDescripcion(
				"Coordenada x esquina superior izquierda: ");
		int y1 = Utils.obtenerEnteroConDescripcion(
				"Coordenada y esquina superior izquierda: ");
		int x2 = Utils.obtenerEnteroConDescripcion(
				"Coordenada x esquina inferior derecha: ");
		int y2 = Utils.obtenerEnteroConDescripcion(
				"Coordenada y esquina inferior derecha: ");
		
		int suma = 0;
		for (int i = y1; i <= y2; i++) {
			for (int j = x1; j <= x2; j++) {
				suma += m[i][j];
			}
		}
		
		System.out.println("Suma de la submatriz: " + suma);
	}

}









