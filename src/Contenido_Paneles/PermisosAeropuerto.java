package Contenido_Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import bilbao.Control;

public class PermisosAeropuerto extends JPanel {

	static final long serialVersionUID = 1;

	JTabbedPane PanelTerminal = new JTabbedPane();

	String rutaseleccionada;
	int pistaseleccionada;
	int indice;
	JPanel pruebaradio = new JPanel();
	JPanel asignaruta = new JPanel();
	JPanel puestaenmarcha = new JPanel();
	JPanel despegue = new JPanel();
	Control control = null;

	public PermisosAeropuerto(Control control) {

		this.control = control;
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);

		
		//Color a los demás paneles para distinguirlos
		pruebaradio.setBackground(Color.BLACK);
		asignaruta.setBackground(Color.BLUE);
		puestaenmarcha.setBackground(Color.CYAN);
		despegue.setBackground(Color.RED);
		
		//Layout a null para poder añadir los paneles
		pruebaradio.setLayout(null);
		asignaruta.setLayout(null);
		puestaenmarcha.setLayout(null);
		despegue.setLayout(null);
		
		//Tamaño de los paneles
		
		
		
		
		//Añadimos los paneles al JTABBED
		PanelTerminal.add("<html><strong>RADIO</strong></html>", pruebaradio);
		PanelTerminal.add("<html><strong>ASIGNAR PISTA</strong></html>", asignaruta);
		PanelTerminal.add("<html><strong>ARRANQUE MOTORES</strong></html>", puestaenmarcha);
		PanelTerminal.add("<html><strong>DESPEGUE</strong></html>", despegue);


		// Paneles
		radio(seleccionado());
		ruta(seleccionado());
		motores(seleccionado());
		despegue(seleccionado());

		// Añadimos los paneles al JTABBED

		PanelTerminal.add("RADIO", pruebaradio);
		PanelTerminal.add("ASIGNAR PISTA", asignaruta);
		PanelTerminal.add("ARRANQUE MOTORES", puestaenmarcha);
		PanelTerminal.add("DESPEGUE", despegue);

		add(PanelTerminal, BorderLayout.CENTER);

	}

	public void radio(int indice) {

		pruebaradio.setBackground(Color.BLACK);
		pruebaradio.setLayout(new FlowLayout());
		JLabel mensajeradio = new JLabel("Buenos días. Prueba para colocar todo en radio del avion "
				+ control.listadoAviones.elementAt(indice).getNombre());
		JCheckBox comprobar = new JCheckBox("Se escucha correctamente");
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 = new JLabel("Recibido. Prueba para colocar todo en radio.");
		mensajeradio.setForeground(Color.white);
		comprobar.setForeground(Color.white);
		mensaje2.setForeground(Color.white);

		pruebaradio.add(mensajeradio);
		pruebaradio.add(comprobar);
		pruebaradio.add(boton);

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comprobar.isSelected()) {
					control.listadoAviones.elementAt(indice).setRadio(true);

					System.out.println("3" + control.listadoAviones.elementAt(indice).getRadio());
					pruebaradio.add(mensaje2);
					updateUI();
				}

			}
		});

	}

	public void ruta(int indice) {

		asignaruta.setBackground(Color.BLACK);
		asignaruta.setLayout(new FlowLayout());
		JLabel mensaje = new JLabel(control.listadoAviones.elementAt(indice).getNombre()
				+ " solicitamos plan de vuelo para " + control.listadoAviones.elementAt(indice).getDestino());
		JLabel mensaje2 = new JLabel();
		JComboBox<Integer> pista = new JComboBox<Integer>();
		pista.addItem(29);
		pista.addItem(11);
		pista.addItem(36);
		pista.addItem(18);

		JButton boton = new JButton("Enviar");

		mensaje.setForeground(Color.white);

		asignaruta.add(mensaje);
		asignaruta.add(pista);
		asignaruta.add(boton);

		pista.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				pistaseleccionada = (int) pista.getSelectedItem();
				
			}
		});

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje2.setForeground(Color.white);
				control.listadoAviones.elementAt(indice).setPista(pistaseleccionada);
				mensaje2.setText(control.listadoAviones.elementAt(indice).getNombre() + " autorizado para "
				+ control.listadoAviones.elementAt(indice).getDestino() + ".Plan de vuelo. Pista "
				+ control.listadoAviones.elementAt(indice).getPista());
				asignaruta.add(mensaje2);
				updateUI();

			}
		});

	}

	
	
	
	public void motores(int indice) {

		puestaenmarcha.setBackground(Color.BLACK);
		puestaenmarcha.setLayout(new FlowLayout());
		JLabel mensaje = new JLabel(control.listadoAviones.elementAt(indice).getNombre() + " listos para puesta en marcha y retroceso.");
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 = new JLabel();
		JLabel mensajEspera = new JLabel();
		JComboBox<String> rodadura = new JComboBox<String>();
		rodadura.addItem("E2");
		rodadura.addItem("Y2");
		rodadura.addItem("A1");
		rodadura.addItem("C2");

		mensaje.setForeground(Color.white);
		mensaje2.setForeground(Color.white);
		mensajEspera.setForeground(Color.WHITE);

		puestaenmarcha.add(mensaje);
		puestaenmarcha.add(rodadura);
		puestaenmarcha.add(boton);
		puestaenmarcha.add(mensaje2);
		puestaenmarcha.add(mensajEspera);

		
		
		rodadura.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				rutaseleccionada = (String) rodadura.getSelectedItem();
				
			}
		});
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje2.setForeground(Color.white);
				control.listadoAviones.elementAt(indice).setRodadura(rutaseleccionada);
		
				
				if(control.listadoAviones.elementAt(indice).getPista() == 18) {
				
					mensaje2.setText(control.listadoAviones.elementAt(indice).getNombre() + " puesta en marcha y retroceso aprobado al "
							+ " NORTE " + " por rodadura "
							+ control.listadoAviones.elementAt(indice).getRodadura());
					mensajEspera.setText("Tiempo de espera: "+ control.listadoAviones.elementAt(indice).tiempoEspera()+ " minuto(s)");
					
					puestaenmarcha.add(mensaje2);
					puestaenmarcha.add(mensajEspera);
				
				}else if(control.listadoAviones.elementAt(indice).getPista() == 35){
					
					mensaje2.setText(control.listadoAviones.elementAt(indice).getNombre() + " puesta en marcha y retroceso aprobado al "
							+ " SUR " + " por rodadura "
							+ control.listadoAviones.elementAt(indice).getRodadura());
					mensajEspera.setText("Tiempo de espera: "+ control.listadoAviones.elementAt(indice).tiempoEspera()+ " minuto(s)");
					puestaenmarcha.add(mensaje2);
					puestaenmarcha.add(mensajEspera);
					
				}else if(control.listadoAviones.elementAt(indice).getPista() == 29){
					
					mensaje2.setText(control.listadoAviones.elementAt(indice).getNombre() + " puesta en marcha y retroceso aprobado al "
							+ " ESTE " + " por rodadura "
							+ control.listadoAviones.elementAt(indice).getRodadura());
					mensajEspera.setText("Tiempo de espera: "+ control.listadoAviones.elementAt(indice).tiempoEspera() + " minuto(s)");
					puestaenmarcha.add(mensaje2);
					puestaenmarcha.add(mensajEspera);
					
				}else if(control.listadoAviones.elementAt(indice).getPista() == 11){
					
					mensaje2.setText(control.listadoAviones.elementAt(indice).getNombre() + " puesta en marcha y retroceso aprobado al "
							+ " OESTE " + " por rodadura "
							+ control.listadoAviones.elementAt(indice).getRodadura() );
					mensajEspera.setText("Tiempo de espera: "+ control.listadoAviones.elementAt(indice).tiempoEspera()+ " minuto(s)");
					puestaenmarcha.add(mensaje2);
					puestaenmarcha.add(mensajEspera);
					
				}
				
				
				

			}
		});
	}

	
	
	public void despegue(int indice) {

		despegue.setBackground(Color.BLACK);
		despegue.setLayout(new FlowLayout());
		JLabel mensaje = new JLabel("Buenos días. Prueba para colocar todo en despegue.");
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 = new JLabel("Recibido. Prueba para colocar todo en motores.");
		mensaje.setForeground(Color.white);

		mensaje2.setForeground(Color.white);

		despegue.add(mensaje);
		despegue.add(boton);
		despegue.add(mensaje2);
		
	}

	public int seleccionado() {

		for (int i = 0; i < control.listadoAviones.size(); i++) {

			if (control.listadoAviones.elementAt(i).getSeleccion() == true) {

				return i;

			}
		}
		return 0;
	}


}
