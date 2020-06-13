package dialogos;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import bilbao.Control;

public class InfoavionRadar extends JDialog {

	private static final long serialVersionUID = 1L;
	Control control = new Control();

	public InfoavionRadar(Control control, String matricula) {

		this.control = control;
		setLayout(new FlowLayout());
		setBounds(340, 210, 410, 210);

		seleccion(matricula);
	}

	public void seleccion(String matricula) {
		int indice = 0;

		for (int i = 0; i < control.llegadaAviones.size(); i++) {

			if (matricula.equalsIgnoreCase(control.llegadaAviones.elementAt(i).getNombre())) {
				indice = i;
			}

		}

		// Etiqueta
		JLabel nombre = new JLabel("Avión: " + control.llegadaAviones.elementAt(indice).getNombre());
		JLabel pista = new JLabel("Pista: " + control.llegadaAviones.elementAt(indice).getPista());
		JLabel contacto = new JLabel("Contacto: " + control.llegadaAviones.elementAt(indice).getContacto());
		JLabel rodadura = new JLabel("Rodadura: " + control.llegadaAviones.elementAt(indice).getRodadura());
		JLabel motores = new JLabel("Motores: " + control.llegadaAviones.elementAt(indice).getApagado());

		nombre.setBounds(115, 60, 200, 30);
		pista.setBounds(115, 60, 200, 30);
		contacto.setBounds(115, 60, 200, 30);
		rodadura.setBounds(115, 60, 200, 30);
		motores.setBounds(115, 60, 200, 30);

		add(nombre);
		add(pista);
		add(contacto);
		add(rodadura);
		add(motores);
	
		
	}

}
