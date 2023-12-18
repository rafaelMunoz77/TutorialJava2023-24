package tutorialJava.capitulo6_ColeccionesDeDatos.ejemplo02_HashTable;

import java.util.Enumeration;
import java.util.Hashtable;

public class EjemploHashTable {

	public static void main(String[] args) {
		
		Hashtable ht = new Hashtable();
		ht.put("st01", "String 01");
		ht.put("st02", "String 02");
		ht.put("st03", "String 03");
		ht.put("st04", "String 04");
		
		ht.remove("st04");
		
		ht.size();
		
		Enumeration en = ht.elements();
		while (en.hasMoreElements()) {
			Object obj = en.nextElement();
			System.out.println("Elemento: " + obj.toString());
		}
		

		en = ht.keys();
		while (en.hasMoreElements()) {
			System.out.println("Elemento id: " + en.nextElement() + 
					" - Obj: " + ht.get(en.nextElement()));
		}
		

	}

}
