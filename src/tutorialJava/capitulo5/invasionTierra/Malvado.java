package tutorialJava.capitulo5.invasionTierra;

import tutorialJava.Utils;

public class Malvado {
	private String nombre;
	private int puntosVida;
	private boolean vivo;
	
	public Malvado() {
		puntosVida = Utils.obtenerNumeroAzar(50, 100);
		vivo = true;
	}
	
	public void recibirDisparo() {
		puntosVida -= Utils.obtenerNumeroAzar(5, 25);
		if (puntosVida <= 0) {
			vivo = false;
			puntosVida = 0;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String newNombre) {
		nombre = newNombre;
	}
	
	public int getPuntosVida () {
		return puntosVida;
	}
	
	public void setPuntosVida(int newPuntosVida ) {
		puntosVida = newPuntosVida;
	}
	
	public boolean isVivo() {
		return vivo;
	}
	
	public void setVivo(boolean newVivo) {
		vivo = newVivo;
	}
	
	public String toString() {
		return nombre + ":" + puntosVida + ":" + vivo;
	}
}
