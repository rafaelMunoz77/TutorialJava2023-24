package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorCurso {


	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Curso findFirst () {
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso order by id limit 1");
			
			Curso curso = null; // Sirve como bandera para saber si se ha encontrado o no el registro
			if (rs.next()) {
				curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setDescripcion(rs.getString("descripcion"));
			}
			rs.close();
			st.close();
			conn.close();
			return curso;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (Curso c) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update curso set descripcion = ? where id = ?");
		
			ps.setString(1, c.getDescripcion());
			ps.setInt(2, c.getId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
