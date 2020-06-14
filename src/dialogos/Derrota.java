package dialogos;


import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * Clase que proporciona una ventana de dialogo informando de la derrota
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */

public class Derrota extends JDialog {

	// Constante de versión
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase albergando las configuraciones del JDialog
	 */
	public Derrota() {

		//Configuración del JDialog
		setLayout(new FlowLayout());
		setBounds(540, 210, 310, 110);
		setUndecorated(true); //No muestra el marco con bordes
		setModal(true); //Bloquea el resto, solo es posible acceder al dialogo
		
		//Método para mostrar la información de la ventana
		seleccion();
	}
 
	/**
	 * Método para mostrar la información de la ventana de dialogo
	 */
	public void seleccion() {
		
	
		// Instanciación botones y etiquetas
		JLabel derrota = new JLabel("¡HA PERDIDO!. Le dejamos el manual aqui");
		JButton manual = new JButton("Manual de usuario");
		JButton salir = new JButton("SALIR");

		//Configuración de los paneles y botones
		derrota.setBounds(115, 60, 200, 30);
		manual.setBounds(115, 60, 200, 30);
		salir.setBounds(115, 60, 200, 30);
		
		//Asigna al panel los elementos
		add(derrota);
		add(manual);
		add(salir);
		

		//ActionListener para cuando pulse el botón del manual
		manual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				try {
					//Abre un fichero con el manual de usuario
					Desktop.getDesktop().open(new File("Manual_de_Usuario.pdf"));
				} catch (IOException e1) {}

			}
		});
		
		//ActionListener para cuando pulse el botón de salir
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				//Se cierra el programa
				System.exit(0);
			}
		});
	}
	

}
