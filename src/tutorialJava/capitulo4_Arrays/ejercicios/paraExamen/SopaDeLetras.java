package tutorialJava.capitulo4_Arrays.ejercicios.paraExamen;

public class SopaDeLetras {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		char[][] matriz = {
                {'p', 'q', 'z', 'o', 'k'},
                {'x', 'e', 'P', 'u', 'a'},
                {'p', 'c', 'd', 'e', 'p'},
                {'g', 'h', 'i', 'e', 'P'},
                {'k', 'l', 'z', 'n', 'o'}
        };
					
		System.out.println("encontrada: " + encuentraPalabraEnMatriz(matriz, "paz"));
		
	}
	
	/**
	 * 
	 * @param m
	 * @param palabra
	 * @return
	 */
	public static boolean encuentraPalabraEnMatriz (char m[][], String palabra) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == palabra.charAt(0)) {
					if (compruebaFilaAdelante(m, i, j, palabra)) return true;
					if (compruebaFilaAtras(m, i, j, palabra)) return true;
					if (compruebaColumnaAbajo(m, i, j, palabra)) return true;
					if (compruebaColumnaArriba(m, i, j, palabra)) return true;
					if (compruebaDiagonalPrincipalAbajo(m, i, j, palabra)) return true;
					if (compruebaDiagonalPrincipalArriba(m, i, j, palabra)) return true;
					if (compruebaDiagonalSecundAbajo(m, i, j, palabra)) return true;
					if (compruebaDiagonalSecundArriba(m, i, j, palabra)) return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param m
	 * @param fila
	 * @param col
	 * @param p
	 * @return
	 */
	public static boolean compruebaFilaAdelante (char m[][], int fila, int col, String p) {
		String aux = "";
		for (int j = col; j < m.length; j++) {
			aux += m[fila][j];
			if (aux.equalsIgnoreCase(p)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param m
	 * @param fila
	 * @param col
	 * @param p
	 * @return
	 */
	public static boolean compruebaFilaAtras (char m[][], int fila, int col, String p) {
		String aux = "";
		for (int j = col; j > -1; j--) {
			aux += m[fila][j];
			if (aux.equalsIgnoreCase(p)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param m
	 * @param fila
	 * @param col
	 * @param p
	 * @return
	 */
	public static boolean compruebaColumnaAbajo (char m[][], int fila, int col, 
			String p) {
		
		String aux = "";
		for (int i = fila; i < m.length; i++) {
			aux += m[i][col];
			if (aux.equalsIgnoreCase(p)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param m
	 * @param fila
	 * @param col
	 * @param p
	 * @return
	 */
	public static boolean compruebaColumnaArriba (char m[][], int fila, int col, 
			String p) {
		
		String aux = "";
		for (int i = fila; i > -1; i--) {
			aux += m[i][col];
			if (aux.equalsIgnoreCase(p)) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * 
	 * @param m
	 * @param fila
	 * @param col
	 * @param p
	 * @return
	 */
	public static boolean compruebaDiagonalPrincipalAbajo (char m[][], int fila, 
			int col, String p) {
		
		String aux = "";
		for (int i = fila, j = col; i < m.length && j < m.length; i++, j++) {
			aux += m[i][j];
			if (aux.equalsIgnoreCase(p)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param m
	 * @param fila
	 * @param col
	 * @param p
	 * @return
	 */
	public static boolean compruebaDiagonalPrincipalArriba (char m[][], int fila, 
			int col, String p) {
		
		String aux = "";
		for (int i = fila, j = col; i > -1 && j > -1; i--, j--) {
			aux += m[i][j];
			if (aux.equalsIgnoreCase(p)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param m
	 * @param fila
	 * @param col
	 * @param p
	 * @return
	 */
	public static boolean compruebaDiagonalSecundAbajo (char m[][], int fila, 
			int col, String p) {
		
		String aux = "";
		for (int i = fila, j = col; i < m.length && j > -1; i++, j--) {
			aux += m[i][j];
			if (aux.equalsIgnoreCase(p)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param m
	 * @param fila
	 * @param col
	 * @param p
	 * @return
	 */
	public static boolean compruebaDiagonalSecundArriba (char m[][], int fila, 
			int col, String p) {
		
		String aux = "";
		for (int i = fila, j = col; i > -1 && j < m.length; i--, j++) {
			aux += m[i][j];
			if (aux.equalsIgnoreCase(p)) {
				return true;
			}
		}
		return false;
	}
	

}







