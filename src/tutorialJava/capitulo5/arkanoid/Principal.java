package tutorialJava.capitulo5.arkanoid;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String respuestaUsuario;
		
		do {
			System.out.println("\n\n Juego del ARKANOID\n");
			Juego juego = new Juego();
			juego.jugar();

			System.out.println("¿Quieres volver a jugar? (S -> Sí  N -> No): ");
			respuestaUsuario = sc.nextLine();
		} while (respuestaUsuario.equalsIgnoreCase("s"));
	}

}
