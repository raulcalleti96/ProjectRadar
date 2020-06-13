package bilbao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MySql {

	public MySql() {

	}

	public Vector<Avion> listadollegadas() {

		Vector<Avion> llegadasAviones = new Vector<Avion>();
		// Parametros
		String driver = "com.mysql.cj.jdbc.Driver";
		String database = "terminal";
		String hostname = "localhost";
		String port = "3306";
		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&serverTimeZone=UTC";
		String usr = "root";
		String pwd = "12345678";
		//
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, usr, pwd);
			String sql = "SELECT nombre, origen, destino FROM llegadas";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {

				Avion nuevo = new Avion();
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

				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();

				return llegadasAviones;
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		return null;

	}

	public Vector<Avion> rellenarLista() {

		Vector<Avion> listadoAviones = new Vector<Avion>();
		// Parametros
		String driver = "com.mysql.cj.jdbc.Driver";
		String database = "terminal";
		String hostname = "localhost";
		String port = "3306";
		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&serverTimeZone=UTC";
		String usr = "root";
		String pwd = "12345678";
		//
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, usr, pwd);
			String sql = "SELECT nombre, origen, destino FROM aviones";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {

				Avion nuevo = new Avion();
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

				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();

				return listadoAviones;
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		return null;

	}

}
