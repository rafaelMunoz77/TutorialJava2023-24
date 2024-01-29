package tutorialJava.examenes.examen_cap_7_antiguo_20230209.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class LecturaFicheroPropiedades {

	private static Properties propiedades = null;

	public LecturaFicheroPropiedades () {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	private static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
		    
			try {
				// Una forma de leer el fichero de propiedades
//				propiedades.load(propiedades.getClass().getResourceAsStream("/tutorialJava/capitulo6_Recursos/ejemplo.properties"));

				// Otra forma de leer el fichero de propiedades
				File file = new File("./src/tutorialJava/examenes/examen_cap_7_antiguo_20230209/ex01/props.properties");
				System.out.println("Fichero encontrado: " + file.exists());
				propiedades.load(new FileReader(file));
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		return propiedades;
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}

	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static int getIntProperty (String nombrePropiedad) {
		return Integer.parseInt(getPropiedades().getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static Float getFloatProperty (String nombrePropiedad) {
		return Float.parseFloat(getPropiedades().getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		// Colocamos los objetos en HashMap
		HashMap<String, Object> hm = new HashMap<String, Object>();
		for (int i = 1; i < 5; i++) {
			String key = "ID_" + i;
			hm.put(key, LecturaFicheroPropiedades.getIntProperty(key));
		}
		for (int i = 1; i < 5; i++) {
			String key = "USUARIO_" + i;
			hm.put(key, LecturaFicheroPropiedades.getProperty(key));
		}
		
		// Paso los objetos numéricos enteros a una lista
		List<Integer> l = new ArrayList<Integer>();
		// Leo los objetos del hashmap
		Object claves[] = hm.keySet().toArray();
		for (int i = 0; i < claves.length; i++) {
			Object key = claves[i];
			if (hm.get(key) instanceof Integer) {
				l.add((Integer) hm.get(key));
			}
		}

		// Muestro la lista
		for (Integer i : l) {
			System.out.print(i.intValue() + " ");
		}
				
	}
}







