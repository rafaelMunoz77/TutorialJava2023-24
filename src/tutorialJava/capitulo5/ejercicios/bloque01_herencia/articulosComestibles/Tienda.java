package tutorialJava.capitulo5.ejercicios.bloque01_herencia.articulosComestibles;

import java.util.Scanner;

import tutorialJava.Utils;

public class Tienda {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Articulo articulos[] = new Articulo[4];
		
		for (int i = 0; i < articulos.length; i++) {
			System.out.println("¿Qué tipo de artículo quieres "
					+ "(1.- Perecedero: 2.- No perecedero)?: ");
			int opcionUsuario = Integer.parseInt(sc.nextLine());
			
			switch (opcionUsuario) {
			case 1: // Perecedero
				Perecedero p = new Perecedero();
				p.pideDatosAlUsuario();
				articulos[i] = p;
				break;
			default: // No perecedero
			}
		}
	}

}
