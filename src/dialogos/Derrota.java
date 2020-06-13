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

public class Derrota extends JDialog {

	private static final long serialVersionUID = 1L;

	public Derrota() {

		
		setLayout(new FlowLayout());
		setBounds(340, 210, 410, 210);
		seleccion();
	}

	public void seleccion() {
		
	
		// Etiqueta
		JLabel derrota = new JLabel("¡HA PERDIDO!. Le dejamos el manual aqui");
		JButton manual = new JButton("Manual de usuario");
		JButton salir = new JButton("SALIR");

		
		derrota.setBounds(115, 60, 200, 30);
		manual.setBounds(115, 60, 200, 30);
		salir.setBounds(115, 60, 200, 30);
		

		add(derrota);
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
