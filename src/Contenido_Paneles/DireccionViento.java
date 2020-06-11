package Contenido_Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.Timer;

public class DireccionViento extends JLabel implements ActionListener{
	private static final long serialVersionUID = 1;
	
	public DireccionViento(){
		
		setText(" VIENTO: NORTE");
	
		Timer t = new Timer(6000, this);
		t.start();

	}


	public void actionPerformed(ActionEvent e) {

		Random generaviento = new Random();
		int direccion = generaviento.nextInt(4);
			
		switch(direccion) {
		
			case 0:
				setText(" VIENTO: NORTE");
				break;
			
			case 1:
				setText(" VIENTO: SUR");
				break;
				
			case 2:
				setText(" VIENTO: ESTE");
				break;
				
			case 3:
				setText(" VIENTO: OESTE");
				break;
	  }
	}

}
