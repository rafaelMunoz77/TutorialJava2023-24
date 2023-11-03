package tutorialJava.capitulo4_Arrays;

import java.util.Iterator;

import tutorialJava.Utils;

public class Ej04_ComoHacerEjerciciosMatrices {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int m[][] = new int[][] { 	{1, 	2, 		3, 		4, 		0}, 
									{5, 	6, 		0, 		8, 		9}, 
									{10,	0, 		12, 	13, 	14}, 
									{0, 	16,		17, 	18, 	19}, 
									{20, 	21, 	22, 	0, 		24} };
									
//		inicializaMatrizAlAzar(m);
		imprimeMatriz(m);
		System.out.println("Es positiva: " + esMatrizPositiva(m));
	}
	

	/**
	 * 
	 * @param m
	 */
	public static void inicializaMatrizAlAzar(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = (int) Math.round(Math.random() * 100);
			}
		}
	}
	
	/**
	 * 
	 * @param m
	 */
	public static void imprimeMatriz(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public static boolean esMatrizPositiva(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] < 0) {
					return false;
				}
			}
		}
		return true;
	}
}

















