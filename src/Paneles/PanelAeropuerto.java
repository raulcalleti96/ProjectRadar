package Paneles;


import java.awt.GridLayout;

//import java.awt.FlowLayout;

import javax.swing.JPanel;

import Contenido_Paneles.PermisosAeropuerto;
import Contenido_Paneles.TablalistaAvionesAeropuerto;
import bilbao.Control;



public class PanelAeropuerto extends JPanel  {
	
	private static final long serialVersionUID = 1L;
	Control listadoAviones = new Control();
	
	TablalistaAvionesAeropuerto listaterminal = new TablalistaAvionesAeropuerto(listadoAviones);
	PermisosAeropuerto permisosterminal = new PermisosAeropuerto(listadoAviones, listaterminal);

	
	public PanelAeropuerto(Control listadoAviones) {
		
		this.listadoAviones = listadoAviones;

		setLayout(new GridLayout(1,2));
		
	
		add(listaterminal);
		add(permisosterminal);
	
				
				
		
	}



	
	
	
}


