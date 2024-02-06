package tutorialJava.capitulo7_Recursos.ejemploEntraPersonaListener;

public class Madre implements PersonaEntraListener {

	public Madre() {
		Principal.addPersonaEntraListener(this);
	}
	
	@Override
	public void entraPersona(PersonaEntraEvent e) {
		System.out.println("Soy una madre y ha entrado " + e.getNombrePer());
	}

}
