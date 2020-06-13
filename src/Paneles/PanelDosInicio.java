package Paneles;


import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

public class PanelDosInicio extends JFrame{

	private static final long serialVersionUID = 1;

	public PanelDosInicio(){
		
		setLayout(new BorderLayout());
	
		try {
			getContentPane().add(new PanelInicio("Radartitle.png"),BorderLayout.CENTER);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		getContentPane().setBackground(Color.BLACK);
	}
	
	
}
