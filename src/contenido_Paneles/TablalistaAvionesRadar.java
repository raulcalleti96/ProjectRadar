package contenido_Paneles;

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

/**
 * Clase que alberga la tabla con los aviones en el aire 
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class TablalistaAvionesRadar extends JPanel {

	// Constantes
	static final long serialVersionUID = 1;
	static String avionselec = "";
	final String[] NOMBRE_COL = { "NOMBRE", "ORIGEN", "DESTINO" };
	final int FILAS = 0;
	final int COLUMNAS = 3;
	final DefaultTableModel model = new DefaultTableModel(NOMBRE_COL, FILAS);
	
	// Instanciación de clase
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

	/**
	 * Constructor que diseña la tabla y la añade al panel
	 * @param control  para pasar el listado de aviones
	 */
	public TablalistaAvionesRadar(Control control) {

		// Variables para definir las clases
		this.control = control;
		
		// Configuración del panel
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		tablaAero.setBackground(new Color(55, 119, 171));
		setSize(50, 20);
		setToolTipText("Lista de los aviones del aeropuerto");
		
		//Método para rellenar la tabla
		ponerenTabla();

		
		// Método para realizar la acción cuando pulsa dos veces un <avión>
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
					
					//Asigna el nombre del avión a la variable
					avionselec = cadena;
					
					//Se instancia una ventana de dialogo con la información actual del avión
					InfoavionRadar informaavion = new InfoavionRadar(control, cadena);
					
					//Hace visible el dialogo
					informaavion.setVisible(true);
				}
			}
		});

		//Añade el scroll al panel
		add(scroll, BorderLayout.CENTER);

	}

	/**
	 * Método para poner en la tabla los valores del listado de aviones del aeropuerto  de la clase 
	 */
	public void ponerenTabla() {

		//Recorre el listado de aviones del vector de aviones del aeropuerto de la clase <Control>
		for (int i = 0; i < control.llegadaAviones.size(); i++) {
			
			//Se crea un Array para almacenar la matrícula, origen y destino del <avión>
			String[] lista = new String[3];

			//Rellena el array con la información obtenida
			lista[0] = control.llegadaAviones.elementAt(i).getNombre();
			lista[1] = control.llegadaAviones.elementAt(i).getOrigen();
			lista[2] = control.llegadaAviones.elementAt(i).getDestino();

			//Añade el array a la fila de la tabla
			model.addRow(lista);

		}

	}

}
