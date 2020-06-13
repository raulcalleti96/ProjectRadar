package Contenido_Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.Timer;

public class DireccionViento extends JLabel implements ActionListener{
	private static final long serialVersionUID = 1;
	static int direccion = 0;
	
	public DireccionViento(){
		
		setText("Viento: NORTE ");
		Timer t = new Timer(10000, this);
		

		t.start();

	}


	public void actionPerformed(ActionEvent e) {

		Random generaviento = new Random();
		int direccionG = generaviento.nextInt(4);
			
		switch(direccionG) {
		
			case 0:
				setText("VIENTO: NORTE");
				direccion = 0;
				break;
			
			case 1:
				setText("VIENTO: SUR");
				direccion = 1;
				break;
				
			case 2:
				setText("VIENTO: ESTE");
				direccion = 2;
				break;
				
			case 3:
				setText("VIENTO: OESTE");
				direccion = 3;
				break;
	  }
	}

}
