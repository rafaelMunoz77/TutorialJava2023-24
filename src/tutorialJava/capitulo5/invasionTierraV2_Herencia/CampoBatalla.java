package tutorialJava.capitulo5.invasionTierraV2_Herencia;

import tutorialJava.Utils;

public class CampoBatalla {
	private String nombre;
	
	private Personaje[] humanos = new Humano[20];
	private Personaje[] malvados = new Malvado[20];

	/**
	 * 
	 */
	public CampoBatalla() {
//		Inicializo el array de humanos, al ultimo humano le duplico el valor de puntos de vida
		inicializaArrayPersonajes(humanos, "humano");
		
//		Inicializo el array de Malvados
		inicializaArrayPersonajes(malvados, "malvado");
	}
	
	
	private void inicializaArrayPersonajes(Personaje[] p, String descripcion) {
		for (int i = 0; i < p.length; i++) {
			if (descripcion.equalsIgnoreCase("humano")) {
				p[i] = new Humano();
			}
			else {
				p[i] = new Malvado();
			}
			p[i].setNombre(descripcion + i);
		}
		Personaje ultimoP = p[p.length - 1];
		ultimoP.setPuntosVida(ultimoP.getPuntosVida() * 2);
	}
	
	/**
	 * 
	 */
	public void mezclaHumanos() {
		for (int i = 0; i < humanos.length; i++) {
			int indiceAlAzar1 = Utils.obtenerNumeroAzar(0, humanos.length - 1);
			int indiceAlAzar2 = Utils.obtenerNumeroAzar(0, humanos.length - 1);
			
			Humano aux = humanos[indiceAlAzar1];
			humanos[indiceAlAzar1] = humanos[indiceAlAzar2];
			humanos[indiceAlAzar2] = aux;
		}
	}
	
	/**
	 * 
	 */
	public void mezclaMalvados() {
		for (int i = 0; i < malvados.length; i++) {
			int indiceAlAzar1 = Utils.obtenerNumeroAzar(0, malvados.length - 1);
			int indiceAlAzar2 = Utils.obtenerNumeroAzar(0, malvados.length - 1);
			
			Malvado aux = malvados[indiceAlAzar1];
			malvados[indiceAlAzar1] = malvados[indiceAlAzar2];
			malvados[indiceAlAzar2] = aux;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Humano getPrimerHumanoVivo() {
		for (int i = 0; i < humanos.length; i++) {
			if (humanos[i].isVivo() == true) {
				return humanos[i];
			}
		}
		return null;
	}


	public Malvado getPrimerMalvadoVivo() {
		for (int i = 0; i < malvados.length; i++) {
			if (malvados[i].isVivo() == true) {
				return malvados[i];
			}
		}
		return null;
	}


	public void muestraEstadoActual() {
		for (int i = 0; i < humanos.length; i++) {
			System.out.print(humanos[i] + " - ");
		}
		System.out.println();
		for (int i = 0; i < malvados.length; i++) {
			System.out.print(malvados[i] + " - ");
		}
		System.out.println("\n");
	}

}















