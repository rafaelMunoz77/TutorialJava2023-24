package tutorialJava.capitulo7_Recursos.ejercicios.bloque01_WrappersDeTiposPrimitivos;

public class Ejercicio03_100PrimerosNumerosEnHexadecimal {

	public static void main(String[] args) {

		for (int i = 0; i < 101; i++) {
			System.out.println("Decimal: " + i + " - Hexadecimal: 0x" + Integer.toHexString(i));
		}
	}
}
