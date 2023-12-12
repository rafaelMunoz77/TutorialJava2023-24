package tutorialJava.capitulo5.invasionTierraV2_Herencia;

import tutorialJava.Utils;

public class Humano extends Personaje {
	
	public Humano() {
		super();
		this.puntosVida += 50;
	}
	
	@Override
	public String toString() {
		return "Humano=" + super.toString();
	}
	
	
}
