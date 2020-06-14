package contenido_Paneles;

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

/**
 * Asigna permisos de despegue a cada avión por orden
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class PermisosAeropuerto extends JPanel {

	// Constante de Versión
	static final long serialVersionUID = 1;
	
	// Instanciación de paneles y pestañas
	JTabbedPane PanelTerminal = new JTabbedPane();
	JPanel pruebaradio = new JPanel();
	JPanel asignaruta = new JPanel();
	JPanel puestaenmarcha = new JPanel();
	JPanel despegue = new JPanel();
	JLabel mensajeradio = new JLabel();
	JLabel mensajeruta = new JLabel();
	JLabel mensajerecibidoruta = new JLabel();
	JLabel mensajemarcha = new JLabel();
	JLabel mensajerecibidomarcha = new JLabel();
	
	// Instanciación de clase
	Calendar calendario = new GregorianCalendar();
	Control control = null;
	TablalistaAvionesAeropuerto listaterminal = null;
	// Variables
	String rutaseleccionada;
	int pistaseleccionada;
	int indice;

	/**
	 * Constructor de la clase para configurar el panel y se le añade al panel
	 * pestañas y dentro los paneles
	 * 
	 * @param control       Parametro que proporciona el vector con los aviones de la clase Control
	 * @param listaterminal Parametro queproporciona la tabla con los aviones
	 */
	public PermisosAeropuerto(Control control, TablalistaAvionesAeropuerto listaterminal) {

		// Variables para definir las clases
		this.listaterminal = listaterminal;
		this.control = control;

		// Configuración del panel
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);

		// Paneles
		radio();
		ruta();
		motores();
		despegue();

		// Añadimos los paneles al JTABBED, bloqueando el último
		PanelTerminal.add("RADIO", pruebaradio);
		PanelTerminal.add("ASIGNAR PISTA", asignaruta);
		PanelTerminal.add("ARRANQUE MOTORES", puestaenmarcha);
		PanelTerminal.add("DESPEGUE", despegue);
		PanelTerminal.setEnabledAt(3, false);
		add(PanelTerminal, BorderLayout.CENTER);

	}

	/**
	 * Método radio que proporciona el permiso de radio
	 */
	public void radio() {

		try {
			//Elementos de selección
			JCheckBox comprobar = new JCheckBox("Se escucha correctamente");
			JButton boton = new JButton("Enviar");
			JLabel mensaje2 = new JLabel("Recibido." + control.listadoAviones.elementAt(0).getNombre() + " le recibio correctamente.");
			mensajeradio.setText("Hola. Prueba de radio de " + control.listadoAviones.elementAt(0).getNombre());
			//Configuración de los paneles y botones
			mensajeradio.setForeground(Color.white);
			pruebaradio.setBackground(Color.BLACK);
			pruebaradio.setLayout(new FlowLayout());
			comprobar.setForeground(Color.white);
			mensaje2.setForeground(Color.white);
			
			//Se añaden los los elementos a la pestaña
			pruebaradio.add(mensajeradio);
			pruebaradio.add(comprobar);
			pruebaradio.add(boton);

			
			 // ActionListener Acción de click  del botón 
			 
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//Condición si se seleccionó previamente el JCheckbox
					if (comprobar.isSelected()) {
						
						//Cambia la variable de radio si se seleccionó
						control.listadoAviones.elementAt(0).setRadio(true);
						
						//Añade la respuesta del radar al panel
						pruebaradio.add(mensaje2);

					}

				}
			});
			
			
			//Recoge la excepción en caso de que la lista de aviones esté vacia
		} catch (ArrayIndexOutOfBoundsException e) {
			
			//No permite acceder a las pestañas
			PanelTerminal.setEnabledAt(0, false);
			PanelTerminal.setEnabledAt(1, false);
			PanelTerminal.setEnabledAt(2, false);
			PanelTerminal.setEnabledAt(3, false);
			//Modifica la variable estática que informa que está vacía la variable
			Control.listadoVacio = true;
			
			//comprueba si las dos listas están vacías
			control.compruebalista();

		}

	}

	/**
	 * Método ruta que proporciona el permiso correspondiente 
	 */
	public void ruta() {
		try {
			
			//Elementos de la selección
			JComboBox<Integer> pista = new JComboBox<Integer>();
			JButton boton = new JButton("Enviar");
			mensajeruta.setText(control.listadoAviones.elementAt(0).getNombre() + " solicitamos plan de vuelo para " + control.listadoAviones.elementAt(0).getDestino());
			
			//Configuración del paneles			
			asignaruta.setBackground(Color.BLACK);
			asignaruta.setLayout(new FlowLayout());
			mensajeruta.setForeground(Color.white);
			
			

			//Añade al JComboBox las pistas de rodadura
			pista.addItem(0);
			pista.addItem(29);
			pista.addItem(11);
			pista.addItem(36);
			pista.addItem(18);

			//Asigna al panel los elementos
			asignaruta.add(mensajeruta);
			asignaruta.add(pista);
			asignaruta.add(boton);

			// ActionListener para cuando seleccione una pista
			pista.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					//Asigna el valor de JComboBox a la variable
					pistaseleccionada = (int) pista.getSelectedItem();

				}
			});

			//ActionListener para cuando pulse el botón
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Configura el el label
					mensajerecibidoruta.setForeground(Color.white);
					
					//Le pasa a la variable del avión de pista la selección
					control.listadoAviones.elementAt(0).setPista(pistaseleccionada);
					
					//Le pasa al label la respuesta de la torre con la información obtenida
					mensajerecibidoruta.setText(control.listadoAviones.elementAt(0).getNombre() + " autorizado para "+ control.listadoAviones.elementAt(0).getDestino() + ".Plan de vuelo. Pista "+ control.listadoAviones.elementAt(0).getPista());
					//Añade al panel el elemento
					asignaruta.add(mensajerecibidoruta);
					//Comprueba si la pista es la correcta acorde la viento
					compruebaviento(control.listadoAviones.elementAt(0));
					//Actualiza el panel
					updateUI();

				}
			});
			//Recoge la excepción en caso de que la lista de aviones esté vacia
		} catch (ArrayIndexOutOfBoundsException e) {
			PanelTerminal.setEnabledAt(0, false);
			PanelTerminal.setEnabledAt(1, false);
			PanelTerminal.setEnabledAt(2, false);
			PanelTerminal.setEnabledAt(3, false);
			//Modifica la variable estática que informa que está vacía la variable
			Control.listadoVacio = true;
			//Comprueba si las dos listas están vacías
			control.compruebalista();

		}

	}

	/**
	 * Método que proporciona el permiso de apagado de motor
	 */
	public void motores() {
		try {
			//Crea nuevos elementos
			JButton boton = new JButton("Enviar");
			JLabel mensajerecibidomarcha = new JLabel();
			JComboBox<String> rodadura = new JComboBox<String>();
			//Proporciona un texto al label
			mensajemarcha.setText(control.listadoAviones.elementAt(0).getNombre() + " listos para puesta en marcha y retroceso.");
			//Configuración del panel y elementos
			puestaenmarcha.setBackground(Color.BLACK);
			puestaenmarcha.setLayout(new FlowLayout());
			mensajemarcha.setForeground(Color.white);
			mensajerecibidomarcha.setForeground(Color.white);

			
			//Añade al JComboBox las pistas de rodadura
			rodadura.addItem(" ");
			rodadura.addItem("E2");
			rodadura.addItem("Y2");
			rodadura.addItem("A1");
			rodadura.addItem("C2");

			//Añade al panel los elementos
			puestaenmarcha.add(mensajemarcha);
			puestaenmarcha.add(rodadura);
			puestaenmarcha.add(boton);
			puestaenmarcha.add(mensajerecibidomarcha);

			
			// ActionListener para cuando seleccione una pista de rodadura
			rodadura.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					//Asigna el valor de JComboBox a la variable
					rutaseleccionada = (String) rodadura.getSelectedItem();

				}
			});

			//ActionListener para cuando pulse el botón
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Configuración de los elementos
					mensajerecibidomarcha.setForeground(Color.white);
					//Proporciona la pista de rodadura seleccionada  al avión de la lista
					control.listadoAviones.elementAt(0).setRodadura(rutaseleccionada);

					//Condición si la pista asignada al avión es la que indica porporciona nuevos valores
					if (control.listadoAviones.elementAt(0).getPista() == 18) {
						
						//Pone el texto nuevo al mensaje de respuesta de la torre con la nueva información proporcionada
						mensajerecibidomarcha.setText(control.listadoAviones.elementAt(0).getNombre()
								+ " puesta en marcha y retroceso aprobado al " + " NORTE " + " por rodadura "
								+ control.listadoAviones.elementAt(0).getRodadura());
						
						//Añade al panel el mensaje de la torre
						puestaenmarcha.add(mensajerecibidomarcha);
						//Habilita la pestaña de despegue
						PanelTerminal.setEnabledAt(3, true);
						
					//Condición si la pista asignada al avión es la que indica porporciona nuevos valores
					} else if (control.listadoAviones.elementAt(0).getPista() == 36) {
						
						//Pone el texto nuevo al mensaje de respuesta de la torre con la nueva información proporcionada
						mensajerecibidomarcha.setText(control.listadoAviones.elementAt(0).getNombre()
								+ " puesta en marcha y retroceso aprobado al " + " SUR " + " por rodadura "
								+ control.listadoAviones.elementAt(0).getRodadura());

						//Añade al panel el mensaje de la torre
						puestaenmarcha.add(mensajerecibidomarcha);

						//Habilita la pestaña de apagado de motores
						PanelTerminal.setEnabledAt(3, true);
						
					//Condición si la pista asignada al avión es la que indica porporciona nuevos valores	
					} else if (control.listadoAviones.elementAt(0).getPista() == 29) {
						
						//Pone el texto nuevo al mensaje de respuesta de la torre con la nueva información proporcionada
						mensajerecibidomarcha.setText(control.listadoAviones.elementAt(0).getNombre()
								+ " puesta en marcha y retroceso aprobado al " + " ESTE " + " por rodadura "
								+ control.listadoAviones.elementAt(0).getRodadura());

						//Añade al panel el mensaje de la torre
						puestaenmarcha.add(mensajerecibidomarcha);
						
						//Habilita la pestaña de despegue
						PanelTerminal.setEnabledAt(3, true);
						
					//Condición si la pista asignada al avión es la que indica porporciona nuevos valores		
					} else if (control.listadoAviones.elementAt(0).getPista() == 11) {

						//Pone el texto nuevo al mensaje de respuesta de la torre con la nueva información proporcionada
						mensajerecibidomarcha.setText(control.listadoAviones.elementAt(0).getNombre()
								+ " puesta en marcha y retroceso aprobado al " + " OESTE " + " por rodadura "
								+ control.listadoAviones.elementAt(0).getRodadura());

						//Añade al panel el mensaje de la torre
						puestaenmarcha.add(mensajerecibidomarcha);

						//Habilita la pestaña de despegue
						PanelTerminal.setEnabledAt(3, true);
						
						
					}

				}
			});
			
		//Recoge la excepción en caso de que la lista de aviones esté vacia
		} catch (ArrayIndexOutOfBoundsException e) {
			PanelTerminal.setEnabledAt(0, false);
			PanelTerminal.setEnabledAt(1, false);
			PanelTerminal.setEnabledAt(2, false);
			PanelTerminal.setEnabledAt(3, false);
			
			//Modifica la variable estática que informa que está vacía la variable
			Control.listadoVacio = true;
	
			//Comprueba si las dos listas están vacías
			control.compruebalista();

		}
	}

	/**
	 * Método con el permiso de despegue
	 */
	public void despegue() {
		try {
			
			//Crea nuevos elementos
			JLabel mensaje = new JLabel();
			JButton boton = new JButton("Enviar");
			
			//Configuración del panel
			despegue.setBackground(Color.BLACK);
			despegue.setLayout(new FlowLayout());
			mensaje.setForeground(Color.white);
			mensaje.setForeground(Color.white);
			
			//Propociona el texto de respuesta de la torre
			mensaje.setText(control.listadoAviones.elementAt(0).getNombre()+ " preparado para despegar.Esperando autorización...");
			
			//Añade al panel los elementos
			despegue.add(mensaje);
			despegue.add(boton);
			despegue.add(mensaje);

			//ActionListener cuando pulse el botón
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Variables de la clase Calendar que proporcionan la hora actual del ordenador
					int hora = calendario.get(Calendar.HOUR_OF_DAY);
					int minutos = calendario.get(Calendar.MINUTE);
					int segundos = calendario.get(Calendar.SECOND);
					String horaDespegue = hora + ":" + minutos + ":" + segundos;
					
					//Asigna la hora de despegue a la variable del Avión
					control.listadoAviones.elementAt(0).setHoraDespegue(horaDespegue);

					//Escribe en el texto del registro la información del avión
					escribeRegistro();
					
					//Elimina del vector el avión
					control.listadoAviones.remove(0);
					
					//Elimina de la tabla el avión
					listaterminal.model.removeRow(0);
					
					//Actualiza los paneles
					actualiza();

				}
			});
		//Recoge la excepción en caso de que la lista de aviones esté vacia
		} catch (ArrayIndexOutOfBoundsException e) {
			PanelTerminal.setEnabledAt(0, false);
			PanelTerminal.setEnabledAt(1, false);
			PanelTerminal.setEnabledAt(2, false);
			PanelTerminal.setEnabledAt(3, false);
			
			//Modifica la variable estática que informa que está vacía la variable
			Control.listadoVacio = true;
			
			//Comprueba si las dos listas están vacías
			control.compruebalista();

		}

	}

	/**
	 * Método que refresca los paneles
	 */
	public void actualiza() {

		//Elimina todo los que contiene el panel
		pruebaradio.removeAll();
		
		//Vuelve a asignar el panel con el nuevo avión
		radio();
		
		//Elimina todo los que contiene el panel
		asignaruta.removeAll();
		
		//Vuelve a asignar el panel con el nuevo avión
		ruta();
		
		//Elimina todo los que contiene el panel
		puestaenmarcha.removeAll();
		
		//Vuelve a asignar el panel con el nuevo avión
		motores();
		
		//Elimina todo los que contiene el panel
		despegue.removeAll();
		
		//Vuelve a asignar el panel con el nuevo avión
		despegue();
		
		//Bloquea la pestaña
		PanelTerminal.setEnabledAt(3, false);
		
		//Refresca el panel mostrado
		updateUI();

	}

	/**
	 * Método compruebaviento para comprobar si escogió correctamente la pista acorde al viento
	 * @param avion información del avión
	 */
	public void compruebaviento(Avion avion) {
		
		//Referencia de la clase Derrota
		Derrota derrota;
		
		//Condiciónes si la dirección del viento no es viento de cola, pierde y muestra al ventana de dialogo correspondiente
		if (DireccionViento.direccion == 0 && avion.getPista() != 18) {
			
			derrota = new Derrota();
			derrota.setVisible(true);

		} else if (DireccionViento.direccion == 1 && avion.getPista() != 36) {
			
			derrota = new Derrota();
			derrota.setVisible(true);
		} else if (DireccionViento.direccion == 2 && avion.getPista() != 29) {

			derrota = new Derrota();
			derrota.setVisible(true);
		} else if (DireccionViento.direccion == 3 && avion.getPista() != 11) {

			derrota = new Derrota();
			derrota.setVisible(true);

		}
	}

	/**
	 * Método que escribe en un fichero la información del avión
	 */
	public void escribeRegistro() {

		//Crea un Buffered para escribir 
		BufferedWriter bw = null;
		try {
			
			//Instancia un fichero
			File fichero = new File("./registro/registro.txt");
			bw = new BufferedWriter(new FileWriter(fichero, true));
			
			//Escribe la información del avión
			bw.write("\n" + control.listadoAviones.elementAt(0).infoAvionDesText() + "\n");
			
			//Posibles excepciones
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