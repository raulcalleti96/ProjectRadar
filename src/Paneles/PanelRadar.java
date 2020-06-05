package Paneles;

import java.awt.GridLayout;

//import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Contenido_Paneles.PermisosRadar;
import Contenido_Paneles.TablalistaAvionesRadar;


public class PanelRadar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	TablalistaAvionesRadar listaterminal = new TablalistaAvionesRadar();
	PermisosRadar permisosterminal = new PermisosRadar();
	
	JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listaterminal,permisosterminal);
	
	public PanelRadar() {
		
		
		setLayout(new GridLayout(1,2));
	
		add(listaterminal);
		add(permisosterminal);
	}
	
	
}

