package tutorialJava.capitulo8_Acceso_A_Datos.mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ejemplo03_EjemplosInsertUpdateyDeleteConPreparedStatement {

	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static Connection getConexion() throws ClassNotFoundException, SQLException {
		String driver = JDBCPropiedades.getProperty("JDBC_DRIVER_CLASS");
		String user = JDBCPropiedades.getProperty("JDBC_USER");
		String password = JDBCPropiedades.getProperty("JDBC_PASSWORD");
		String host = JDBCPropiedades.getProperty("JDBC_HOST");
		String schema = JDBCPropiedades.getProperty("JDBC_SCHEMA_NAME");
		String properties = JDBCPropiedades.getProperty("JDBC_PROPERTIES");

		Class.forName(driver);

		return (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema + properties, user, password);
	}
	
	
	
	/**
	 * 
	 * @return
	 * @throws SQLException 
	 */
	private static int getSiguienteIdValidoConcesionario(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) as maximoId "
				+ "from tutorialjavacoches.concesionario");
	
		if (rs.next()) {
			return rs.getInt(1) + 1;
		}
		
		return 1;
	}
	
	
	
	/**
	 * @throws SQLException 
	 * 
	 */
	private static void realizaInsert (Connection conn) throws SQLException {
				
		PreparedStatement ps = conn.prepareStatement(
				"insert into tutorialjavacoches.concesionario "
				+ "(id, cif, nombre, localidad) "
				+ "values (?, ?, ?, ?)");
		ps.setInt(1, getSiguienteIdValidoConcesionario(conn));
		ps.setString(2, "111111B");
		ps.setString(3, "Hermanos O'Bryan");
		ps.setString(4, "Lucena");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		java.util.Date fechaNac = null;
		try {
			fechaNac = sdf.parse("19/03/1977 15:33:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ps.setDate(0, new java.sql.Date(fechaNac.getTime()) );

		int filasAfectadas = ps.executeUpdate();
	   
		System.out.println("Filas afectadas: " + filasAfectadas);
		
		ps.close();
	}
	

	/**
	 * @throws SQLException 
	 * 
	 */
	private static void realizaUpdate (Connection conn, String nombreMod,
			String localidadMod, int idMod) throws SQLException {
				
		Statement s = (Statement) conn.createStatement(); 

		int filasAfectadas = s.executeUpdate("update tutorialjavacoches.concesionario "
				+ "set nombre = '" + nombreMod + "', "
				+ "localidad = '" + localidadMod + "'\r\n"
				+ "where id = " + idMod);
	   
		System.out.println("Filas afectadas: " + filasAfectadas);
		
		s.close();
	}
	
	

	/**
	 * @throws SQLException 
	 * 
	 */
	private static void realizaDelete (Connection conn, int idMod) throws SQLException {
				
		Statement s = (Statement) conn.createStatement(); 

		int filasAfectadas = s.executeUpdate("Delete from "
				+ "tutorialjavacoches.concesionario "
				+ "where id = " + idMod);
	   
		System.out.println("Filas afectadas: " + filasAfectadas);
		
		s.close();
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Connection conn = getConexion();

			realizaInsert(conn);
//			realizaUpdate(conn, "Concesionario José María", "Lucena", 22);
//			realizaDelete(conn, 23);
			
			conn.close();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
