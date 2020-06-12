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
import dialogos.Infoavion;

public class TablalistaAvionesAeropuerto extends JPanel {

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

	public TablalistaAvionesAeropuerto(Control control) {

		this.control = control;
		setLayout(new BorderLayout());
		setBackground(Color.BLACK.brighter());
		tablaAero.setBackground(new Color(162, 212, 83));
		setToolTipText("Lista de los aviones del aeropuerto");
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
						/*for (int i = 0; i < tablaAero.getColumnCount(); i++) {
							cadena += tablaAero.getValueAt(fila, i) + " ";
						}*/
					// Seleccion del avión para permisos
						cadena = (String) tablaAero.getValueAt(fila, 0);
					avionselec = cadena;
					
					Infoavion secundaria = new Infoavion(control);
					secundaria.setVisible(true);
					
					
					//System.out.println(avionselec + "LA SELECCION FUNCIONA");
				}
			}
		});

		add(scroll, BorderLayout.CENTER);
		//model.fireTableDataChanged();
	}
	 
	
	/*//Método selección de vuelo
	public void seleccionvuelo(String avionselec){
		
		for(int i = 0; i<control.listadoAviones.size();i++) {
			
			if(control.listadoAviones.elementAt(i).getSeleccion() == true) {

				 control.listadoAviones.elementAt(i).setSeleccion(false);
			}
			
		}	

		for(int i = 0; i<control.listadoAviones.size();i++) {
			
			if(avionselec.equalsIgnoreCase(control.listadoAviones.elementAt(i).getNombre())) {
				
				 control.listadoAviones.elementAt(i).setSeleccion(true);
			}
			
		}	
		
	}*/

	//MÉTODO PARA SACAR DATOS
	public void ponerenTabla() {
		
		
		for(int i = 0; i < control.listadoAviones.size();i++) {
			String[] lista = new String[3];
	
			lista[0] = control.listadoAviones.elementAt(i).getNombre();
			lista[1] = control.listadoAviones.elementAt(i).getOrigen();
			lista[2] = control.listadoAviones.elementAt(i).getDestino();
			
			
			model.addRow(lista);
			
		}
		
		
		
	}
	
	

}
