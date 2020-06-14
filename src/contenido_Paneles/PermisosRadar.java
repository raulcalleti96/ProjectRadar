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
 * Clase con un panel que asigna permisos de aterrizaje a cada avión por orden
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class PermisosRadar extends JPanel {

	// Constante de Versión
	static final long serialVersionUID = 1;

	// Instanciación de paneles y pestañas
	JTabbedPane PanelRadar = new JTabbedPane();
	JPanel contacto = new JPanel();
	JPanel asignarodadura = new JPanel();
	JPanel apagadoMotores = new JPanel();
	
	
	// Instanciación de clase
	TablalistaAvionesRadar listaterminal = null;
	Control control = null;
	Calendar calendario = new GregorianCalendar();
	
	// Variables
	String rutaseleccionada;
	int pistaseleccionada;

	
	/**
	 * Constructor de la clase para configurar el panel y se le añade al panel
	 * pestañas y dentro los paneles
	 * 
	 * @param control       Parametro que proporciona el vector con los aviones de la clase Control
	 * @param listaterminal Parametro queproporciona la tabla con los aviones 
	 */
	public PermisosRadar(Control control, TablalistaAvionesRadar listaterminal) {

		// Variables para definir las clases
		this.listaterminal = listaterminal;
		this.control = control;
		
		// Configuración del panel
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);

		// Paneles
		contacto();
		rodadura();
		apagadoMotores();

		// Añade los paneles al JTABBED, bloqueando el último
		PanelRadar.add("CONTACTO", contacto);
		PanelRadar.add("RODADURA", asignarodadura);
		PanelRadar.add("APAGADO MOTORES", apagadoMotores);
		PanelRadar.setEnabledAt(2, false);
		add(PanelRadar, BorderLayout.CENTER);

	}

	/**
	 * Método que proporciona el permiso de contacto con la torre y ILS
	 */
	public void contacto() {

		try {
			
			//Elementos de selección
			JLabel mensajeradio = new JLabel("Hola." + " aquí " + control.llegadaAviones.elementAt(0).getNombre()
					+ " establecido contacto ILS ");

			JCheckBox comprobar = new JCheckBox("AUTORIZAR");
			JButton boton = new JButton("Enviar");
			JLabel mensaje2 = new JLabel();
			JComboBox<Integer> pista = new JComboBox<Integer>();
			
			//Configuración de los paneles y botones
			contacto.setBackground(Color.BLACK);
			contacto.setLayout(new FlowLayout());
			mensajeradio.setForeground(Color.white);
			comprobar.setForeground(Color.white);
			mensaje2.setForeground(Color.white);
		
			//Añade al JComboBox las pistas de rodadura
			pista.addItem(0);
			pista.addItem(29);
			pista.addItem(11);
			pista.addItem(36);
			pista.addItem(18);

			//Asigna al panel los elementos
			contacto.add(mensajeradio);
			contacto.add(pista);
			contacto.add(comprobar);
			contacto.add(boton);

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

					//Condición si se seleccionó previamente el JCheckbox
					if (comprobar.isSelected()) {
						
						//Se le pasa al piloto que se ha establecido contacto correctamente al avión
						control.llegadaAviones.elementAt(0).setContacto(true);
						
						//Se le pasa al piloto la pista por la que tiene que aterrizar
						control.llegadaAviones.elementAt(0).setPista(pistaseleccionada);
						
						//Respuesta de la torre de control
						mensaje2.setText(" Recibido " + control.llegadaAviones.elementAt(0).getNombre() + ".Pista:"+ control.llegadaAviones.elementAt(0).getPista() + " autorizado para aterrizar.");
						
						//Añade al panel el elemento
						contacto.add(mensaje2);

						//Comprueba si la pista es la correcta acorde la viento
						compruebaviento(control.llegadaAviones.elementAt(0));
						//Actualiza el panel
						updateUI();
					}

				}
			});
			
			//Recoge la excepción en caso de que la lista de aviones esté vacia
		} catch (ArrayIndexOutOfBoundsException e) {
			
			PanelRadar.setEnabledAt(0, false);
			PanelRadar.setEnabledAt(1, false);
			PanelRadar.setEnabledAt(2, false);
			//Modifica la variable estática que informa que está vacía la variable
			Control.llegadaVacio = true;
			
			//Comprueba si las dos listas están vacías
			control.compruebalista();

		}
	}
	
	/**
	 * Método que proporciona el permiso de contacto con la torre y ILS
	 */
	public void rodadura() {

		try {
			
			//Crea nuevos elementos
			JLabel mensaje = new JLabel(control.llegadaAviones.elementAt(0).getNombre() + " solicitamos pista de rodadura. ");
			JButton boton = new JButton("Enviar");
			JLabel mensaje2 = new JLabel();
			JComboBox<String> rodadura = new JComboBox<String>();
			
			//Configuración del panel y elementos
			asignarodadura.setBackground(Color.BLACK);
			asignarodadura.setLayout(new FlowLayout());
			mensaje.setForeground(Color.white);
			mensaje2.setForeground(Color.white);
			
			//Añade al JComboBox las pistas de rodadura
			rodadura.addItem(" ");	
			rodadura.addItem("E2");
			rodadura.addItem("Y2");
			rodadura.addItem("A1");
			rodadura.addItem("C2");

		
			//Añade al panel los elementos
			asignarodadura.add(mensaje);
			asignarodadura.add(rodadura);
			asignarodadura.add(boton);
			asignarodadura.add(mensaje2);

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
					mensaje2.setForeground(Color.white);
					//Proporciona la pista de rodadura seleccionada  al avión de la lista
					control.llegadaAviones.elementAt(0).setRodadura(rutaseleccionada);

					//Condición si la pista asignada al avión es la que indica porporciona nuevos valores
					if (control.llegadaAviones.elementAt(0).getPista() == 18) {

						//Proporciona la pista de rodadura seleccionada  al avión de la lista
						mensaje2.setText(control.llegadaAviones.elementAt(0).getNombre()
								+ " recibido. Aterrizaje por el " + " NORTE " + " por rodadura "
								+ control.llegadaAviones.elementAt(0).getRodadura());

						//Añade al panel el mensaje de la torre
						asignarodadura.add(mensaje2);

						//Habilita la pestaña de apagado de motores
						PanelRadar.setEnabledAt(2, true);
						
					//Condición si la pista asignada al avión es la que indica porporciona nuevos valores
					} else if (control.llegadaAviones.elementAt(0).getPista() == 36) {

						//Pone el texto nuevo al mensaje de respuesta de la torre con la nueva información proporcionada
						mensaje2.setText(control.llegadaAviones.elementAt(0).getNombre()
								+ " recibido. Aterrizaje por el  " + " SUR " + " por rodadura "
								+ control.llegadaAviones.elementAt(0).getRodadura());

						//Añade al panel el mensaje de la torre
						asignarodadura.add(mensaje2);

						//Habilita la pestaña de apagado de motores
						PanelRadar.setEnabledAt(2, true);
						
						//Condición si la pista asignada al avión es la que indica porporciona nuevos valores	
					} else if (control.llegadaAviones.elementAt(0).getPista() == 29) {

						//Pone el texto nuevo al mensaje de respuesta de la torre con la nueva información proporcionada
						mensaje2.setText(control.llegadaAviones.elementAt(0).getNombre()
								+ "  recibido. Aterrizaje por el  " + " ESTE " + " por rodadura "
								+ control.llegadaAviones.elementAt(0).getRodadura());

						//Añade al panel el mensaje de la torre
						asignarodadura.add(mensaje2);

						//Habilita la pestaña de apagado de motores
						PanelRadar.setEnabledAt(2, true);
						
						//Condición si la pista asignada al avión es la que indica porporciona nuevos valores		
					} else if (control.llegadaAviones.elementAt(0).getPista() == 11) {

						//Pone el texto nuevo al mensaje de respuesta de la torre con la nueva información proporcionada
						mensaje2.setText(control.llegadaAviones.elementAt(0).getNombre()
								+ "  recibido. Aterrizaje por el  " + " OESTE " + " por rodadura "
								+ control.llegadaAviones.elementAt(0).getRodadura());

						//Añade al panel el mensaje de la torre
						asignarodadura.add(mensaje2);

						//Habilita la pestaña de despegue
						PanelRadar.setEnabledAt(2, true);
					}

				}
			});
			
			//Recoge la excepción en caso de que la lista de aviones esté vacia
		} catch (ArrayIndexOutOfBoundsException e) {
			PanelRadar.setEnabledAt(0, false);
			PanelRadar.setEnabledAt(1, false);
			PanelRadar.setEnabledAt(2, false);
			//Modifica la variable estática que informa que está vacía la variable
			Control.llegadaVacio = true;
			
			//Comprueba si las dos listas están vacías
			control.compruebalista();

		}
	}

	/**
	 * Método con el permiso de apagado de motores
	 */
	public void apagadoMotores() {

		try {
			
			//Crea nuevos elementos
			JLabel mensaje = new JLabel(
					control.llegadaAviones.elementAt(0).getNombre() + " apagado de motores. Hasta Pronto");
			JButton boton = new JButton("Estacionado");

			//Configuración del panel
			apagadoMotores.setBackground(Color.BLACK);
			apagadoMotores.setLayout(new FlowLayout());
			mensaje.setForeground(Color.white);
			mensaje.setForeground(Color.white);

			//Añade al panel los elementos
			apagadoMotores.add(mensaje);
			apagadoMotores.add(boton);

			
			//ActionListener cuando pulse el botón
			boton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					//Variables de la clase Calendar que proporcionan la hora actual del ordenador
					int hora = calendario.get(Calendar.HOUR_OF_DAY);
					int minutos = calendario.get(Calendar.MINUTE);
					int segundos = calendario.get(Calendar.SECOND);
					String horaDespegue = hora + ":" + minutos + ":" + segundos;
					
					//Asigna la hora de despegue a la variable del Avión
					control.llegadaAviones.elementAt(0).setHoraDespegue(horaDespegue);

					//Asigna al avión que puede proceder a despegar
					control.llegadaAviones.elementAt(0).setApagado(true);
					
					//Escribe en el texto del registro la información del avión
					escribeRegistro();
					
					//Elimina del vector el avión
					control.llegadaAviones.remove(0);
					
					//Elimina de la tabla el avión
					listaterminal.model.removeRow(0);
					
					//Actualiza los paneles
					actualiza();

				}
			});
			
			//Recoge la excepción en caso de que la lista de aviones esté vacia	
		} catch (ArrayIndexOutOfBoundsException e) {
					
			PanelRadar.setEnabledAt(0, false);
			PanelRadar.setEnabledAt(1, false);
			PanelRadar.setEnabledAt(2, false);
			
			//Modifica la variable estática que informa que está vacía la variable
			Control.llegadaVacio = true;

			//Comprueba si las dos listas están vacías
			control.compruebalista();

		}
	}

	/**
	 * Método que refresca los paneles
	 */
	public void actualiza() {

		//Elimina todo los que contiene el panel
		contacto.removeAll();
		
		//Vuelve a asignar el panel con el nuevo avión
		contacto();
		
		//Elimina todo los que contiene el panel
		asignarodadura.removeAll();

		//Vuelve a asignar el panel con el nuevo avión
		rodadura();
		
		//Elimina todo los que contiene el panel
		apagadoMotores.removeAll();
		
		//Vuelve a asignar el panel con el nuevo avión
		apagadoMotores();
		
		//Bloquea la pestaña
		PanelRadar.setEnabledAt(2, false);
		
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

	/**
	 * Método que escribe en un fichero la información del avión
	 */
	public void escribeRegistro() {

		//Crea un Buffered para escribir 
		BufferedWriter bw = null;
		try {
			
			//Instancia un fichero
			File fichero = new File("./registro/registro.txt");

			//Escribe la información del avión
			bw = new BufferedWriter(new FileWriter(fichero, true));
			bw.write("\n" + control.llegadaAviones.elementAt(0).infoAvionDesText() + "\n");
		
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
