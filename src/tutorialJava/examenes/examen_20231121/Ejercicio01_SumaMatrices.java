package tutorialJava.examenes.examen_20231121;

import tutorialJava.UtilsArrays;

public class Ejercicio01_SumaMatrices {

	public static void main(String args[]) {
		int m1[][] = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int m2[][] = new int[][] {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
	
		System.out.println("Matriz 1:");
		UtilsArrays.imprimeMatriz(m1);
		System.out.println("Matriz 2:");
		UtilsArrays.imprimeMatriz(m2);
		
		int sumada[][] = sumaMatrices(m1, m2);
		System.out.println("Sumada:");
		UtilsArrays.imprimeMatriz(sumada);
		
	}
	
	/**
	 * 
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static int[][] sumaMatrices(int m1[][], int m2[][]) {
		int suma[][] = new int[m1.length][m1[0].length];
		
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[i].length; j++) {
				suma[i][j] = m1[i][j] + m2[i][j];
			}
		}
		
		return suma;
	}
	
}


















