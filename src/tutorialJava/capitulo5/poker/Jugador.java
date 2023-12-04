package tutorialJava.capitulo5.poker;

import java.util.Arrays;

public class Jugador {
	private String nombre;
	private Carta mano[];
	
	public Jugador () {
		mano = new Carta[5];
	}

	public void obtenManoDeCartas(Baraja baraja) {
		
	}
	
	public String toString() {
		return "Jugador [nombre=" + nombre + ", mano=" + Arrays.toString(mano) + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carta[] getMano() {
		return mano;
	}

	public void setMano(Carta[] mano) {
		this.mano = mano;
	}
	
	
}
