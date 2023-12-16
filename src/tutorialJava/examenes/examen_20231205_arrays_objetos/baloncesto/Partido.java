package tutorialJava.examenes.examen_20231205_arrays_objetos.baloncesto;

import java.util.Arrays;

import tutorialJava.Utils;

public class Partido {
	private String nombres[] = new String[] 
			{"Eustaquio", "Rogelia", "Doroteo", "Dorotea", "Eustongo", 
					"Tiburcia", "Macario", "Macaria", "Romeo", "Julieta", };
	private Jugador locales[] = new Jugador[5];
	private Jugador visitantes[] = new Jugador[5];
	
	
	public Partido() {
		for (int i = 0; i < locales.length; i++) {
			locales[i] = new Jugador();
			locales[i].setNombre(nombres[i]);			
		}
		for (int i = 0; i < visitantes.length; i++) {
			visitantes[i] = new Jugador();
			visitantes[i].setNombre(nombres[i + 5]);
		}
	}

	/**
	 * 
	 */
	public void juega() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < locales.length; j++) {
				locales[j].tiraACanasta();
				visitantes[j].tiraACanasta();
			}
		}
	}

	/**
	 * 
	 */
	public void estadisticas() {
		// Creo un único array para fundir los dos arrrays de jugadores
		Jugador e[] = new Jugador[10];
		for (int i = 0; i < locales.length; i++) {
			e[i] = locales[i];
		}
		for (int i = 0; i < visitantes.length; i++) {
			e[i + 5] = visitantes[i];
		}
		
		// Ordeno por número de canastas
		ordenaArray(e);
		
		for (int i = 0; i < e.length; i++) {
			System.out.println(e[i]);
		}
	}
	
	/**
	 * 
	 * @param a
	 * @param asc
	 */
	public static void ordenaArray (Jugador a[]) {
		boolean hayIntercambios;
		do {
			hayIntercambios = false;
			for (int i = 0; i < (a.length - 1); i++) {
				if (a[i].getCanastas() < a[i + 1].getCanastas()) {
					Jugador aux = a[i];
					a[i] = a[i + 1];
					a[i + 1] = aux;
					hayIntercambios = true;
				}
			}
		} while (hayIntercambios == true);

	}

	
	@Override
	public String toString() {
		return "Partido [locales=" + Arrays.toString(locales) + ", visitantes=" + Arrays.toString(visitantes) + "]";
	}


	public String[] getNombres() {
		return nombres;
	}


	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}


	public Jugador[] getLocales() {
		return locales;
	}


	public void setLocales(Jugador[] locales) {
		this.locales = locales;
	}


	public Jugador[] getVisitantes() {
		return visitantes;
	}


	public void setVisitantes(Jugador[] visitantes) {
		this.visitantes = visitantes;
	}
	
	
}
