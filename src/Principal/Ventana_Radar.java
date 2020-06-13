//pruebasraul
package Principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.apple.eawt.Application;

import Paneles.ImagenMapa;
import Paneles.PanelAeropuerto;
import Paneles.PanelDosInicio;
import Paneles.PanelRadar;
import Paneles.RegistroDeTrafico;
import Paneles.Reloj;
import bilbao.Control;
import dialogos.Radio;


public class Ventana_Radar extends JFrame {
	private static final long serialVersionUID = 1L;
	Control listadoAviones = new Control();
	 
 
	// Reloj Y Registro
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

	public Ventana_Radar() {
		
		setLayout(new GridBagLayout());

		info.setDividerSize(2);

		// setIconImage( new ImageIcon(getClass().getResource("pista.png")).getImage());

		restricciones.fill = GridBagConstraints.BOTH;

		restricciones.weightx = 1;
		restricciones.weighty = 1;

		inferior.add("En vuelo", radar);
		inferior.add("En terminal", terminal);

		añadeGrid(mapa, 0, 0);
		añadeGrid(info, 1, 0);
		restricciones.gridwidth = 3;
		añadeGrid(inferior, 0, 1);
		setIconImage(new ImageIcon("icono.png").getImage());
		getContentPane().setBackground(Color.BLACK);
		new Radio();
		
	}

	// Añadir al gridbag
	public void añadeGrid(Component c, int x, int y) {
		restricciones.gridx = x;
		restricciones.gridy = y;

		getContentPane().add(c, restricciones);
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		PanelDosInicio pdi = new PanelDosInicio();
		pdi.setSize(700, 500);
		pdi.setResizable(false);
		pdi.setTitle("PANTALLA DE TITULO");
		pdi.setLocation(200, 100);
		pdi.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pdi.setUndecorated(true);
		pdi.setVisible(true);

		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		pdi.setVisible(false);

		Ventana_Radar ventana = new Ventana_Radar();
		

		// ventana.setResizable(false);
		ventana.setTitle("CONTROL AÉREO");
		ventana.setLocation(250, 100);
		ventana.setSize(1000, 600);

		// Hace la pantalla completa
		// ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Le quita los bordes a la pantalla
		// ventana.setUndecorated(true);

		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
