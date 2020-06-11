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
		JLabel mensajeradio = new JLabel("Buenos días. Prueba para colocar todo en radio del avion " + control.listadoAviones.elementAt(indice).getNombre());
		JCheckBox comprobar = new JCheckBox("Se escucha correctamente");
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 = new JLabel("Recibido. Prueba para colocar todo en radio.");
		mensajeradio.setForeground(Color.white);
		comprobar.setForeground(Color.white);
		mensaje2.setForeground(Color.white);

		pruebaradio.add(mensajeradio);
		pruebaradio.add(comprobar);
		pruebaradio.add(boton);
		
		boton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  
			  if(comprobar.isSelected()) {
				  control.listadoAviones.elementAt(indice).setRadio(true);
	    		 
	    		  System.out.println( "3"+control.listadoAviones.elementAt(indice).getRadio());
	    		  pruebaradio.add(mensaje2);
				  updateUI();
	    	  }
			  
			  
		  }
		});
		
	
	}

	public void ruta(int indice) {

		asignaruta.setBackground(Color.BLACK);
		asignaruta.setLayout(new FlowLayout());
		JLabel mensaje = new JLabel(control.listadoAviones.elementAt(indice).getNombre() + " solicitamos plan de vuelo para " + control.listadoAviones.elementAt(indice).getDestino());
		JComboBox<Integer> pista = new JComboBox<Integer>();
		pista.addItem(29);
		pista.addItem(11);
		pista.addItem(36);
		pista.addItem(18);
		
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 = new JLabel(control.listadoAviones.elementAt(indice).getNombre() + " autorizado para " + control.listadoAviones.elementAt(indice).getDestino() +  ".Plan de vuelo. Pista " + control.listadoAviones.elementAt(indice).getPista());
		mensaje.setForeground(Color.white);
		mensaje2.setForeground(Color.white);

		asignaruta.add(mensaje);
		asignaruta.add(pista);
		asignaruta.add(boton);
		asignaruta.add(mensaje2);
	
		pista.addActionListener(new ActionListener() {
			
			   public void actionPerformed(ActionEvent e) {
				   
				   pistaseleccionada = (int)pista.getSelectedItem();
  
			   }
			});
		
		boton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {

				  control.listadoAviones.elementAt(indice).setPista(pistaseleccionada);
	    		  asignaruta.add(mensaje2);
				  updateUI();
	    	  					  
		  }
		});
		
	}

	public void motores(int indice) {

		puestaenmarcha.setBackground(Color.BLACK);
		puestaenmarcha.setLayout(new FlowLayout());
		JLabel mensaje = new JLabel("Buenos días. Prueba para colocar todo en motores.");
		JTextField rodadura = new JTextField(2);
		JTextField direccion = new JTextField(5);
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 = new JLabel("Recibido. Prueba para colocar todo en motores.");
		mensaje.setForeground(Color.white);
		mensaje2.setForeground(Color.white);

		puestaenmarcha.add(mensaje);
		puestaenmarcha.add(rodadura);
		puestaenmarcha.add(direccion);
		puestaenmarcha.add(boton);
		puestaenmarcha.add(mensaje2);
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

				return  i;

			}
		}
		return 0;
	}


}
