package tutorialJava.examenes.examen_20240130.ejercicio3;

public class Dummy implements EventoMeteorologicoListener {

	@Override
	public void comienzaALlover() {
		System.out.println("Soy Dummy y comienza a llover");
	}

	@Override
	public void terminaDeLlover() {
		System.out.println("Soy Dummy y termina de llover");
	}

}
