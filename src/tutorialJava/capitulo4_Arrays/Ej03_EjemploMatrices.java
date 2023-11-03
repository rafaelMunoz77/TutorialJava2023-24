package tutorialJava.capitulo4_Arrays;

import tutorialJava.Utils;

public class Ej03_EjemploMatrices {

	public static void main(String[] args) {
		int m[][] = new int[4][3];
		int m2[][] = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		
		int cont = 1;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
//				m[i][j] = (int) Math.round(Math.random() * 100);
				m[i][j] = cont;
				cont++;
			}
		}
		
		m[0][2] = 1;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
