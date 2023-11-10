package tutorialJava.capitulo4_Arrays.ejercicios.bloque06;

import java.util.Iterator;

import tutorialJava.Utils;

public class Ej01_EjerciciosMatrices {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int m[][] = new int[][] { 	{1, 	0, 		0, 		1, 		0}, 
									{0, 	2, 		0, 		1, 		0}, 
									{0,		0, 		3, 		1, 		0}, 
									{0, 	0,		0, 		4, 		0}, 
									{0, 	0, 		0, 		1, 		5} };
									
//		inicializaMatrizAlAzar(m);
		imprimeMatriz(m);
		System.out.println("Es positiva: " + esMatrizPositiva(m));
		System.out.println("Es diagonal: " + esMatrizDiagonal(m));
		System.out.println("Es dispersa: " + esMatrizDispersa(m));
		
		int t[][] = eliminaFila(m, 2);
		imprimeMatriz(t);
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
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public static boolean esMatrizDiagonal (int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if ( (i != j && m[i][j] != 0) // Si un elemento fuera de la diagonal es distinto de 0 
						||
					 (i == j && m[i][j] == 0) // Si un elemento en la diagonal es igual a 0
						) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public static boolean esMatrizTriangularSuperior (int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if ( i > j && m[i][j] != 0 ) {
					return false;
				}
			}
		}
		return true;
	}

	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public static boolean esMatrizDispersa (int m[][]) {
		// Con el primer for paso por todas las filas
		for (int i = 0; i < m.length; i++) {
			boolean hayCero = false;
			// Con el segundo for paso por todos los elementos de cada fila
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 0) {
					hayCero = true;
				}
			}
			// He terminado una fila, compruebo si había al menos un cero
			if (hayCero == false) {
				return false;
			}
		}
		
		
		// Con el primer for paso por todas las columnas
		for (int i = 0; i < m[0].length; i++) {
			boolean hayCero = false;
			// Con el segundo for paso por todos los elementos de cada columna
			for (int j = 0; j < m.length; j++) {
				if (m[j][i] == 0) {
					hayCero = true;
				}
			}
			// He terminado una fila, compruebo si había al menos un cero
			if (hayCero == false) {
				return false;
			}
		}
		
		// Si llego hasta aquí la matriz es dispersa
		return true;
	}
	
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public static int[] arrayFromMatriz (int m[][]) {
		// Comienzo calculando la dimensión, en elementos, de la matriz
		int dimensionArray = 0;
		for (int i = 0; i < m.length; i++) {
			dimensionArray += m[i].length;
		}
		
		int a[] = new int[dimensionArray];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				a[i * m[0].length + j] = m[i][j];
			}
		}
		return a;
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public static boolean esMatrizSimetrica (int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] != m[j][i] ) {
					return false;
				}
			}
		}
		return true;
	}

	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public static int[][] dameMatrizTraspuesta (int m[][]) {
		int t[][] = new int[m[0].length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				t[j][i] = m[i][j];
			}
		}
		return t;
	}

	

	/**
	 * 
	 * @param m
	 * @return
	 */
	public static void dameMatrizOpuesta (int m[][]) {
	for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = -m[i][j];
			}
		}
	}


	/**
	 * 
	 * @param m
	 * @return
	 */
	public static int[][] eliminaFila (int m[][], int filaAEliminar) {
		
		if (filaAEliminar >= m.length) {
			return m;
		}
		
		// Sólo llego aquí si no se ha entrado en el "if"
		int nueva[][] = new int[m.length - 1][m[0].length];
		int k = 0;
		for (int i = 0; i < m.length; i++) {
			if (filaAEliminar != i) {
				for (int j = 0; j < m[i].length; j++) {
					nueva[k][j] = m[i][j];
				}
				k++;
			}
		}
		return nueva;
	}


	
}

















