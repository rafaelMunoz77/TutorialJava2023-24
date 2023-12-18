package tutorialJava.capitulo7_Recursos.ejemploInsultoRecibidoListener;

public class Jesus extends Object implements SobreFraseListener {

	/**
	 * 
	 */
	public Jesus () {
		PideFrasesAlUsuario.addSobreFraseListener(this);
	}
	
	
	@Override
	public void insultoRecibido(SobreFraseEvent e) {
		System.out.println("Soy Jesús y he recibido el insulto " + e.getInsultoRecibido());
	}

	@Override
	public void fraseVacia() {
		System.out.println("Soy Jesús y he sabido que la frase está vacía");
	}

	@Override
	public void fraseDemasiadoCorta(SobreFraseEvent e) {
		System.out.println("Soy Jesús y he recibido una frase corta: " + e.getFraseCompleta());
	}

}
