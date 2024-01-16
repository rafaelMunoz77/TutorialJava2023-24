package tutorialJava.capitulo6_ColeccionesDeDatos.ejercicios.bloque02_Hashmap;

public class Articulo {

	private String nombre;
	private int codigoDeBarras;
	private int numeroDeEstante;
	private int stock;

	
	
	/**
	 * 
	 */
	public Articulo() {
		super();
	}

	/**
	 * @param nombre
	 * @param codigoDeBarras
	 * @param numeroDeEstante
	 * @param stock
	 */
	public Articulo(String nombre, int codigoDeBarras, int numeroDeEstante, int stock) {
		super();
		this.nombre = nombre;
		this.codigoDeBarras = codigoDeBarras;
		this.numeroDeEstante = numeroDeEstante;
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(int codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public int getNumeroDeEstante() {
		return numeroDeEstante;
	}
	public void setNumeroDeEstante(int numeroDeEstante) {
		this.numeroDeEstante = numeroDeEstante;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Articulo [nombre=" + nombre + ", codigoDeBarras=" + codigoDeBarras + ", numeroDeEstante="
				+ numeroDeEstante + ", stock=" + stock + "]";
	}
	

}
