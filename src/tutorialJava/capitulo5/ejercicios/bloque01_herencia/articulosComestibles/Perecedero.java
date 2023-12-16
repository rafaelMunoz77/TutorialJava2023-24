package tutorialJava.capitulo5.ejercicios.bloque01_herencia.articulosComestibles;

import java.util.Scanner;

public class Perecedero extends Articulo {
	private String fechaCaducidad;

	public Perecedero() {
		super();
	}

	@Override
	public String toString() {
		return "Perecedero [fechaCaducidad=" + fechaCaducidad + ", getNombre()=" + getNombre() + ", getCodigo()="
				+ getCodigo() + ", getPrecio()=" + getPrecio() + "]";
	}

	/**
	 * 
	 */
	public void pideDatosAlUsuario() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame el nombre: ");
		this.nombre = sc.nextLine();
		
		System.out.println("Dame el código: ");
		this.codigo = sc.nextLine();
		
		System.out.println("Dame el precio: ");
		this.precio = Float.parseFloat(sc.nextLine());

		System.out.println("Dame la fecha de caducidad: ");
		this.fechaCaducidad = sc.nextLine();		
	}
	
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	
}
