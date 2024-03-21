package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.entitidades.Estudiante;



public class ControladorEstudiante {
	
	private static String nombreTabla = "estudiante";

	
	public static List<Estudiante> getTodos() {
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Estudiante o = getEntidadFromResultSet(rs);
				l.add(o);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
	

	private static Estudiante getEntidadFromResultSet (ResultSet rs) throws SQLException {
		Estudiante o = new Estudiante();
		o.setId(rs.getInt("id"));
		o.setNombre(rs.getString("nombre"));
		return o;
	}

	
}
