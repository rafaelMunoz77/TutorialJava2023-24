package tutorialJava.capitulo5.ejercicios.bloque01_herencia.articulosComestibles;

public class Articulo {
	protected String nombre;
	protected String codigo;
	protected float precio;
	
	public Articulo() {
		super();
	}

	@Override
	public String toString() {
		return "Articulo [nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
