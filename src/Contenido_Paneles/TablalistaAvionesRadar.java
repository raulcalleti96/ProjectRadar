package Contenido_Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bilbao.Control;
import dialogos.InfoavionRadar;

public class TablalistaAvionesRadar extends JPanel {

	static final long serialVersionUID = 1;

	static String avionselec = "";
	final String[] NOMBRE_COL = { "NOMBRE", "ORIGEN", "DESTINO" };
	final int FILAS = 0;
	final int COLUMNAS = 3;
	final DefaultTableModel model = new DefaultTableModel(NOMBRE_COL, FILAS);
	Control control = null;

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

	public TablalistaAvionesRadar(Control control) {

		this.control = control;
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		tablaAero.setBackground(new Color(55, 119, 171));
		setSize(50, 20);
		setToolTipText("Lista de los aviones del aeropuerto");
		ponerenTabla();
		/*
		 * tablaAero.setSize(45, 45); scroll.setSize(30, 30);
		 */

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
					cadena = (String) tablaAero.getValueAt(fila, 0);
					avionselec = cadena;
					InfoavionRadar informaavion = new InfoavionRadar(control,cadena);
					informaavion.setVisible(true);
				}
			}
		});

		add(scroll, BorderLayout.CENTER);

	}

	// MÉTODO PARA SACAR DATOS
	public void ponerenTabla() {

		for (int i = 0; i < control.llegadaAviones.size(); i++) {
			String[] lista = new String[3];

			lista[0] = control.llegadaAviones.elementAt(i).getNombre();
			lista[1] = control.llegadaAviones.elementAt(i).getOrigen();
			lista[2] = control.llegadaAviones.elementAt(i).getDestino();

			model.addRow(lista);

		}

	}

}
