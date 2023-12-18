package tutorialJava.capitulo6_ColeccionesDeDatos.ejemplo01_ListYArrayList;

import java.util.ArrayList;
import java.util.List;

public class EjemploListasCromos {

	public static void main (String args[]) {
		CromoBaloncesto c1 = new CromoBaloncesto(100, "Felipe Reyes");
		CromoBaloncesto c2 = new CromoBaloncesto(200, "Lebron");
		CromoBaloncesto c3 = new CromoBaloncesto(300, "Pau Gasol");

		List<CromoBaloncesto> lista = new ArrayList<CromoBaloncesto>();
		lista.add(c1);
		lista.add(c2);
		lista.add(10, c3);
		
		for (CromoBaloncesto c : lista) {
			System.out.println(c.getNombre());
		}
		

		
//		CromoBaloncesto c4 = new CromoBaloncesto(4, "Cristina Castro");
//		CromoBaloncesto c5 = new CromoBaloncesto(5, "María Jesús Joyanes");
//		CromoBaloncesto c6 = new CromoBaloncesto(6, "Alazne Ruiz");
//
//		List<CromoBaloncesto> lista2 = new ArrayList<CromoBaloncesto>();
//		lista2.add(c4);
//		lista2.add(c5);
//		lista2.add(c6);
//		
//		lista.addAll(1, lista2);
//		
//		lista.removeAll(lista);
//		
//		System.out.println("VAcía: " + lista.isEmpty());
//		
//		for (CromoBaloncesto c : lista) {
//			System.out.println(c.toString());
//		}		
		
	}
}
