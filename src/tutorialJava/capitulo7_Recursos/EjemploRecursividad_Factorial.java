package tutorialJava.capitulo7_Recursos;

public class EjemploRecursividad_Factorial {

	public static void main(String[] args) {
		System.out.println("Mediante no recursividad: " + factorialNoRecursivo(6));
		System.out.println("Mediante recursividad: " + factorialRecursivo(6));
	}
	
	
	public static int factorialRecursivo(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorialRecursivo(n - 1);
	}
	
	
	public static int factorialNoRecursivo(int n) {
		for (int i = n-1; i > 1; i--) {
			n *= i;
		}
		return n;
	}

}
