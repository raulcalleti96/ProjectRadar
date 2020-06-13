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
	
	TablalistaAvionesAeropuerto listaterminal = null;

	JLabel mensajeradio = new JLabel();
	JLabel mensajeruta = new JLabel();
	JLabel mensajerecibidoruta = new JLabel();
	JLabel mensajemarcha = new JLabel();
	JLabel mensajerecibidomarcha = new JLabel();
	Calendar calendario = new GregorianCalendar();

	public PermisosAeropuerto(Control control, TablalistaAvionesAeropuerto listaterminal) {

		this.listaterminal = listaterminal;
		this.control = control;
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);

		// Paneles
		radio();
		ruta();
		motores();
		despegue();

		// Añadimos los paneles al JTABBED

		PanelTerminal.add("RADIO", pruebaradio);
		PanelTerminal.add("ASIGNAR PISTA", asignaruta);
		PanelTerminal.add("ARRANQUE MOTORES", puestaenmarcha);
		PanelTerminal.add("DESPEGUE", despegue);
		PanelTerminal.setEnabledAt(3, false);
		add(PanelTerminal, BorderLayout.CENTER);

	}

	public void radio() {

		pruebaradio.setBackground(Color.BLACK);
		pruebaradio.setLayout(new FlowLayout());
		mensajeradio.setText("Hola. Prueba de radio de " + control.listadoAviones.elementAt(0).getNombre());
		JCheckBox comprobar = new JCheckBox("Se escucha correctamente");
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 = new JLabel(
				"Recibido." + control.listadoAviones.elementAt(0).getNombre() + " le recibio correctamente.");
		mensajeradio.setForeground(Color.white);
		comprobar.setForeground(Color.white);
		mensaje2.setForeground(Color.white);

		pruebaradio.add(mensajeradio);
		pruebaradio.add(comprobar);
		pruebaradio.add(boton);

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comprobar.isSelected()) {
					control.listadoAviones.elementAt(0).setRadio(true);
					// System.out.println("3" + control.listadoAviones.elementAt(0).getRadio());
					pruebaradio.add(mensaje2);

				}

			}
		});

	}

	public void ruta() {

		asignaruta.setBackground(Color.BLACK);
		asignaruta.setLayout(new FlowLayout());
		mensajeruta.setText(control.listadoAviones.elementAt(0).getNombre() + " solicitamos plan de vuelo para "
				+ control.listadoAviones.elementAt(0).getDestino());

		JComboBox<Integer> pista = new JComboBox<Integer>();
		pista.addItem(29);
		pista.addItem(11);
		pista.addItem(35);
		pista.addItem(18);

		JButton boton = new JButton("Enviar");

		mensajeruta.setForeground(Color.white);

		asignaruta.add(mensajeruta);
		asignaruta.add(pista);
		asignaruta.add(boton);

		pista.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				pistaseleccionada = (int) pista.getSelectedItem();

			}
		});

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajerecibidoruta.setForeground(Color.white);
				control.listadoAviones.elementAt(0).setPista(pistaseleccionada);	
				mensajerecibidoruta.setText(control.listadoAviones.elementAt(0).getNombre() + " autorizado para "
						+ control.listadoAviones.elementAt(0).getDestino() + ".Plan de vuelo. Pista "
						+ control.listadoAviones.elementAt(0).getPista());
				asignaruta.add(mensajerecibidoruta);
				compruebaviento(control.llegadaAviones.elementAt(0));
				updateUI();

			}
		});

	}

	public void motores() {

		puestaenmarcha.setBackground(Color.BLACK);
		puestaenmarcha.setLayout(new FlowLayout());
		mensajemarcha.setText(
				control.listadoAviones.elementAt(0).getNombre() + " listos para puesta en marcha y retroceso.");
		JButton boton = new JButton("Enviar");
		JLabel mensajerecibidomarcha = new JLabel();

		JComboBox<String> rodadura = new JComboBox<String>();
		rodadura.addItem("E2");
		rodadura.addItem("Y2");
		rodadura.addItem("A1");
		rodadura.addItem("C2");

		mensajemarcha.setForeground(Color.white);
		mensajerecibidomarcha.setForeground(Color.white);

		puestaenmarcha.add(mensajemarcha);
		puestaenmarcha.add(rodadura);
		puestaenmarcha.add(boton);
		puestaenmarcha.add(mensajerecibidomarcha);

		rodadura.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				rutaseleccionada = (String) rodadura.getSelectedItem();

			}
		});

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajerecibidomarcha.setForeground(Color.white);
				control.listadoAviones.elementAt(0).setRodadura(rutaseleccionada);

				if (control.listadoAviones.elementAt(0).getPista() == 18) {

					mensajerecibidomarcha.setText(control.listadoAviones.elementAt(0).getNombre()
							+ " puesta en marcha y retroceso aprobado al " + " NORTE " + " por rodadura "
							+ control.listadoAviones.elementAt(0).getRodadura());

					puestaenmarcha.add(mensajerecibidomarcha);

					/*
					 * Cuentaatras.nuHora = 0; Cuentaatras.nuMin =
					 * control.listadoAviones.elementAt(0).tiempoEspera(); Cuentaatras.nuSeg = 0;
					 * Temporizador.start();// inicializa el hilo
					 */
					PanelTerminal.setEnabledAt(3, true);
				} else if (control.listadoAviones.elementAt(0).getPista() == 35) {

					mensajerecibidomarcha.setText(control.listadoAviones.elementAt(0).getNombre()
							+ " puesta en marcha y retroceso aprobado al " + " SUR " + " por rodadura "
							+ control.listadoAviones.elementAt(0).getRodadura());

					puestaenmarcha.add(mensajerecibidomarcha);

					/*
					 * Cuentaatras.nuHora = 0; Cuentaatras.nuMin =
					 * control.listadoAviones.elementAt(0).tiempoEspera(); Cuentaatras.nuSeg = 0;
					 * Temporizador.start();// inicializa el hilo
					 */
					PanelTerminal.setEnabledAt(3, true);
				} else if (control.listadoAviones.elementAt(0).getPista() == 29) {

					mensajerecibidomarcha.setText(control.listadoAviones.elementAt(0).getNombre()
							+ " puesta en marcha y retroceso aprobado al " + " ESTE " + " por rodadura "
							+ control.listadoAviones.elementAt(0).getRodadura());

					puestaenmarcha.add(mensajerecibidomarcha);

					/*
					 * Cuentaatras.nuHora = 0; Cuentaatras.nuMin =
					 * control.listadoAviones.elementAt(0).tiempoEspera(); Cuentaatras.nuSeg = 0;
					 * 
					 * Temporizador.start();// inicializa el hilo
					 */
					PanelTerminal.setEnabledAt(3, true);
				} else if (control.listadoAviones.elementAt(0).getPista() == 11) {

					mensajerecibidomarcha.setText(control.listadoAviones.elementAt(0).getNombre()
							+ " puesta en marcha y retroceso aprobado al " + " OESTE " + " por rodadura "
							+ control.listadoAviones.elementAt(0).getRodadura());

					puestaenmarcha.add(mensajerecibidomarcha);

					/*
					 * Cuentaatras.nuHora = 0; Cuentaatras.nuMin =
					 * control.listadoAviones.elementAt(0).tiempoEspera(); Cuentaatras.nuSeg = 0;
					 * 
					 * Temporizador.start();// inicializa el hilo
					 */
					PanelTerminal.setEnabledAt(3, true);
				}				
			
			}
		});
	}

	public void despegue() {

		despegue.setBackground(Color.BLACK);
		despegue.setLayout(new FlowLayout());
		JLabel mensaje = new JLabel();
		JButton boton = new JButton("Enviar");
		mensaje.setText(
				control.listadoAviones.elementAt(0).getNombre() + " preparado para despegar.Esperando autorización...");
		mensaje.setForeground(Color.white);
		mensaje.setForeground(Color.white);

		despegue.add(mensaje);
		despegue.add(boton);
		despegue.add(mensaje);

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int hora = calendario.get(Calendar.HOUR_OF_DAY);
				int minutos = calendario.get(Calendar.MINUTE);
				int segundos = calendario.get(Calendar.SECOND);
				String horaDespegue = hora + ":" + minutos + ":" + segundos;
				control.listadoAviones.elementAt(0).setHoraDespegue(horaDespegue);
			
				escribeRegistro();
				control.listadoAviones.remove(0);
				listaterminal.model.removeRow(0);
				actualiza();

			}
		});

	}

	public void actualiza() {

		pruebaradio.removeAll();
		radio();
		asignaruta.removeAll();
		;
		ruta();
		puestaenmarcha.removeAll();
		motores();
		despegue.removeAll();
		despegue();

		updateUI();

	}
	public void compruebaviento(Avion avion) {
		Derrota derrota;
		if(DireccionViento.direccion == 0 && avion.getPista() != 18) {
			
			 derrota = new Derrota();
			 derrota.setVisible(true);
			
		}else if(DireccionViento.direccion == 1 && avion.getPista() != 36) {
			
			 derrota = new Derrota();
			 derrota.setVisible(true);
		}else if(DireccionViento.direccion == 2 && avion.getPista() != 29) {
			
			 derrota = new Derrota();
			 derrota.setVisible(true);
		}else if(DireccionViento.direccion == 3 && avion.getPista() != 11) {
			
			 derrota = new Derrota();
			 derrota.setVisible(true);
		
		}
	}
	public void escribeRegistro() {

		BufferedWriter bw = null;
		try {
			File fichero = new File("./registro/registro.txt");

			bw = new BufferedWriter(new FileWriter(fichero, true));
			bw.write("\n" + control.listadoAviones.elementAt(0).infoAvionDesText() + "\n");
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