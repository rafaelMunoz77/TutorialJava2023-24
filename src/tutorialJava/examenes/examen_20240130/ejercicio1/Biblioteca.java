package tutorialJava.examenes.examen_20240130.ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import tutorialJava.Utils;

public class Biblioteca {
	private HashMap<String, Libro> hmDisponibles = new HashMap<String, Libro>();
	private List<Libro> listaPrestamos = new ArrayList<Libro>();

	
	public HashMap<String, Libro> getHmDisponibles() {
		return hmDisponibles;
	}

	public void setHmDisponibles(HashMap<String, Libro> hmDisponibles) {
		this.hmDisponibles = hmDisponibles;
	}
	
	
	public List<Libro> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(List<Libro> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Biblioteca b = new Biblioteca();
		int opcionUsu = 0;;
		
		b.getHmDisponibles().put("El código", new Libro("El código", "Paco"));
		b.getHmDisponibles().put("La escapada", new Libro("La escapada", "Paca"));
				
		do {
			opcionUsu = muestraMenu();
			
			switch (opcionUsu) {
			case 1:  // Préstamo de libro
				prestamo(b);
				break;
			case 2: // Devolución de libro
				devolucion(b);
			}
			
		} while (opcionUsu != 0);
		
	}
	
	/**
	 * 
	 * @return
	 */
	private static int muestraMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n0.- Salir\n1.- Prestar Libro\n2.- Devolver libro:");
		return Integer.parseInt(sc.nextLine());
	}
	
	
	/**
	 * 
	 * @param b
	 */
	private static void prestamo (Biblioteca b) {
		Iterator<String> titulos =  b.getHmDisponibles().keySet().iterator();
		while (titulos.hasNext()) {
			System.out.println("\tTítulo disponible " + titulos.next());
		}
		
		String pobibleTituloDelPrestamo = Utils.obtenerCadenaConDescripcion("¿Qué libro desea?");
		
		Libro l = b.getHmDisponibles().get(pobibleTituloDelPrestamo);
		if (l != null) {
			b.getListaPrestamos().add(l);
			b.getHmDisponibles().remove(pobibleTituloDelPrestamo);
		}
	}
	
	/**
	 * 
	 * @param b
	 */
	private static void devolucion (Biblioteca b) {
		for (Libro l : b.getListaPrestamos()) {
			System.out.println("\tTítulo prestado: " + l.getTitulo());
		}
		String titulo = Utils.obtenerCadenaConDescripcion("Dime el título que quieres devolver: ");
		Libro libroADevolver = null;
		for (Libro l : b.getListaPrestamos()) {
			if (titulo.equalsIgnoreCase(l.getTitulo())) {
				b.getHmDisponibles().put(l.getTitulo(), l);
				libroADevolver = l;
			}
		}
		
		if (libroADevolver != null) {
			b.listaPrestamos.remove(libroADevolver);
		}
	}
}













