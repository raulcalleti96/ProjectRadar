package paneles;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import bilbao.Control;
import contenido_Paneles.PermisosRadar;
import contenido_Paneles.TablalistaAvionesRadar;

/**
 * Clase que alberga el panel que contendrá los paneles dentro de la tabla  y permisos de  lista de aviones de  en vuelo
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class PanelRadar extends JPanel {
	
	//Constante de versión
	private static final long serialVersionUID = 1L;
	
	//Instanciación de un control
	Control listadoAviones = new Control();
	
	//Instaciación los paneles de la tabla y permimsos y se le pasa como parametro el listado de aviones 
	TablalistaAvionesRadar listaterminal = new TablalistaAvionesRadar(listadoAviones);
	PermisosRadar permisosterminal = new PermisosRadar(listadoAviones, listaterminal);
	
	//Panel especial que mont un panel con una barra en medio para redimensionar
	JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listaterminal,permisosterminal);
	
	/**
	 * Constructor que añadirá al panel los paneles de tabla y permisos
	 * @param listadoAviones proporciona un listado de los aviones en vuelo 
	 */
	public PanelRadar(Control listadoAviones) {
		
		// Variables para definir las clases
		this.listadoAviones = listadoAviones;
		
		//Configuración del panel
		setLayout(new GridLayout(1,2));
	
		//Añade al panel los paneles de tabla y permisos
		add(listaterminal);
		add(permisosterminal);
	}
	
	
}

