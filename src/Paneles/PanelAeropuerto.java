package Paneles;


import java.awt.GridLayout;

//import java.awt.FlowLayout;

import javax.swing.JPanel;


import Contenido_Paneles.PermisosAeropuerto;
import Contenido_Paneles.TablalistaAvionesAeropuerto;


public class PanelAeropuerto extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	TablalistaAvionesAeropuerto listaterminal = new TablalistaAvionesAeropuerto();
	PermisosAeropuerto permisosterminal = new PermisosAeropuerto();
	
	
	public PanelAeropuerto() {
		
		setLayout(new GridLayout(1,2));
	
		add(listaterminal);
		add(permisosterminal);
	}
	
	
}

