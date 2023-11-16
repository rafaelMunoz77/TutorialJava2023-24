package tutorialJava.capitulo4_Arrays.ejercicios.bloque08;

import tutorialJava.Utils;
import tutorialJava.UtilsArrays;

public class Ej04_MinYMaxEnMatriz {

	public static void main(String[] args) {
		
		int m[][] = UtilsArrays.creaEInicializaMatriz(6, 10, -1);
				
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				// Genero un número al azar que no existe en la matriz
				int azar;
				do {
					azar = Utils.obtenerNumeroAzar(0, 1000);
				} while (existeValorEnMatriz(m, azar));

				// Aquí sé que el valor de 'azar' no se encuentra repetido
				m[i][j] = azar;
			}
		}
		
		UtilsArrays.imprimeMatriz(m);		
		
		// Obtengo min y max
		int min = m[0][0];
		int max = m[0][0];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] > max) max = m[i][j];
				if (m[i][j] < min) min = m[i][j];
			}
		}
		
		System.out.println("Máximo: " + max + " - Mínimo: " + min);
	}

	/**
	 * 
	 * @param m
	 * @param valorBuscado
	 * @return
	 */
	public static boolean existeValorEnMatriz (int m[][], int valorBuscado) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == valorBuscado) {
					return true;
				}
			}
		}
		return false;
	}
}









