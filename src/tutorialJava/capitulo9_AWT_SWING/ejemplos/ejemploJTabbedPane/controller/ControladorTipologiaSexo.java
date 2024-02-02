package tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.model.TipologiaSexo;


public class ControladorTipologiaSexo {

	/**
	 * 
	 * @return
	 */
	public static List<TipologiaSexo> findAll() {
		List<TipologiaSexo> lista = new ArrayList<TipologiaSexo>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from tipologiaSexo");
			
			while (rs.next()) {
				TipologiaSexo o = new TipologiaSexo();
				o.setId(rs.getInt("id"));
				o.setDescripcion(rs.getString("descripcion"));
				lista.add(o);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static TipologiaSexo findById(int id) {
		TipologiaSexo o = null;
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from tipologiaSexo where id = " + id);
			
			if (rs.next()) {
				o = new TipologiaSexo();
				o.setId(rs.getInt("id"));
				o.setDescripcion(rs.getString("descripcion"));
			}
			rs.close();
			st.close();
			conn.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return o;
	}

}
