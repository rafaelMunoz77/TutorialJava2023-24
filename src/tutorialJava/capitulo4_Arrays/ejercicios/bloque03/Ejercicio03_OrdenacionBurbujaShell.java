package tutorialJava.capitulo4_Arrays.ejercicios.bloque03;

import tutorialJava.UtilsArrays;

public class Ejercicio03_OrdenacionBurbujaShell {

	public static void main(String[] args) {
//		int a[] = new int[] {33, 17, 72, 11, 35};
		int a[] = new int[1000];
		
		UtilsArrays.inicializaArray(a, 0, 100);
		UtilsArrays.imprimeArray(a);		

        // Define los intervalos iniciales
        for (int intervalo = a.length / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < a.length; i++) {
                int aux = a[i];
                int j;
                for (j = i; j >= intervalo && a[j - intervalo] > aux; j -= intervalo) {
                    a[j] = a[j - intervalo];
                }
                a[j] = aux;
            }
        }
		
		UtilsArrays.imprimeArray(a);

	}

}
