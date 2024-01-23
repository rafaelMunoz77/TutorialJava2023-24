package tutorialJava.capitulo7_Recursos.ejemploNumeroImparListener;

public class Mesa implements NumeroImparListener {


	
	@Override
	public void numeroImparIntroducido(NumeroImparEvent e) {
		System.out.println("Soy una mesa y me han notificado que el usuario ha introducido "
				+ "un número impar: " + e.getNumeroIntroducido());
	}

}
