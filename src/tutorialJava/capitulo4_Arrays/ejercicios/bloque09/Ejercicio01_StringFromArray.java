package tutorialJava.capitulo4_Arrays.ejercicios.bloque09;

public class Ejercicio01_StringFromArray {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[] {97, 98, 99, 100};

		System.out.println("String devuelto: " + stringFromArray(a));
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	public static String stringFromArray (int b[]) {
		StringBuffer sb = new StringBuffer();
		
		for (int num : b) {
			sb.append((char) num);
		}
		
//		for (int i = 0; i < b.length; i++) {
//			sb.append((char) b[i]);
//		}
		return sb.toString();
	}

}
