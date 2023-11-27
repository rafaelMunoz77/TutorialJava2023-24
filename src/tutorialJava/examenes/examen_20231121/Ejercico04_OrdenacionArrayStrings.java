package tutorialJava.examenes.examen_20231121;

import tutorialJava.UtilsArrays;

public class Ejercico04_OrdenacionArrayStrings {

	public static void main(String[] args) {
		String a[] = new String[] {"pera", "manzana", "uva", "naranja", "kiwi"};

		ordenaBurbuja(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	
	public static void ordenaBurbuja (String a[]) {
		boolean hayIntercambios = false;
		
		do {
			hayIntercambios = false;
			for (int i = 0; i < (a.length - 1); i++) {
				if (comparaCadenas(a[i], a[i + 1]) == 1) {
					String aux = a[i];
					a[i] = a[i + 1];
					a[i + 1] = aux;
					hayIntercambios = true;
				}
			}
		} while (hayIntercambios == true);

	}
	
	
	
	
	public static int comparaCadenas(String s1, String s2) {
		
		int menorLongitud = (s1.length() < s2.length())? s1.length() : s2.length();
		
		for (int i = 0; i < menorLongitud; i++) {
			if (s1.charAt(i) < s2.charAt(i)) return -1;
			else if (s1.charAt(i) > s2.charAt(i)) return 1;
		}			
		
		if (s1.length() == s2.length()) return 0;
		return (s1.length() < s2.length())? -1 : 1;		
	}


}






