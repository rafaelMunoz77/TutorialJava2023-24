package tutorialJava.capitulo7_Recursos.ejemploEntraPersonaListener;

public class PersonaEntraEvent {
	private String nombrePer;

	
	
	public PersonaEntraEvent(String nombrePer) {
		super();
		this.nombrePer = nombrePer;
	}

	public String getNombrePer() {
		return nombrePer;
	}

	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}
	
	
}
