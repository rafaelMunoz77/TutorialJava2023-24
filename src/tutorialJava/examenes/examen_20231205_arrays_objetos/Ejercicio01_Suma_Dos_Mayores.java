package tutorialJava.examenes.examen_20231205_arrays_objetos;

import tutorialJava.UtilsArrays;

public class Ejercicio01_Suma_Dos_Mayores {

	public static void main(String[] args) {
		int a[] = new int[10];
		
		UtilsArrays.inicializaArray(a, 0, 20);
		UtilsArrays.imprimeArray(a);
		
		sumaDeDosMayores(a);
	}
	
	
	private static void sumaDeDosMayores(int a[]) {
		UtilsArrays.ordenaArray(a);

		int mayor = a[a.length - 1];
		int segundoMayor = a[a.length - 2];
		System.out.println("La suma de los dos mayores se consigue con "
				+ mayor + " y " + segundoMayor + " y es de: " + 
				(mayor + segundoMayor));
	}
}








