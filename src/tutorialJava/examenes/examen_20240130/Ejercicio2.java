package tutorialJava.examenes.examen_20240130;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import tutorialJava.Utils;

public class Ejercicio2 {

	public static void main(String[] args) {
//		String frase = Utils.obtenerCadenaConDescripcion("Dame una frase: ");
		String frase = "Java 123 es genial!";
		
		List<Character> minusculas = new ArrayList<Character>();
		List<Character> mayusculas = new ArrayList<Character>();
		List<Character> digitos = new ArrayList<Character>();
		List<Character> especiales = new ArrayList<Character>();
		HashMap<String, List<Character>> map = new HashMap<String, List<Character>>();

		map.put("Minúsculas", minusculas);
		map.put("Mayúsculas", mayusculas);
		map.put("Dígitos", digitos);
		map.put("Especiales", especiales);

		for(int i = 0; i < frase.length(); i++) {
			char c = frase.charAt(i);
			
			if (Character.isLowerCase(c)) minusculas.add(c);
			if (Character.isUpperCase(c)) mayusculas.add(c);
			if (Character.isDigit(c)) digitos.add(c);
			if (!Character.isLetterOrDigit(c)) especiales.add(c);
		}

		Iterator<String> keys =  map.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.print(key + ":");
			List<Character> l = map.get(key);
			for(Character c : l) {
				System.out.print(c + ",");
			}
			System.out.println();
		}

	}

}












