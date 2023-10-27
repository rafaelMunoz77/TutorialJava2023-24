package tutorialJava.examenes.examen_20231024;

import java.util.Iterator;

import tutorialJava.Utils;

public class EjercicioB_NumerosPerfectos {

	public static void main(String[] args) {
		int posibleNumeroPerfecto, sumaDivisores = 0;
		
		posibleNumeroPerfecto = Utils.pideNumeroEntero("Introduce número: ");
		
		// Recorro todos los valores entre 1 y el anterior al candidato a perfecto
		for (int i = 1; i < posibleNumeroPerfecto; i++) {
			if (posibleNumeroPerfecto % i == 0) {
				// He encontrado un divisor y lo debo sumar
				sumaDivisores += i;
			}
		}

		// Compruebo si la suma de los divisores es igual al número
		if (sumaDivisores == posibleNumeroPerfecto) {
			System.out.println("El número es perfecto");
		}
		else {
			System.out.println("El número NO es perfecto");
		}
	}

}







