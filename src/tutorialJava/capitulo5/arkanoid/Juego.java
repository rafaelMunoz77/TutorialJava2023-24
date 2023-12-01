package tutorialJava.capitulo5.arkanoid;

import java.util.Iterator;

import tutorialJava.Utils;

public class Juego {
	private Ladrillo ladrillos[] = new Ladrillo[20];
	private Pelota pelota = new Pelota();
	private Ladrillo ladrillosDestruidos[] = new Ladrillo[20];
	private int contadorLadrillosDestruidos = 0;
	
	public Juego() {
		for (int i = 0; i < ladrillos.length; i++) {
			ladrillos[i] = new Ladrillo();
			ladrillos[i].setNombre("L" + i);
		}
	}

	/**
	 * 
	 */
	public void jugar() {
		
		do {
			pelota.mueveAlAzar();
			boolean colisionConLadrillos = false;
			for (Ladrillo l : ladrillos) {
				if (l.getPuntosVida() > 0) {
					if (pelota.chocaConLadrillo(l)) {
						l.quitoPuntoDeVida();
						colisionConLadrillos = true;
						agregaLadrilloADestruidosSiCorresponde(l);
					}
				}	
			}	
			if (colisionConLadrillos == true) {
				muestraArrayLadrillos();
			}
		} while (quedanLadrillos());
		// Estadísticas
		System.out.println("Primero en ser destruido: " + ladrillosDestruidos[0].toString());
		System.out.println("Último en ser destruido: " + 
				ladrillosDestruidos[ladrillosDestruidos.length - 1].toString());		
		
		System.out.println("Orden de destrucción de los ladrillos");
		muestraArrayLadrillosDestruidos();
	}
	
	
	private void agregaLadrilloADestruidosSiCorresponde(Ladrillo l) {
		if (l.getPuntosVida() <= 0) {
			ladrillosDestruidos[contadorLadrillosDestruidos] = l;
			contadorLadrillosDestruidos++;
		}
	}
	
	
	private void muestraArrayLadrillosDestruidos() {
		for (Ladrillo l : ladrillosDestruidos) {
			System.out.print(l.toString() + "-");
		}
		System.out.println();
	}
	
	
	private void muestraArrayLadrillos() {
		for (Ladrillo l : ladrillos) {
			if (l.getPuntosVida() > 0) {
				System.out.print(l.toString() + "-");
			}
		}
		System.out.println();
	}
	
	
	private boolean quedanLadrillos() {
		for (Ladrillo l : ladrillos) {
			if (l.getPuntosVida() > 0) {
				return true;
			}
		}
		return false;
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
