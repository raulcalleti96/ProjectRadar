package bilbao;

import java.util.Vector;
import dialogos.Victoria;

/**
 * Clase que maneja las listas de aviones que le proporciona la base de datos
 * 
 * @author: Pablo Borrego 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class Control {

	//Vectores con los aviones de la base de datos
	public Vector<Avion> listadoAviones = new Vector<Avion>(new MySql().rellenarLista());
	public Vector<Avion> llegadaAviones = new Vector<Avion>(new MySql().listadollegadas());
	
	//Variables con el estado de las listas, vacía o no
	public static boolean listadoVacio = false;
	public static boolean llegadaVacio = false;
 
	/**
	 * Método que comprueba si las dos listas están vacias
	 */
	public void compruebalista() {
		
		//Referencia de la clase Victoria
		Victoria nueva;
		
		//Condición si las dos listas están vacías
		if (listadoVacio == true && llegadaVacio == true) {

			//Instanciación de la ventana de dialogo de victoria
			nueva = new Victoria();
			nueva.setVisible(true);
		}

	}

}
