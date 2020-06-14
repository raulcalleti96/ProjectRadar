package contenido_Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Proporciona el viento que se modifica cada 10 segundos
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */

public class DireccionViento extends JLabel implements ActionListener {

	// Variables y constantes
	private static final long serialVersionUID = 1;
	static int direccion = 1;

	/**
	 * Constructor añade un objeto Timer a la clase
	 */
	public DireccionViento() {

		setText("Viento: SUR ");
		Timer t = new Timer(10000, this);

		t.start();

	}// Se cierra constructor

	/**
	 * Método que necesita el Timer para modificar el viento de forma aleatorio cada
	 * 10 segundos
	 */
	public void actionPerformed(ActionEvent e) {

		// Instanciación clase y variables
		Random generaviento = new Random();
		int direccionG = generaviento.nextInt(4);

		// Bucle Switch pasando como parámetro  el valor aleatorio y asigna una nueva dirección
		switch (direccionG) {
	
			case 0:
				setText("VIENTO: NORTE");
				direccion = 0;
				break;
	
			case 1:
				setText("VIENTO: SUR");
				direccion = 1;
				break;
	
			case 2:
				setText("VIENTO: ESTE");
				direccion = 2;
				break;
	
			case 3:
				setText("VIENTO: OESTE");
				direccion = 3;
				break;
			}
	}//Cierre del método

}//Cierre del programa
