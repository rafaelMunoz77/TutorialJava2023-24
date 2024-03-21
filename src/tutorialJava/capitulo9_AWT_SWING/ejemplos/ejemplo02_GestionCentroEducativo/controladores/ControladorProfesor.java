package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.entitidades.Curso;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.entitidades.Materia;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.entitidades.Profesor;


public class ControladorProfesor {
	
	private static String nombreTabla = "profesor";

	
	public static List<Profesor> getTodos() {
		List<Profesor> l = new ArrayList<Profesor>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Profesor o = getEntidadFromResultSet(rs);
				l.add(o);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
	

	private static Profesor getEntidadFromResultSet (ResultSet rs) throws SQLException {
		Profesor o = new Profesor();
		o.setId(rs.getInt("id"));
		o.setNombre(rs.getString("nombre"));
		return o;
	}

	
}
