package tutorialJava.capitulo6_ColeccionesDeDatos.ejercicios.bloque02_Hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Principal {

	
	private static HashMap<Integer, Articulo> hm = new HashMap<Integer, Articulo> ();
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		Articulo art = null;		
		
		do {
			opcion = menu(); // Muestro menú y recojo selección del usuario
			
			// Trato la opción elegida
			switch (opcion) {
			case 0:
				System.exit(0);
				break;
				
			case 1: // Ver artículos
				mostrarArticulos();
				break;
				
			case 2: // Insertar artículo
				insertarArticulo();
				break;
		
			case 3: // Eliminar artículo
				System.out.println("Introduzca el codigo de barras deel artículo a eliminar: ");
				int codigoAEliminar = sc.nextInt();
				hm.remove(codigoAEliminar);	
				break;
		
			case 4: // Modificar artículo
				modificarArticulo();
				break;
			}

		} while (true);
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Elige lo que desea hacer:");
		System.out.println("0.-Salir");
		System.out.println("1.-Ver los objeatos del almecen");
		System.out.println("2.-Insertar nuevo artículo");
		System.out.println("3.-Eliminar un articulo");
		System.out.println("4.-Actualizar un articulo");
		return sc.nextInt();
		
	}

	/**
	 * 
	 */
	private static void mostrarArticulos() {
		Object claves[] = hm.keySet().toArray();
		for (int i = 0; i < claves.length; i++) {
			System.out.println("Codigo de barras: " + claves[i] + 
					"\nDatos del  " + hm.get(claves[i]));
		}
	}
	
	
	/**
	 * 
	 */
	private static void insertarArticulo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca codigo de barras: ");
		int cB = sc.nextInt();
		System.out.println("Introduzca nombre: ");
		String nombre = sc.next();
		System.out.println("Introduzca número de estanteria: ");
		int estanteria = sc.nextInt();
		System.out.println("Introduzca stock: ");
		int cantidad = sc.nextInt();
		
		hm.put(cB, new Articulo(nombre, cB, estanteria, cantidad));

	}
	
	/**
	 * 
	 */
	private static void modificarArticulo() {
		Scanner sc = new Scanner(System.in);
		Articulo art = new Articulo();
		System.out.println("Introzuca codigo de barras: ");
		art.setCodigoDeBarras(sc.nextInt());
		System.out.println("Introduzca nombre: ");
		art.setNombre(sc.next());
		System.out.println("Introduzca número de estanteria: ");
		art.setNumeroDeEstante(sc.nextInt());
		System.out.println("Introduzca stock: ");
		art.setStock(sc.nextInt());
		 
		hm.replace(art.getCodigoDeBarras(), art);
	}
}
