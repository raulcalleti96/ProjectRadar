package Contenido_Paneles;

import javax.swing.*;

import bilbao.Control;
import dialogos.Cuentaatras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PermisosRadar extends JPanel {

	static final long serialVersionUID = 1;

	JTabbedPane PanelRadar = new JTabbedPane();
	String rutaseleccionada;
	int pistaseleccionada;
	int indice;
	JPanel contacto = new JPanel();
	JPanel asignarodadura = new JPanel();
	JPanel apagadoMotores = new JPanel();
	Control control = null;

	public PermisosRadar(Control control) {
		this.control = control;
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		contacto(seleccionado());
		rodadura(seleccionado());
		apagadoMotores(seleccionado());
		

		// Añadimos los paneles al JTABBED
		PanelRadar.add("CONTACTO", contacto);
		PanelRadar.add("RODADURA", asignarodadura);
		PanelRadar.add("APAGADO MOTORES", apagadoMotores);

		add(PanelRadar, BorderLayout.CENTER);

	}

	public void contacto(int indice) {

		contacto.setBackground(Color.BLACK);
		contacto.setLayout(new FlowLayout());
		JLabel mensajeradio = new JLabel("Buenos días" + " aquí " + control.llegadaAviones.elementAt(indice).getNombre()
				+ " establecido contacto ILS ");
		JCheckBox comprobar = new JCheckBox("AUTORIZAR");
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 = new JLabel();
		mensajeradio.setForeground(Color.white);
		comprobar.setForeground(Color.white);
		mensaje2.setForeground(Color.white);
		JComboBox<Integer> pista = new JComboBox<Integer>();
		pista.addItem(29);
		pista.addItem(11);
		pista.addItem(36);
		pista.addItem(18);

		contacto.add(mensajeradio);
		contacto.add(pista);
		contacto.add(comprobar);
		contacto.add(boton);

		pista.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				pistaseleccionada = (int) pista.getSelectedItem();

			}
		});

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comprobar.isSelected()) {
					control.llegadaAviones.elementAt(indice).setContacto(true);
					control.llegadaAviones.elementAt(indice).setPista(pistaseleccionada);
					System.out.println("3" + control.llegadaAviones.elementAt(indice).getContacto());
					mensaje2.setText(" Recibido " + control.llegadaAviones.elementAt(indice).getNombre() + ".Pista:"
				+ control.llegadaAviones.elementAt(indice).getPista() + " autorizado para aterrizar.");
					contacto.add(mensaje2);
					updateUI();
				}

			}
		});

	}

	// Asigna rodadura
	public void rodadura(int indice) {

		asignarodadura.setBackground(Color.BLACK);
		asignarodadura.setLayout(new FlowLayout());
		JLabel mensaje = new JLabel(
				control.llegadaAviones.elementAt(indice).getNombre() + " solicitamos pista de rodadura. ");
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

		asignarodadura.add(mensaje);
		asignarodadura.add(rodadura);
		asignarodadura.add(boton);
		asignarodadura.add(mensaje2);
		asignarodadura.add(mensajEspera);

		rodadura.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				rutaseleccionada = (String) rodadura.getSelectedItem();

			}
		});

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje2.setForeground(Color.white);
				control.llegadaAviones.elementAt(indice).setRodadura(rutaseleccionada);

				if (control.llegadaAviones.elementAt(indice).getPista() == 18) {

					mensaje2.setText(control.llegadaAviones.elementAt(indice).getNombre()
							+ " recibido. Aterrizaje por el " + " NORTE " + " por rodadura "
							+ control.listadoAviones.elementAt(indice).getRodadura());
					mensajEspera.setText("Tiempo de espera: " + control.llegadaAviones.elementAt(indice).tiempoEspera()
							+ " minuto(s)");

					asignarodadura.add(mensaje2);
					asignarodadura.add(mensajEspera);
					Cuentaatras.nuHora = 0;
					Cuentaatras.nuMin = control.llegadaAviones.elementAt(indice).tiempoEspera();
					Cuentaatras.nuSeg = 0;
					Cuentaatras Temporizador = new Cuentaatras(control);// Crear una Instancia de la clase
					Temporizador.start();// inicializa el hilo
				} else if (control.llegadaAviones.elementAt(indice).getPista() == 35) {

					mensaje2.setText(control.llegadaAviones.elementAt(indice).getNombre()
							+ " recibido. Aterrizaje por el  " + " SUR " + " por rodadura "
							+ control.llegadaAviones.elementAt(indice).getRodadura());
					mensajEspera.setText("Tiempo de espera: " + control.llegadaAviones.elementAt(indice).tiempoEspera()
							+ " minuto(s)");
					asignarodadura.add(mensaje2);
					asignarodadura.add(mensajEspera);
					Cuentaatras.nuHora = 0;
					Cuentaatras.nuMin = control.llegadaAviones.elementAt(indice).tiempoEspera();
					Cuentaatras.nuSeg = 0;
					Cuentaatras Temporizador = new Cuentaatras(control);// Crear una Instancia de la clase
					Temporizador.start();// inicializa el hilo
				} else if (control.llegadaAviones.elementAt(indice).getPista() == 29) {

					mensaje2.setText(control.llegadaAviones.elementAt(indice).getNombre()
							+ "  recibido. Aterrizaje por el  " + " ESTE " + " por rodadura "
							+ control.llegadaAviones.elementAt(indice).getRodadura());
					mensajEspera.setText("Tiempo de espera: " + control.llegadaAviones.elementAt(indice).tiempoEspera()
							+ " minuto(s)");
					asignarodadura.add(mensaje2);
					asignarodadura.add(mensajEspera);

				} else if (control.llegadaAviones.elementAt(indice).getPista() == 11) {

					mensaje2.setText(control.llegadaAviones.elementAt(indice).getNombre()
							+ "  recibido. Aterrizaje por el  " + " OESTE " + " por rodadura "
							+ control.llegadaAviones.elementAt(indice).getRodadura());
					mensajEspera.setText("Tiempo de espera: " + control.llegadaAviones.elementAt(indice).tiempoEspera()
							+ " minuto(s)");
					asignarodadura.add(mensaje2);
					asignarodadura.add(mensajEspera);

				}

			}
		});
	}

	public void apagadoMotores(int indice) {

		apagadoMotores.setBackground(Color.BLACK);
		apagadoMotores.setLayout(new FlowLayout());
		JLabel mensaje = new JLabel();
		JButton boton = new JButton("Enviar");
	
		mensaje.setForeground(Color.white);
		mensaje.setForeground(Color.white);

		apagadoMotores.add(mensaje);
		apagadoMotores.add(boton);
		apagadoMotores.add(mensaje);

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
					mensaje.setText(control.llegadaAviones.elementAt(indice).getNombre()
							+ " apagado de motores. Hasta Pronto");
					// Aquí viene lo gordo
					System.out.println("test");
					control.llegadaAviones.elementAt(0).setDespegar(true);
					control.llegadaAviones.remove(0);

				

			}
		});
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
