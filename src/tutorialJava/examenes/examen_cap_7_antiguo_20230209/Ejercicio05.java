package tutorialJava.examenes.examen_cap_7_antiguo_20230209;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ejercicio05 {

	public static void main(String[] args) {
		String strDate = "2023-02-09 10.30.27";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		Date date = null;
		
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// Paso a un calendar
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -14);
		System.out.println("Calendar dos semanas atras: " + cal.get(Calendar.YEAR) + 
				"-" + (cal.get(Calendar.MONTH) + 1) + 
				"-" + cal.get(Calendar.DAY_OF_MONTH) + 
				" " + cal.get(Calendar.HOUR_OF_DAY) + 
				"." + cal.get(Calendar.MINUTE) + 
				"." + cal.get(Calendar.SECOND) 
				);
		
		// Creamos la misma fecha con un nuevo objeto Calendar
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, 2023);
		cal2.set(Calendar.MONTH, 0);
		cal2.set(Calendar.DAY_OF_MONTH, 26);
		cal2.set(Calendar.HOUR_OF_DAY, 10);
		cal2.set(Calendar.MINUTE, 30);
		cal2.set(Calendar.SECOND, 27);
		
		// Diferencia horaria entre dos lugares
		Calendar ahoraEnGalapagos = Calendar.getInstance(TimeZone.getTimeZone("Pacific/Galapagos"));
		Calendar ahoraEnLisboa = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
		
		int horaEnGalapagos = ahoraEnGalapagos.get(Calendar.HOUR_OF_DAY);
		int horaEnLisboa = ahoraEnLisboa.get(Calendar.HOUR_OF_DAY);

		System.out.println("Diferencia horaria: " + Math.abs(horaEnGalapagos - horaEnLisboa));
		
	}
}









