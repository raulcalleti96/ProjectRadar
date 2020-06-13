package dialogos;


import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Victoria extends JDialog {

	private static final long serialVersionUID = 1L;

	public Victoria() {

		
		setLayout(new FlowLayout());
		setBounds(340, 210, 410, 210);
		seleccion();
	}

	public void seleccion() {
		
	
		// Etiqueta
		JLabel victoria1 = new JLabel("¡Enhorabuena!. Ha aterrizado y despegado todo");
		JLabel victoria2 = new JLabel("Le dejamos el manual de nuevo");
		JButton manual = new JButton("Manual de usuario");
		JButton salir = new JButton("SALIR");

		
		victoria1.setBounds(115, 60, 200, 30);
		victoria2.setBounds(115, 60, 200, 30);
		manual.setBounds(115, 60, 200, 30);
		salir.setBounds(115, 60, 200, 30);
		

		add(victoria1);
		add(victoria2);
		add(manual);
		add(salir);
		

		manual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				try {
					Desktop.getDesktop().open(new File("U12_GestiónBDrelacionales.pdf"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				System.exit(0);
			}
		});
	}
	

}
