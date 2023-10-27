package tutorialJava.examenes.examen_20231024;

import tutorialJava.Utils;

public class EjercicioA_SumaPrimosTantosComoIndiqueUsuario {

	public static void main(String[] args) {
		int numeroPrimosPedidos, primosEncontrados = 0, candidatoAPrimo = 2;
		boolean candidatoEsPrimo;
		int sumaPrimos = 0;
		
		numeroPrimosPedidos = Utils.pideNumeroEntero("¿Cuántos primos deseas sumar?: ");
		
		while (primosEncontrados < numeroPrimosPedidos) {
			// Voy a comprobar si un número es primo
			candidatoEsPrimo = true;
			for (int i = 2; i < candidatoAPrimo; i++) {
				if (candidatoAPrimo % i == 0) {
					candidatoEsPrimo = false;
					break;
				}
			}
			
			// Sobre la variable booleana puedo comprobar si se han encontrado, o no
			// divisores para el candidatoAPrimo
			if (candidatoEsPrimo == true) {
				System.out.print(candidatoAPrimo + " ");
				primosEncontrados++;
				sumaPrimos += candidatoAPrimo;
//				sumaPrimos = sumaPrimos + candidatoAPrimo; // Equivalente a línea superior
			}
			
			// Aumento el valor del candidato para probar el siguiente número
			candidatoAPrimo++;
		}
		
		// Imprimo la suma de los primos
		System.out.println("\nLa suma de los primos encontrados es: " + sumaPrimos);
	}

}




