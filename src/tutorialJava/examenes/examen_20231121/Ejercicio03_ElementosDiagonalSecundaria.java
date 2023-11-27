package tutorialJava.examenes.examen_20231121;

public class Ejercicio03_ElementosDiagonalSecundaria {

	public static void main(String[] args) {
		int m1[][] = new int[][] {	{1, 2, 3, 4}, 
									{4, 5, 6, 7}, 
									{7, 8, 9, 10},
									{4, 5, 6, 7}  };

		System.out.println("Suma vale: " + sumaDiagonalSecundaria(m1));						
	}

	public static int sumaDiagonalSecundaria (int m[][]) {
		int suma = 0;
		for (int i = 0, j = m.length - 1; i < m.length && j > -1; i++, j--) {
			suma += m[i][j];
		}
		return suma;
	}
}
















