package tutorialJava.capitulo5.arkanoid;

import tutorialJava.Utils;

public class Ladrillo {

	public static String COLORES[] = new String[] {"rojo", "verde", "azul"}; 
	
	private String nombre;
	private String color;
	private int x;
	private int y, ancho, alto, puntosVida;
	
	public Ladrillo() {
		super();
		x = Utils.obtenerNumeroAzar(0, 800);
		y = Utils.obtenerNumeroAzar(0, 500);
		ancho = 100;
		alto = 50;
		puntosVida = Utils.obtenerNumeroAzar(1, 3);
		asignaColor();
	}

	private void asignaColor() {
		switch(puntosVida) {
		case 1:
			color = COLORES[Utils.obtenerNumeroAzar(0, COLORES.length - 1)];
			break;
		case 2: 
			color = "Plateado";
			break;
		default:
			color = "Dorado";
		}
	}
	
	public void quitoPuntoDeVida() {
		puntosVida -= 1;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String newColor) {
		color = newColor;
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

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return nombre + ":" + puntosVida;
	}
	
	
}











