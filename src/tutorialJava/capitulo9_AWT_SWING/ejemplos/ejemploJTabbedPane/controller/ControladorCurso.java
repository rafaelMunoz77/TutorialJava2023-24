package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.model.Curso;

public class ControladorCurso {

	/**
	 * 
	 * @return
	 */
	public static List<Curso> findAll() {
		List<Curso> cursos = new ArrayList<Curso>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from curso");
			
			while (rs.next()) {
				Curso c = new Curso();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				cursos.add(c);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return cursos;
	}
}
