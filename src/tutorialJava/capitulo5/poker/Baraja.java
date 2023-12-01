package tutorialJava.capitulo5.poker;

import tutorialJava.Utils;

public class Baraja {

	private Carta baraja[] = new Carta[52];
	
	public Baraja () {
		for (int i = 0; i < 13; i++) {
			baraja[i] = new Carta();
			baraja[i].setValor(i + 1);
			baraja[i].setPalo("Picas");
		}
		for (int i = 0; i < 13; i++) {
			baraja[i + 13] = new Carta();
			baraja[i + 13].setValor(i + 1);
			baraja[i + 13].setPalo("Diamantes");
		}
		for (int i = 0; i < 13; i++) {
			baraja[i + 26] = new Carta();
			baraja[i + 26].setValor(i + 1);
			baraja[i + 26].setPalo("Tréboles");
		}
		for (int i = 0; i < 13; i++) {
			baraja[i + 39] = new Carta();
			baraja[i + 39].setValor(i + 1);
			baraja[i + 39].setPalo("Corazones");
		}
	}

	
	public void pasaCartaDeAbajoHaciaArriba() {
		Carta aux = baraja[baraja.length - 1];
		for (int i = (baraja.length - 1); i > 0; i--) {
			baraja[i] = baraja[i - 1];
		}
		baraja[0] = aux;
	}
	
	public void pasaCartaDeArribaHaciaAbajo() {
		Carta aux = baraja[0];
		for (int i = 0; i < (baraja.length - 1); i++) {
			baraja[i] = baraja[i + 1];
		}
		baraja[baraja.length - 1] = aux;
	}
	
	public void mezclar() {
		for (int i = 0; i < baraja.length; i++) {
			int indice1 = Utils.obtenerNumeroAzar(0, baraja.length - 1);
			int indice2 = Utils.obtenerNumeroAzar(0, baraja.length - 1);
			
			Carta aux = baraja[indice1];
			baraja[indice1] = baraja[indice2];
			baraja[indice2] = aux;
		}
	}
	
	public Carta[] getBaraja() {
		return baraja;
	}
	public void setBaraja(Carta[] baraja) {
		this.baraja = baraja;
	}
}
















