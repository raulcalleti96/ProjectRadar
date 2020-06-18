package bilbao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Clase que alberga la base de datos y rellenandola en un vector
 * 
 * @author: Pablo Borrego 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class MySql {

	/**
	 * Constructor vacío de la clase
	 */
	public MySql() {

	}

	/**
	 * Método que conecta con la Base de Datos y lo rellena en un vector para las llegadas
	 * @return Devuelve un vector de la clase avión relleno con la información de la base de datos
	 */
	public Vector<Avion> listadollegadas() {

		//Declaración del vector de la clase Avión 
		Vector<Avion> llegadasAviones = new Vector<Avion>();
		// Parametros
		String driver = "com.mysql.cj.jdbc.Driver";
		String database = "terminal";
		String hostname = "localhost";
		String port = "3306";
		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&serverTimeZone=CEST";
		String usr = "root";
		String pwd = "12345678";
		//Referencias de las clases de las bases de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;


		try {
			//Se levanta el driver
			Class.forName(driver);
		
			//Se establece conexión con la base de datos
			conn = DriverManager.getConnection(url, usr, pwd);
			
			//Se define la consulta
			String sql = "SELECT nombre, origen, destino FROM llegadas";
			
			//Se prepara la sentencia a ejecutar
			pstm = conn.prepareStatement(sql);
			
			//Se ejecuta la sentencia y recogen los resultados
			rs = pstm.executeQuery();
			
			//Se itere por lo resultados
			while (rs.next()) {
				
				//Instancio la clase Avión
				Avion nuevo = new Avion();
				
				//Asigna el numbre, origen y destino de las columnas de la tabla al avión
				nuevo.setNombre(rs.getString("nombre"));
				nuevo.setOrigen(rs.getString("origen"));
				nuevo.setDestino(rs.getString("destino"));
				llegadasAviones.add(nuevo);

			}

		} catch (ClassNotFoundException e) {

			System.out.println(e);

		} catch (SQLException e) {
			System.out.println(e);

		} finally {

			try {
				
				//Se cierran los recursos en orden inverso a su creación
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();

				//devuelve el vector de aviones
				return llegadasAviones;
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		return null;

	}

	/**
	 * Método que conecta con la Base de Datos y lo rellena en un vector para las salidas
	 * @return Devuelve un vector de la clase Avión relleno con la información de la base de datos
	 */
	public Vector<Avion> rellenarLista() {

		//Declaración del vector de la clase Avión
		Vector<Avion> listadoAviones = new Vector<Avion>();
		// Parametros
		String driver = "com.mysql.cj.jdbc.Driver";
		String database = "terminal";
		String hostname = "localhost";
		String port = "3306";
		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&serverTimeZone=UTC";
		
		String usr = "root";
		String pwd = "12345678";
		
		//Referencias de las clases de las bases de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			//Se levanta el driver
			Class.forName(driver);
			
			//Se establece conexión con la base de datos
			conn = DriverManager.getConnection(url, usr, pwd);
			
			//Se define la consulta
			String sql = "SELECT nombre, origen, destino FROM aviones";
			
			//Se define la consulta
			pstm = conn.prepareStatement(sql);
			
			//Se ejecuta la sentencia y recogen los resultados
			rs = pstm.executeQuery();
			
			//Se itere por lo resultados
			while (rs.next()) {

				//Instancio la clase <Avion>
				Avion nuevo = new Avion();
				
				//Asigna el numbre, origen y destino de las columnas de la tabla al avión
				nuevo.setNombre(rs.getString("nombre"));
				nuevo.setOrigen(rs.getString("origen"));
				nuevo.setDestino(rs.getString("destino"));
				listadoAviones.add(nuevo);

			}

		} catch (ClassNotFoundException e) {

			System.out.println(e);

		} catch (SQLException e) {
			System.out.println(e);

		} finally {

			try {

				//Se cierran los recursos en orden inverso a su creación
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();

				//devuelve el vector de aviones
				return listadoAviones;
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		return null;

	}

}
