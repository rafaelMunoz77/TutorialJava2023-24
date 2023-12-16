package tutorialJava.examenes.examen_20231205_arrays_objetos.baloncesto;

import tutorialJava.Utils;

public class Jugador {
	private String nombre;
	private int canastas;
	private int probabilidadCanasta;
	private int fallos;
	
	public Jugador() {
		super();
		canastas = 0;
		fallos = 0;
		probabilidadCanasta = Utils.obtenerNumeroAzar(20, 100);
	}

	
	public void tiraACanasta () {
		int azar = Utils.obtenerNumeroAzar(0, 100);
		if (azar <= probabilidadCanasta) {
			canastas += 1;
		}
		else {
			fallos += 1;
		}
	}
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", canastas=" + canastas + ", probabilidadCanasta=" + probabilidadCanasta
				+ ", fallos=" + fallos + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCanastas() {
		return canastas;
	}

	public void setCanastas(int canastas) {
		this.canastas = canastas;
	}

	public int getProbabilidadCanasta() {
		return probabilidadCanasta;
	}

	public void setProbabilidadCanasta(int probabilidadCanasta) {
		this.probabilidadCanasta = probabilidadCanasta;
	}

	public int getFallos() {
		return fallos;
	}

	public void setFallos(int fallos) {
		this.fallos = fallos;
	}
}
