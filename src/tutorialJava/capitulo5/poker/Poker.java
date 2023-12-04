package tutorialJava.capitulo5.poker;

public class Poker {
	// Creo los jugadores y asigno manos a los mismos
	private Jugador jugadores[] = new Jugador[5];
	private String nombres[] = new String[] {"Dario", "José Luis", "Carmen", "José", "Alba"};
	private Baraja baraja = new Baraja();
	
	/**
	 * 
	 */
	public Poker () {
		baraja.mezclar();
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador();
			jugadores[i].setNombre(nombres[i]);
//			baraja.reparteManoAJugador(jugadores[i]);
			jugadores[i].obtenManoDeCartas(baraja);
		}
		System.out.println();
	}
}
