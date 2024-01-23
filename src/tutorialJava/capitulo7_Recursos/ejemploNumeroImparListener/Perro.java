package tutorialJava.capitulo7_Recursos.ejemploNumeroImparListener;

public class Perro implements NumeroImparListener {

	
	
	@Override
	public void numeroImparIntroducido(NumeroImparEvent e) {
		System.out.println("Soy un perro y me han notificado la introducción de un número "
				+ "impar: " + e.getNumeroIntroducido());
		IntroduccionNumeros.removeNumeroImparListener(this);
	}

}
