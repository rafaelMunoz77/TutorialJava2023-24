package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.entitidades.Curso;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.entitidades.Materia;


public class ControladorMateria {
	
	private static String nombreTabla = "centroeducativo.materia";

	public static Materia getPrimero() {
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

	
	public static Materia getUltimo() {
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

	
	public static Materia getAnterior(int idActual) {
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

	
	public static Materia getSiguiente(int idActual) {
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

	
	
	public static List<Materia> getTodos() {
		List<Materia> l = new ArrayList<Materia>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Materia o = getEntidadFromResultSet(rs);
				l.add(o);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
	

	private static Materia getEntidadFromResultSet (ResultSet rs) throws SQLException {
		Materia o = new Materia();
		o.setId(rs.getInt("id"));
		o.setCursoId(rs.getInt("curso_id"));
		o.setAcronimo(rs.getString("acronimo"));
		o.setNombre(rs.getString("nombre"));
		return o;
	}

	
	private static Materia getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		Materia o = null;
		if (rs.next()) {
			o = new Materia();
			o.setId(rs.getInt("id"));
			o.setCursoId(rs.getInt("curso_id"));
			o.setAcronimo(rs.getString("acronimo"));
			o.setNombre(rs.getString("nombre"));
		}
		return o;
	}

}
