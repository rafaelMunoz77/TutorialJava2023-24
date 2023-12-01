package tutorialJava.capitulo5.arkanoid;

import tutorialJava.Utils;

public class Pelota {
	private int x;
	private int y;
	
	public Pelota() {
		super();
	}
	
	/**
	 * 
	 * @param l
	 * @return
	 */
	public boolean chocaConLadrillo(Ladrillo l) {
		if (x >= l.getX() && x <= (l.getX() + l.getAncho()) &&
				y >= l.getY() && y <= (l.getY() + l.getAlto())) {			
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public void mueveAlAzar() {
		x= Utils.obtenerNumeroAzar(0, 800);
		y = Utils.obtenerNumeroAzar(0, 500);
	}
	
	/////// GETTERS Y SETTER
	
	public String toString() {
		return "Pelota [x=" + x + ", y=" + y + "]";
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
