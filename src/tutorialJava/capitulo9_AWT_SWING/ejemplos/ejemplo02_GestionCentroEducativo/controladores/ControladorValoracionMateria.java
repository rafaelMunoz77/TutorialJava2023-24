package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.entitidades.Curso;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemplo02_GestionCentroEducativo.entitidades.ValoracionMateria;


public class ControladorValoracionMateria {
	
	private static String nombreTabla = "valoracionmateria";

	
	public static ValoracionMateria findByIdMateriaAndIdProfesorAndIdEstudiante(
			int idMateria, int idProfesor, int idEstudiante) {
		
		ValoracionMateria v = null;
		
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(
					"select * from " + nombreTabla + " where idProfesor = ? and"
							+ " idMateria = ? and idEstudiante = ? limit 1 ");
			
			ps.setInt(1, idProfesor);
			ps.setInt(2, idMateria);
			ps.setInt(3, idEstudiante);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				v = getEntidadFromResultSet(rs);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;		
	}
	
	
	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static ValoracionMateria getEntidadFromResultSet (ResultSet rs) throws SQLException {
		ValoracionMateria o = new ValoracionMateria();
		o.setId(rs.getInt("id"));
		o.setIdEstudiante(rs.getInt("idEstudiante"));
		o.setIdMateria(rs.getInt("idMateria"));
		o.setIdProfesor(rs.getInt("idProfesor"));
		o.setValoracion(rs.getFloat("valoracion"));
		return o;
	}
}












