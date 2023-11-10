package tutorialJava.capitulo4_Arrays.ejercicios.bloque07_tresEnRaya;

public class TresEnRaya {

	public static void main(String[] args) {
		int t[][] = new int[3][3];
		int turno = 1;

		inicializaTablero(t);
		
		do {
			// Muestro tablero
			
			// Pido jugada a jugador (turno)
			pidoJugadaAJugador(t, turno);
			
			
			// Cambiar turno
			turno = cambiaTurno(turno);
			
			System.out.println(turno);
		} while (ganadorDelJuego(t) == 0);
	}

	
	public static void inicializaTablero(int t[][]) {
		// Ponemos todos los valores a "0"
	}
	
	
	public static int ganadorDelJuego(int t[][]) {
		// Compruebo cada fila
		for (int i = 0; i < t.length; i++) {
			if (t[i][0] == t[i][1] && t[i][1] == t[i][2]) {
				return t[i][0];
			}
		}
		// Compruebo cada columna
		
		// Compruebo las diagonales
		
		// si llego hasta aquí, sé que el juego no se ha acabado.
		return 0;
	}
	
	
	public static void pidoJugadaAJugador (int t[][], int jugador) {
		
	}
	
	
	public static int cambiaTurno(int turno) {
		return (turno % 2) + 1;
	}
}










