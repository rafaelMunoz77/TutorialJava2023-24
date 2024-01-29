package tutorialJava.capitulo7_Recursos.palabraRepetidaException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
	

	/**
	 * @throws PalabraRepetidaException 
	 * 
	 */
	private static void pideFrases() throws PalabraRepetidaException {
		Scanner sc = new Scanner(System.in);
		String frase = "";
		
		
		do {
			System.out.println("Dame una frase: ");
			frase = sc.nextLine();
			String palabras[] = frase.split("[\s]+");
			List<String> listaPalabras = Arrays.asList(palabras);
			
			for (int i = 0; i < palabras.length; i++) {
				String palabra = palabras[i];
				if (listaPalabras.subList(0, i).contains(palabra)) {
					System.out.println("La palabra " + palabra + " está "
							+ "repetida");
					throw new PalabraRepetidaException("La palabra " + 
							palabra + " está repetida en la frase: " + 
							frase);
				}
			}
			
		} while (!frase.equals(""));

	}
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			pideFrases();
		} catch (PalabraRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}









