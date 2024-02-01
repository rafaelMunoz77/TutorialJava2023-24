package tutorialJava.examenes.examen_20240130.ejercicio4;

import java.util.Calendar;

public class Reserva {
	String nombre;
	Calendar fecha;
	
	public Reserva() {
		super();
	}

	public Reserva(String nombre, Calendar fecha) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Reserva [nombre=" + nombre + ", fecha=" + fecha + "]";
	}
}
