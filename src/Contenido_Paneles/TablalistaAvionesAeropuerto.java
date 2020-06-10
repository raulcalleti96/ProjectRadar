package Contenido_Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bilbao.Avion;

public class TablalistaAvionesAeropuerto extends JPanel {

	static final long serialVersionUID = 1;

	static String avionselec = "";
	final String[] NOMBRE_COL = { "NOMBRE", "ORIGEN", "DESTINO" };
	final int FILAS = 0;
	final int COLUMNAS = 3;
	final DefaultTableModel model = new DefaultTableModel(NOMBRE_COL, FILAS); 
	final Vector<Avion> listadoAviones = new Vector<Avion>();

	// Tabla Aeropuerto
	final JTable tablaAero = new JTable(model) {

		// Se configura la tabla como no editable
		static final long serialVersionUID = 1;

		public boolean isCellEditable(int filas, int columnas) {
			return false;
		}
	};

	// Panel de Scroll
	JScrollPane scroll = new JScrollPane(tablaAero);

	public TablalistaAvionesAeropuerto() {

		setLayout(new BorderLayout());
		setBackground(Color.BLACK.brighter());
		tablaAero.setBackground(new Color(162, 212, 83));
		setToolTipText("Lista de los aviones del aeropuerto");
		visalizarBase();
		ponerenTabla();
		//model.addRow(listadoAviones);

		
		// METODO DE SELECCION DEL AVIÓN

		tablaAero.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				// Evento cuando se produzca un doble click (Recoge la fila)
				if (e.getClickCount() == 2) {

					// Recoge la fila
					int fila = tablaAero.rowAtPoint(e.getPoint());
					String cadena = "";

					// Forma una cadena con los atributos del avión para mostrarlos en la asignación
					// de permisos
					if (fila >= 0)
						for (int i = 0; i < tablaAero.getColumnCount(); i++) {
							cadena += tablaAero.getValueAt(fila, i) + " ";
						}
					// Seleccion del avión para permisos
					avionselec = cadena;
					System.out.println(avionselec + "LA SELECCION FUNCIONA");
				}
			}
		});

		add(scroll, BorderLayout.CENTER);

	}

	//MÉTODO PARA SACAR DATOS
	public void ponerenTabla() {
		
		for(int i = 0; i < listadoAviones.size();i++) {
			String[] lista = new String[3];
	
			lista[0] = listadoAviones.elementAt(i).getNombre();
			lista[1] = listadoAviones.elementAt(i).getOrigen();
			lista[2] = listadoAviones.elementAt(i).getDestino();
			
			model.addRow(lista);
		}
		
		
		
	}
	
	// METODO PARA AÑADIR DATOS
	public void visalizarBase() {
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

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}

}
