package Contenido_Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import bilbao.Avion;
import bilbao.Control;
import dialogos.Derrota;

public class PermisosRadar extends JPanel {

	static final long serialVersionUID = 1;

	JTabbedPane PanelRadar = new JTabbedPane();
	String rutaseleccionada;
	int pistaseleccionada;
	JPanel contacto = new JPanel();
	JPanel asignarodadura = new JPanel();
	JPanel apagadoMotores = new JPanel();
	Control control = null;
	TablalistaAvionesRadar listaterminal = null;

	Calendar calendario = new GregorianCalendar();

	public PermisosRadar(Control control, TablalistaAvionesRadar listaterminal) {

		this.listaterminal = listaterminal;
		this.control = control;
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);

		contacto();
		rodadura();
		apagadoMotores();

		// Añadimos los paneles al JTABBED
		PanelRadar.add("CONTACTO", contacto);
		PanelRadar.add("RODADURA", asignarodadura);
		PanelRadar.add("APAGADO MOTORES", apagadoMotores);
		PanelRadar.setEnabledAt(2, false);
		add(PanelRadar, BorderLayout.CENTER);

	}

	public void contacto() {

		try {
			contacto.setBackground(Color.BLACK);
			contacto.setLayout(new FlowLayout());

			JLabel mensajeradio = new JLabel("Hola." + " aquí " + control.llegadaAviones.elementAt(0).getNombre()
					+ " establecido contacto ILS ");

			JCheckBox comprobar = new JCheckBox("AUTORIZAR");
			JButton boton = new JButton("Enviar");
			JLabel mensaje2 = new JLabel();
			mensajeradio.setForeground(Color.white);
			comprobar.setForeground(Color.white);
			mensaje2.setForeground(Color.white);
			JComboBox<Integer> pista = new JComboBox<Integer>();
			pista.addItem(0);
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
						control.llegadaAviones.elementAt(0).setContacto(true);
						control.llegadaAviones.elementAt(0).setPista(pistaseleccionada);
						System.out.println("3" + control.llegadaAviones.elementAt(0).getContacto());
						mensaje2.setText(" Recibido " + control.llegadaAviones.elementAt(0).getNombre() + ".Pista:"
								+ control.llegadaAviones.elementAt(0).getPista() + " autorizado para aterrizar.");
						contacto.add(mensaje2);

						compruebaviento(control.llegadaAviones.elementAt(0));

						updateUI();
					}

				}
			});
		} catch (ArrayIndexOutOfBoundsException e) {
			PanelRadar.setEnabledAt(0, false);
			PanelRadar.setEnabledAt(1, false);
			PanelRadar.setEnabledAt(2, false);
			Control.llegadaVacio = true;
			System.out.println(Control.listadoVacio + " " + Control.llegadaVacio);
			control.compruebalista();

		}
	}

	// Asigna rodadura
	public void rodadura() {

		try {
			asignarodadura.setBackground(Color.BLACK);
			asignarodadura.setLayout(new FlowLayout());
			JLabel mensaje = new JLabel(
					control.llegadaAviones.elementAt(0).getNombre() + " solicitamos pista de rodadura. ");
			JButton boton = new JButton("Enviar");
			JLabel mensaje2 = new JLabel();

			JComboBox<String> rodadura = new JComboBox<String>();
			rodadura.addItem(" ");
			rodadura.addItem("E2");
			rodadura.addItem("Y2");
			rodadura.addItem("A1");
			rodadura.addItem("C2");

			mensaje.setForeground(Color.white);
			mensaje2.setForeground(Color.white);

			asignarodadura.add(mensaje);
			asignarodadura.add(rodadura);
			asignarodadura.add(boton);
			asignarodadura.add(mensaje2);

			rodadura.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					rutaseleccionada = (String) rodadura.getSelectedItem();

				}
			});

			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mensaje2.setForeground(Color.white);
					control.llegadaAviones.elementAt(0).setRodadura(rutaseleccionada);

					if (control.llegadaAviones.elementAt(0).getPista() == 18) {

						mensaje2.setText(control.llegadaAviones.elementAt(0).getNombre()
								+ " recibido. Aterrizaje por el " + " NORTE " + " por rodadura "
								+ control.llegadaAviones.elementAt(0).getRodadura());

						asignarodadura.add(mensaje2);

						PanelRadar.setEnabledAt(2, true);
					} else if (control.llegadaAviones.elementAt(0).getPista() == 36) {

						mensaje2.setText(control.llegadaAviones.elementAt(0).getNombre()
								+ " recibido. Aterrizaje por el  " + " SUR " + " por rodadura "
								+ control.llegadaAviones.elementAt(0).getRodadura());

						asignarodadura.add(mensaje2);

						PanelRadar.setEnabledAt(2, true);
					} else if (control.llegadaAviones.elementAt(0).getPista() == 29) {

						mensaje2.setText(control.llegadaAviones.elementAt(0).getNombre()
								+ "  recibido. Aterrizaje por el  " + " ESTE " + " por rodadura "
								+ control.llegadaAviones.elementAt(0).getRodadura());

						asignarodadura.add(mensaje2);

						PanelRadar.setEnabledAt(2, true);
					} else if (control.llegadaAviones.elementAt(0).getPista() == 11) {

						mensaje2.setText(control.llegadaAviones.elementAt(0).getNombre()
								+ "  recibido. Aterrizaje por el  " + " OESTE " + " por rodadura "
								+ control.llegadaAviones.elementAt(0).getRodadura());

						asignarodadura.add(mensaje2);

						PanelRadar.setEnabledAt(2, true);
					}

				}
			});
		} catch (ArrayIndexOutOfBoundsException e) {
			PanelRadar.setEnabledAt(0, false);
			PanelRadar.setEnabledAt(1, false);
			PanelRadar.setEnabledAt(2, false);
			Control.llegadaVacio = true;
			System.out.println(Control.listadoVacio + " " + Control.llegadaVacio);
			control.compruebalista();

		}
	}

	public void apagadoMotores() {

		try {
			apagadoMotores.setBackground(Color.BLACK);
			apagadoMotores.setLayout(new FlowLayout());
			JLabel mensaje = new JLabel(
					control.llegadaAviones.elementAt(0).getNombre() + " apagado de motores. Hasta Pronto");
			JButton boton = new JButton("Estacionado");

			mensaje.setForeground(Color.white);
			mensaje.setForeground(Color.white);

			apagadoMotores.add(mensaje);
			apagadoMotores.add(boton);

			int hora = calendario.get(Calendar.HOUR_OF_DAY);
			int minutos = calendario.get(Calendar.MINUTE);
			int segundos = calendario.get(Calendar.SECOND);
			String horaDespegue = hora + ":" + minutos + ":" + segundos;
			control.llegadaAviones.elementAt(0).setHoraDespegue(horaDespegue);

			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					control.llegadaAviones.elementAt(0).setApagado(true);
					escribeRegistro();
					control.llegadaAviones.remove(0);
					listaterminal.model.removeRow(0);
					actualiza();

				}
			});
		} catch (ArrayIndexOutOfBoundsException e) {
			PanelRadar.setEnabledAt(0, false);
			PanelRadar.setEnabledAt(1, false);
			PanelRadar.setEnabledAt(2, false);
			Control.llegadaVacio = true;
			System.out.println(Control.listadoVacio + " " + Control.llegadaVacio);
			control.compruebalista();

		}
	}

	public int seleccionado() {

		for (int i = 0; i < control.llegadaAviones.size(); i++) {

			if (control.llegadaAviones.elementAt(i).getSeleccion() == true) {

				return i;

			}
		}
		return 0;
	}

	public void actualiza() {

		contacto.removeAll();
		contacto();
		asignarodadura.removeAll();

		rodadura();
		apagadoMotores.removeAll();
		apagadoMotores();
		PanelRadar.setEnabledAt(2, false);
		updateUI();

	}

	public void compruebaviento(Avion avion) {
		Derrota derrota;
		if (DireccionViento.direccion == 0 && avion.getPista() != 36) {

			derrota = new Derrota();
			derrota.setVisible(true);

		} else if (DireccionViento.direccion == 1 && avion.getPista() != 18) {

			derrota = new Derrota();
			derrota.setVisible(true);

		} else if (DireccionViento.direccion == 2 && avion.getPista() != 11) {

			derrota = new Derrota();
			derrota.setVisible(true);

		} else if (DireccionViento.direccion == 3 && avion.getPista() != 29) {

			derrota = new Derrota();
			derrota.setVisible(true);

		}
	}

	public void escribeRegistro() {

		BufferedWriter bw = null;
		try {
			File fichero = new File("./registro/registro.txt");

			bw = new BufferedWriter(new FileWriter(fichero, true));
			bw.write("\n" + control.llegadaAviones.elementAt(0).infoAvionDesText() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close(); // Cerramos el buffer
			} catch (Exception e) {
			}
		}
	}

}
