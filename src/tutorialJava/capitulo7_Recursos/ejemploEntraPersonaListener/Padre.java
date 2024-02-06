package tutorialJava.capitulo7_Recursos.ejemploEntraPersonaListener;

public class Padre implements PersonaEntraListener {

	public Padre() {
		Principal.addPersonaEntraListener(this);
	}
	
	@Override
	public void entraPersona(PersonaEntraEvent e) {
		System.out.println("Soy un padre y ha entrado " + e.getNombrePer());
	}

}
