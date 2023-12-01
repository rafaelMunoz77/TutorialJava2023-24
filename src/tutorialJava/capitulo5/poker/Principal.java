package tutorialJava.capitulo5.poker;

public class Principal {

	public static void main (String args[]) {
		Baraja baraja = new Baraja();
		
		baraja.pasaCartaDeAbajoHaciaArriba();
		baraja.pasaCartaDeArribaHaciaAbajo();
		
		baraja.mezclar();
		
		System.out.println();
	}
}
