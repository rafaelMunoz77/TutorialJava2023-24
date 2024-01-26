package tutorialJava.capitulo7_Recursos.ejemploPalabraRepetidaEnFraseListener;

public class PalabraRepetidaEvent {
	String palabra;

	public PalabraRepetidaEvent(String palabra) {
		super();
		this.palabra = palabra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
}
