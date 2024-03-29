package tutorialJava.capitulo8_Acceso_A_Datos.mysql.ejercicios.bloque01_CRUD_Fabricante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SupertipoGestion {

	
	/**
	 * 
	 * @param nombreTabla
	 * @return
	 */
	protected static int nextIdEnTabla(String nombreTabla) {
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			ResultSet rs = s.executeQuery("Select max(id) from " + nombreTabla);
			
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1; 		
	}

}
