package dialogos;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import bilbao.Control;

/**
 * Clase que alberga una ventana de dialogo proporcionando la información del avión seleccionado del vector de control que está en el aeropuerto
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class InfoavionTerminal extends JDialog {
	
	// Constante de Versión
	private static final long serialVersionUID = 1L;
	
	//Instanciación de un control 
	Control control = new Control();

	/**
	 * Constructor de la clase de la ventana dialogo 
	 * @param control Proporcioná el listado de los aviones en el aeropuerto 
	 * @param matricula Proporcionará la matricula o nombre del avión que desea conocer
	 */
	public InfoavionTerminal(Control control, String matricula) {

		// Variables para definir las clases
		this.control = control;
		
		//Configuración del panel
		setLayout(new FlowLayout());
		setBounds(340, 210, 310, 110);

		//Ejecuta el método selección
		seleccion(matricula);
	}

	/**
	 * Método para proporcionar del indice de la matricula del avión que quiere conocer la información
	 * @param matricula del avión
	 */
	public void seleccion(String matricula) {
		
		//Variable que albergará el indice
		int indice = 0;

		//Recorre un bucle hasta encontrar el avión por la matricula aportada
		for (int i = 0; i < control.listadoAviones.size(); i++) {

			//Si el nombre de la matricula dada es igual al nombre del avión del indice guarda su indice del vector
			if (matricula.equalsIgnoreCase(control.listadoAviones.elementAt(i).getNombre())) {
				indice = i;
			}

		}

		// Instanciación las etiquetas
		JLabel nombre = new JLabel("Avión: " + control.listadoAviones.elementAt(indice).getNombre());
		JLabel radio = new JLabel("Radio: " + control.listadoAviones.elementAt(indice).pruebaRadio());
		JLabel ruta = new JLabel("Pista: " + control.listadoAviones.elementAt(indice).getPista());
		JLabel motores = new JLabel("Rodadura: " + control.listadoAviones.elementAt(indice).estadoRodadura());
		JLabel despegue = new JLabel("Despegue: " + control.listadoAviones.elementAt(indice).motores());
 
		//Configuración de los paneles y botones
		nombre.setBounds(115, 60, 200, 30);
		radio.setBounds(115, 60, 200, 30);
		ruta.setBounds(115, 60, 200, 30);
		motores.setBounds(115, 60, 200, 30);
		despegue.setBounds(115, 60, 200, 30);
		
		//Asigna al panel los elementos
		add(nombre);
		add(radio);
		add(ruta);
		add(motores);
		add(despegue);
		
	}

}
