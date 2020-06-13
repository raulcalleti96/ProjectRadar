package dialogos;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import bilbao.Control;

public class InfoavionTerminal extends JDialog {

	private static final long serialVersionUID = 1L;
	Control control = new Control();

	public InfoavionTerminal(Control control, String matricula) {

		this.control = control;
		setLayout(new FlowLayout());
		setBounds(340, 210, 410, 210);

		seleccion(matricula);
	}

	public void seleccion(String matricula) {
		int indice = 0;

		for (int i = 0; i < control.listadoAviones.size(); i++) {

			if (matricula.equalsIgnoreCase(control.listadoAviones.elementAt(i).getNombre())) {
				indice = i;
			}

		}

		// Etiqueta
		JLabel nombre = new JLabel("Avión: " + control.listadoAviones.elementAt(indice).getNombre());
		JLabel radio = new JLabel("Radio: " + control.listadoAviones.elementAt(indice).pruebaRadio());
		JLabel ruta = new JLabel("Pista: " + control.listadoAviones.elementAt(indice).getPista());
		JLabel motores = new JLabel("Rodadura: " + control.listadoAviones.elementAt(indice).getRodadura());
		JLabel despegue = new JLabel("Despegue: " + control.listadoAviones.elementAt(indice).despegue());

		nombre.setBounds(115, 60, 200, 30);
		radio.setBounds(115, 60, 200, 30);
		ruta.setBounds(115, 60, 200, 30);
		motores.setBounds(115, 60, 200, 30);
		despegue.setBounds(115, 60, 200, 30);
		add(nombre);
		add(radio);
		add(ruta);
		add(motores);
		add(despegue);
		
	}

}
