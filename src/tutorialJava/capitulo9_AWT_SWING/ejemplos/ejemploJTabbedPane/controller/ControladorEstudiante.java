package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.model.Estudiante;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.model.Materia;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploMVC.ConnectionManager;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploMVC.Curso;

public class ControladorEstudiante {

	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Estudiante getEntidadFromResultSet(String sql) {
		Estudiante o = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				o = new Estudiante();
				o.setId(rs.getInt("id"));
				o.setNombre(rs.getString("nombre"));
				o.setApellidos(rs.getString("apellido1"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Estudiante findFirst () {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.estudiante order by id limit 1");
	}
	
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	public static int guardar (Estudiante e) {
		return 1;
	}

}
