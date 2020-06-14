package dialogos;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import bilbao.Control;

/**
 * Clase que alberga una ventana de dialogo proporcionando la información del avión seleccionado del vector de control que está en vuelo
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class InfoavionRadar extends JDialog {
	
	// Constante de Versión
	private static final long serialVersionUID = 1L;
	
	//Instanciación de un control 
	Control control = new Control();

	/**
	 * Constructor de la clase de la ventana dialogo 
	 * @param control Proporcioná el listado de los aviones en vuelo 
	 * @param matricula Proporcionará la matricula o nombre del avión que desea conocer
	 */
	public InfoavionRadar(Control control, String matricula) {

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
		for (int i = 0; i < control.llegadaAviones.size(); i++) {

			//Si el nombre de la matricula dada es igual al nombre del avión del indice guarda su indice del vector
			if (matricula.equalsIgnoreCase(control.llegadaAviones.elementAt(i).getNombre())) {
				indice = i;
			}

		} 

		// Instanciación las etiquetas
		JLabel nombre = new JLabel("Avión: " + control.llegadaAviones.elementAt(indice).getNombre());
		JLabel pista = new JLabel("Pista: " + control.llegadaAviones.elementAt(indice).getPista());
		JLabel contacto = new JLabel("Contacto: " + control.llegadaAviones.elementAt(indice).estadoContacto());
		JLabel rodadura = new JLabel("Rodadura: " + control.llegadaAviones.elementAt(indice).estadoRodadura());
		JLabel motores = new JLabel("Motores: " + control.llegadaAviones.elementAt(indice).motores());

		//Configuración de los paneles y botones
		nombre.setBounds(115, 60, 200, 30);
		pista.setBounds(115, 60, 200, 30);
		contacto.setBounds(115, 60, 200, 30);
		rodadura.setBounds(115, 60, 200, 30);
		motores.setBounds(115, 60, 200, 30);

		//Asigna al panel los elementos
		add(nombre);
		add(pista);
		add(contacto);
		add(rodadura);
		add(motores);
	
		
	}



}
