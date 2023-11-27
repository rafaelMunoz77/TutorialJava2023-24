package tutorialJava.examenes.examen_20231121;

import tutorialJava.UtilsArrays;

public class Ejercicio02_CombinacionArraysCaracteres {

	public static void main(String[] args) {
		char a1[] = new char[] {'H', 'o', 'L', 'i'};
		char a2[] = new char[] {'R', 'A', 'F', 'a'};

		char comb[] = combinaArraysChar(a1, a2);
		UtilsArrays.imprimeArray(comb);
	}

	
	public static char[] combinaArraysChar (char a1[], char a2[]) {
		char combinado[] = new char[a1.length];
		
		for (int i = 0; i < a1.length; i++) {
			if (i % 2 == 0) {
				combinado[i] = a1[i];
			}
			else {
				combinado[i] = a2[i];
			}
		}
		
		for (int i = 0; i < combinado.length; i++) {
			if (combinado[i] >= 'A' && combinado[i] <= 'Z') {
				combinado[i] = (char) (((int) combinado[i]) + 32); 
			}
		}
		
		return combinado;
	}
}







