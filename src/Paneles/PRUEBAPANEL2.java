package Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class PRUEBAPANEL2 extends JFrame{

	private static final long serialVersionUID = 1;

	public PRUEBAPANEL2(){
		
		setLayout(new BorderLayout());
	
		try {
			getContentPane().add(new PanelInicio("Radartitle.png"),BorderLayout.CENTER);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		getContentPane().setBackground(Color.BLACK);
	}
	public static void main(String []args) {
		PRUEBAPANEL2 ventana = new PRUEBAPANEL2();
		
	
		ventana.setSize(800, 500);
//		ventana.setResizable(false);
			ventana.setTitle("PANTALLA DE TITULO");
			ventana.setLocation(250, 100);
			
		//Hace la pantalla completa
			ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//Le quita los bordes a la pantalla
			//ventana.setUndecorated(true);
			
			ventana.setVisible(true);
			ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
