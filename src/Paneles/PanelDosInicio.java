package Paneles;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class PanelDosInicio extends JFrame{

	private static final long serialVersionUID = 1;

	public PanelDosInicio(){
		
		setLayout(new BorderLayout());
	
		try {
			getContentPane().add(new PanelInicio("Radartitle.png"),FlowLayout.CENTER);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
}
