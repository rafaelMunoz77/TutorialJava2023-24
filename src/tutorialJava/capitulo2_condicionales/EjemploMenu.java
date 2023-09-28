package tutorialJava.capitulo2_condicionales;

import javax.swing.JOptionPane;

public class EjemploMenu {

	public static void main(String[] args) {
		String str;
		int opcion, numero1, numero2;
		
//		System.out.println("Menú:");
//		System.out.println("1.- Suma");
//		System.out.println("2.- Resta");
//		System.out.println("3.- Multiplicación");
//		System.out.println("4.- División");
		
		str = JOptionPane.showInputDialog("Menú:" +
				"\n1.- Suma\n2.- Resta\n3.- Multiplicación\n4.- División\n" + 
				"Introduzca la opción: ");
		opcion = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca el primer número: ");
		numero1 = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduzca el segundo número: ");
		numero2 = Integer.parseInt(str);
		
		
		switch(opcion) {
		case 1:
			System.out.println("La suma vale: " + (numero1 + numero2));
			break;
		case 2:
			System.out.println("La resta vale: " + (numero1 - numero2));
			break;
		case 3:
			System.out.println("La multiplicación vale: " + (numero1 * numero2));
			break;
		case 4:
			System.out.println("La división vale: " + (numero1 / numero2));
			break;
		default:
			System.out.println("La opción " + opcion + " no está contemplada");
		}
	}

}












