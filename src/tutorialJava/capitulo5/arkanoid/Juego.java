package tutorialJava.capitulo5.arkanoid;

import tutorialJava.Utils;

public class Juego {
	private Ladrillo ladrillos[] = new Ladrillo[20];
	private Pelota pelota = new Pelota();
	
	public Juego() {
		for (int i = 0; i < ladrillos.length; i++) {
			ladrillos[i] = new Ladrillo();
		}
	}

	/**
	 * 
	 */
	public void jugar() {
		
		do {
			pelota.setX(Utils.obtenerNumeroAzar(0, 800));
			pelota.setY(Utils.obtenerNumeroAzar(0, 500));
			
			for (int i = 0; i < ladrillos.length; i++) {
				if (ladrillos[i] != null) {
					if (pelota.chocaConLadrillo(ladrillos[i])) {
						System.out.println("Hay un choque");
						ladrillos[i].quitoPuntoDeVida();
						if (ladrillos[i].getPuntosVida() < 1) {
							ladrillos[i] = null;
						}
					}
				}
			}
		} while (true);
	}
	
	public Ladrillo[] getLadrillos() {
		return ladrillos;
	}
	public void setLadrillos(Ladrillo[] ladrillos) {
		this.ladrillos = ladrillos;
	}
	public Pelota getPelota() {
		return pelota;
	}
	public void setPelota(Pelota pelota) {
		this.pelota = pelota;
	}
}
