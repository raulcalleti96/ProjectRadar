package paneles;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;

/**
 * Clase con contiene la imagen del panel principal
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class PanelDosInicio extends JFrame{

	//Constante de versión
	private static final long serialVersionUID = 1;

	/**
	 * Constructor de la clase con la configuración del panel
	 */
	public PanelDosInicio(){
		
		//Configuración del panel
		setLayout(new BorderLayout());
	
		try {
			//ContentPane con la imagen a mostrar
			getContentPane().add(new PanelInicio("Radartitle.png"),BorderLayout.CENTER);
		} catch (IOException e) {} 
	}
}
