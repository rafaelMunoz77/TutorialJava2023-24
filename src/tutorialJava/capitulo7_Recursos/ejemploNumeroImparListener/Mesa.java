package tutorialJava.capitulo7_Recursos.ejemploNumeroImparListener;

public class Mesa implements NumeroImparListener {

	/**
	 * 
	 */
	public Mesa() {
		IntroduccionNumeros.addNumeroImparListener(this);
	}
	
	@Override
	public void numeroImparIntroducido(NumeroImparEvent e) {
		System.out.println("Soy una mesa y me han notificado que el usuario ha introducido "
				+ "un número impar: " + e.getNumeroIntroducido());
	}

}
