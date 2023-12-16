package tutorialJava.capitulo5.invasionTierraV2_Herencia;

import java.util.Scanner;

import tutorialJava.Utils;

public class Principal {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		CampoBatalla campo = new CampoBatalla();
		
		campo.mezclaHumanos();
		campo.mezclaMalvados();
		
		campo.muestraEstadoActual();
		
		do {
			// Disparar sobre el primera malvado. Necesito que haya
			// un humano vivo
			if (campo.getPrimerHumanoVivo() != null) {
				campo.getPrimerMalvadoVivo().recibirDisparo();
			}
			
			// Antes de disparar sobre un humano, debo comprobar que existe
			// al menos un malvado vivo
			if (campo.getPrimerMalvadoVivo() != null) {
				campo.getPrimerHumanoVivo().recibirDisparo();
			}
			
			campo.muestraEstadoActual();
			sc.nextLine();
			
		} while (campo.getPrimerHumanoVivo() != null &&
				campo.getPrimerMalvadoVivo() != null);
		
		// Muestro el ganador
		if (campo.getPrimerHumanoVivo() != null) {
			System.out.println("\nHan ganado los humanos");
		}
		else {
			if (campo.getPrimerMalvadoVivo() != null) {
				System.out.println("\nHan ganado los malvados");
			}
			else {
				System.out.println("\nEmpate");
			}
		}
	}
	
	
}










