package tutorialJava.examenes.examen_20231121;

import tutorialJava.UtilsArrays;

public class Ejercicio05_SubArraySumaMaxima {

	public static void main(String[] args) {
		int a[] = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};

		int m[] = subArraySumaMaxima4(a);
		UtilsArrays.imprimeArray(m);
	}

	
	public static int[] subArraySumaMaxima4(int a[]) {
		int mayor[] = new int[4];
		
		for (int i = 0; i < mayor.length; i++) {
			mayor[i] = Integer.MIN_VALUE;
		}
		
		for (int i = 0; i < a.length - 4; i++) {
			if ( (a[i] + a[i +1] + a[i + 2] + a[i + 3]) > 
			 (mayor[0] + mayor[1] + mayor[2] + mayor[3]) ) {
				 mayor[0] = a[i];
				 mayor[1] = a[i + 1];
				 mayor[2] = a[i + 2];
				 mayor[3] = a[i + 3];				 
			 }
		}
		
		return mayor;
	}
}










