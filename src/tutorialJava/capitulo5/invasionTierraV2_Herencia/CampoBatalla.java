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
	public void mezclaPersonajes(Personaje personajes[]) {
		for (int i = 0; i < personajes.length; i++) {
			int indiceAlAzar1 = Utils.obtenerNumeroAzar(0, personajes.length - 1);
			int indiceAlAzar2 = Utils.obtenerNumeroAzar(0, personajes.length - 1);
			
			Personaje aux = personajes[indiceAlAzar1];
			personajes[indiceAlAzar1] = personajes[indiceAlAzar2];
			personajes[indiceAlAzar2] = aux;
		}
	}
		
	/**
	 * 
	 */
	public void mezclaHumanos() {
		mezclaPersonajes(humanos);
	}
	
	/**
	 * 
	 */
	public void mezclaMalvados() {
		mezclaPersonajes(malvados);
	}
	
	/**
	 * 
	 * @return
	 */
	public Humano getPrimerHumanoVivo() {
		for (int i = 0; i < humanos.length; i++) {
			if (humanos[i].isVivo() == true) {
				return (Humano) humanos[i];
			}
		}
		return null;
	}


	public Malvado getPrimerMalvadoVivo() {
		for (int i = 0; i < malvados.length; i++) {
			if (malvados[i].isVivo() == true) {
				return (Malvado) malvados[i];
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















