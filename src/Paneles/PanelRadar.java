package Paneles;

import java.awt.GridLayout;

//import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Contenido_Paneles.PermisosRadar;
import Contenido_Paneles.TablalistaAvionesRadar;
import bilbao.Control;



public class PanelRadar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Control listadoAviones = new Control();
	
	TablalistaAvionesRadar listaterminal = new TablalistaAvionesRadar(listadoAviones);
	PermisosRadar permisosterminal = new PermisosRadar(listadoAviones, listaterminal);
	
	JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listaterminal,permisosterminal);
	
	public PanelRadar(Control listadoAviones) {
		
		this.listadoAviones = listadoAviones;
		setLayout(new GridLayout(1,2));
	
		add(listaterminal);
		add(permisosterminal);
	}
	
	
}

