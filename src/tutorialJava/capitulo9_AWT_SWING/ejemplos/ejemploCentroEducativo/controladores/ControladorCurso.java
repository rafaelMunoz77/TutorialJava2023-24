package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploCentroEducativo.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploCentroEducativo.entitidades.Curso;


public class ControladorCurso {
	
	private static String nombreTabla = "centroeducativo.curso";

	public static Curso getPrimero() {
		try {
			return getEntidad (ConnectionManager.getConexion(),
					"select * from " + nombreTabla
					+ " order by id asc limit 1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public static Curso getUltimo() {
		try {
			return getEntidad(ConnectionManager.getConexion(), 
					"select * from " + nombreTabla
					+ " order by id desc limit 1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public static Curso getAnterior(int idActual) {
		try {
			String sql = "select * from " + nombreTabla + " where id < " + idActual
					+ " order by id desc limit 1";
			return getEntidad (ConnectionManager.getConexion(), sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public static Curso getSiguiente(int idActual) {
		try {
			return getEntidad (ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " where id > " + idActual
					+ " order by id asc limit 1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	private static Curso getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		Curso o = null;
		if (rs.next()) {
			o = new Curso();
			o.setId(rs.getInt("id"));
			o.setDescripcion(rs.getString("descripcion"));
		}
		return o;
	}

}
