package paneles;


import java.awt.GridLayout;
import javax.swing.JPanel;

import bilbao.Control;
import contenido_Paneles.PermisosAeropuerto;
import contenido_Paneles.TablalistaAvionesAeropuerto;


/**
 * Clase que alberga el panel que contendrá  los paneles dentro de la tabla  y permisos de  lista de aviones  en el aeropuerto
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class PanelAeropuerto extends JPanel  {
	
	// Constante de Versión
	private static final long serialVersionUID = 1L;
	
	//Instanciación de un control  
	Control listadoAviones = new Control();
	
	//Instaciación los paneles de la tabla y permimsos y se le pasa como parametro el listado de aviones 
	TablalistaAvionesAeropuerto listaterminal = new TablalistaAvionesAeropuerto(listadoAviones);
	PermisosAeropuerto permisosterminal = new PermisosAeropuerto(listadoAviones, listaterminal);

	/**
	 * Constructor que añadirá al panel los paneles de tabla y permisos
	 * @param listadoAviones proporciona un listado de los aviones en el aeropuerto 
	 */
	public PanelAeropuerto(Control listadoAviones) {
		
		// Variables para definir las clases
		this.listadoAviones = listadoAviones;

		//Configuración del panel
		setLayout(new GridLayout(1,2));
		
		//Añade al panel los paneles de tabla y permisos
		add(listaterminal);
		add(permisosterminal);
	

	}

}


