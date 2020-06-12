package dialogos;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import bilbao.Control;

public class Infoavion extends JDialog{

	private static final long serialVersionUID = 1L;
	
	public Infoavion(Control control){
		
		
		setLayout(new FlowLayout());
		setBounds(340,210,410,210);
        
		//Etiqueta
		JLabel nombre = new JLabel("Avión: " + control.listadoAviones.elementAt(0).getNombre());
		JLabel radio = new JLabel("Radio: " + control.listadoAviones.elementAt(0).pruebaRadio());
		JLabel ruta = new JLabel("Ruta: " + control.listadoAviones.elementAt(0).asignarRuta());
		JLabel motores = new JLabel("Motores: " + control.listadoAviones.elementAt(0).puestaenMarcha());
		JLabel despegue = new JLabel("Despegue: " + control.listadoAviones.elementAt(0).despegue());
		
		nombre.setBounds(115,60,200,30);
		radio.setBounds(115,60,200,30);
		ruta.setBounds(115,60,200,30);
		motores.setBounds(115,60,200,30);
		despegue.setBounds(115,60,200,30);
		add(nombre);
		add(radio);
		add(ruta);
		add(motores);
		add(despegue);

	}

}
