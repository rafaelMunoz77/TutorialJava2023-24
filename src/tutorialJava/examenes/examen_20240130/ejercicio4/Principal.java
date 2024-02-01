package tutorialJava.examenes.examen_20240130.ejercicio4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import tutorialJava.Utils;

public class Principal {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public static void main(String[] args) {
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		// Creo las dos reservas
		for(int i = 0; i < 2; i++) {
			reservas.add(creaReserva());
		}
		
		// Visualizar las reservas
		for (Reserva r : reservas) {
			muestraReservar(r);
		}
		
	}

	
	/**
	 * 
	 * @return
	 */
	private static Reserva creaReserva () {
		Reserva r = new Reserva();
		
		System.out.println("Nueva reserva");
		r.setNombre(Utils.obtenerCadenaConDescripcion("Dime el nombre de la reserva: "));
		
		try {
			Date d = sdf.parse(Utils.obtenerCadenaConDescripcion("Dime la fecha (dd/MM/yyyy): "));
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			r.setFecha(cal);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		return r;
	}
	
	/**
	 * 
	 */
	private static void muestraReservar (Reserva r) {
//		System.out.println("Tengo una reserva a nombre de " + r.getNombre() + "\ny con fecha " + 
//				r.getFecha().get(Calendar.DAY_OF_MONTH) + "/" + 
//				(r.getFecha().get(Calendar.MONTH) + 1) + "/" +
//				r.getFecha().get(Calendar.YEAR));
		
		Date d = new Date(r.getFecha().getTimeInMillis());
		
		System.out.println("Tengo una reserva a nombre de " + r.getNombre() + "\ny con fecha " + 
				sdf.format(d));
	}
}














