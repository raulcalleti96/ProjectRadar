package Principal;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import Paneles.ImagenMapa;
import Paneles.PanelAeropuerto;
import Paneles.PanelRadar;
import Paneles.RegistroDeTrafico;
import Paneles.Reloj;

public class Ventana_Radar extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//Reloj
	Reloj reloj = new Reloj();

	//Componentes del panel inferior
	PanelRadar radar = new PanelRadar();
	PanelAeropuerto terminal = new PanelAeropuerto();
	
	//Componentes del GIU
	JTabbedPane inferior = new JTabbedPane();
	ImagenMapa mapa = new ImagenMapa();
	RegistroDeTrafico rt = new RegistroDeTrafico();
	
	//Restricciones del gridbag
	GridBagConstraints restricciones = new GridBagConstraints();
	
	public Ventana_Radar() {
		
		setLayout(new GridBagLayout());
		
		

		
		restricciones.fill = GridBagConstraints.BOTH;
		
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		
		
		inferior.add("En vuelo",radar);
		inferior.add("En terminal",terminal);
		
		restricciones.gridheight = 2;
		restricciones.gridwidth = 3;
		añadeGrid(mapa, 0, 0);
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		añadeGrid(rt, 3, 0);
		añadeGrid(reloj,3 , 1);
	
		restricciones.gridwidth = 4;
		añadeGrid(inferior, 0, 2);
		
		//getContentPane().setBackground(Color.BLACK);
		
	}
	
	//Añadir al gridbag
	public void añadeGrid(Component c, int x,int y) {
		restricciones.gridx = x;
		restricciones.gridy = y;
		
		getContentPane().add(c,restricciones);
	}
	
	
	
	
	public static void main(String[]args) {
		
		Ventana_Radar ventana = new Ventana_Radar();
		
		ventana.setLocation(250, 100);
		ventana.setSize(900, 600);
		
		//Hace la pantalla completa
	//	ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//Le quita los bordes a la pantalla
		//ventana.setUndecorated(true);
		
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	
}
