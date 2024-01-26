package tutorialJava.capitulo7_Recursos.ejemploPalabraRepetidaEnFraseListener;

public class Informatica  implements PalabraRepetidaListener {

	String nombre;

	public Informatica(String nombre) {
		super();
		this.nombre = nombre;
		Principal.addPalabraRepetidaListener(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void palabraRepetidaEncontrada(PalabraRepetidaEvent e) {
		System.out.println("Soy " + this.nombre + " y hay una palabra "
				+ "repetida: " + e.getPalabra());		
	}
	
	
}




