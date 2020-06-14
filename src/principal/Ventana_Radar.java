package principal;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import bilbao.Control;
import dialogos.Radio;
import paneles.ImagenMapa;
import paneles.PanelAeropuerto;
import paneles.PanelDosInicio;
import paneles.PanelRadar;
import paneles.RegistroDeTrafico;
import paneles.Reloj;

/**
 * Clase interna que contiene el panel principal
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class Ventana_Radar extends JFrame {
	
	// Constante de Versión
	private static final long serialVersionUID = 1L;
	
	//Objeto de la clase <Control>
	Control listadoAviones = new Control();
	 
 
	// Objetos de Reloj Y Registro
	Reloj reloj = new Reloj();
	RegistroDeTrafico rt = new RegistroDeTrafico();
	JSplitPane info = new JSplitPane(JSplitPane.VERTICAL_SPLIT, reloj, rt);

	// Componentes del panel inferior

	PanelRadar radar = new PanelRadar(listadoAviones);
	PanelAeropuerto terminal = new PanelAeropuerto(listadoAviones);

	// Componentes del GIU
	JTabbedPane inferior = new JTabbedPane();
	ImagenMapa mapa = new ImagenMapa();

	// Restricciones del gridbag
	GridBagConstraints restricciones = new GridBagConstraints();

	/**
	 * Constructor de la clase que definirá el panel
	 */
	public Ventana_Radar() {
		
		//Configuración del panel
		setLayout(new GridBagLayout());
		info.setDividerSize(2);
		restricciones.fill = GridBagConstraints.BOTH;
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		
		//Añade los paneles al panel de pestañas
		inferior.add("En vuelo", radar);
		inferior.add("En terminal", terminal);

		//Layout que permite colocar los componentes de manera matricial
		añadeGrid(mapa, 0, 0);
		añadeGrid(info, 1, 0);
		restricciones.gridwidth = 3;
		añadeGrid(inferior, 0, 1);
		getContentPane().setBackground(Color.BLACK);
		
		//Objeto que reproducirá la radio de la torre de control
		new Radio();
		
	}

	public void añadeGrid(Component c, int x, int y) {
		restricciones.gridx = x;
		restricciones.gridy = y;

		getContentPane().add(c, restricciones);
	}

	public static void main(String[] args) {

		try {
			//Forma de los componentes modificial, instanciados con MotifLookandFeel. Contiene las barras y formas de los componentes
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Instancia el panel inical 
		PanelDosInicio pdi = new PanelDosInicio();
		
		//Configuración del panel inicial
		pdi.setSize(700, 500);
		pdi.setResizable(false);
		pdi.setTitle("PANTALLA DE TITULO");
		pdi.setLocation(200, 100);
		pdi.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pdi.setUndecorated(true);
		pdi.setVisible(true);

		try {
			//Deteniene el programa unos segundos
			Thread.sleep(4500);
		} catch (InterruptedException e) {
		}

		//Hace visible el panel inicial
		pdi.setVisible(false);

		//Instancia un objeto con que contiene le panel principal
		Ventana_Radar ventana = new Ventana_Radar();
		
		//Configuración de la ventana principal
		ventana.setTitle("CONTROL AÉREO");
		ventana.setLocation(250, 100);
		ventana.setSize(1000, 600);
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		ventana.setUndecorated(true);

		//Hace visible la ventana
		ventana.setVisible(true);
		
		//Termina el programa en caso de cerrar
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
