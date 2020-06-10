package Contenido_Paneles;
import javax.swing.*;
import java.awt.*;

public class PermisosAeropuerto extends JPanel{
	
	static final long serialVersionUID = 1;
	
	JTabbedPane PanelTerminal = new JTabbedPane();
	
	
	
	JPanel pruebaradio = new JPanel();
	JPanel asignaruta = new JPanel();
	JPanel puestaenmarcha= new JPanel();
	JPanel despegue = new JPanel();
	
	
	public PermisosAeropuerto() {
		
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);

		//Paneles
		radio();
		ruta();
		motores();
		despegue();
		//Añadimos los paneles al JTABBED
		PanelTerminal.add("RADIO", pruebaradio);
		PanelTerminal.add("ASIGNAR PISTA", asignaruta);
		PanelTerminal.add("ARRANQUE MOTORES", puestaenmarcha);
		PanelTerminal.add("DESPEGUE", despegue);
		
		add(PanelTerminal,BorderLayout.CENTER);
		
	}
	
	public void radio(){
		
		pruebaradio.setBackground(Color.BLACK);
		pruebaradio.setLayout(new FlowLayout());	
		JLabel mensaje =  new JLabel("Buenos días. Prueba para colocar todo en radio.");
		JCheckBox comprobar = new JCheckBox("Se escucha correctamente");
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 =  new JLabel("Recibido. Prueba para colocar todo en radio.");
		mensaje.setForeground(Color.white);
		comprobar.setForeground(Color.white);
		mensaje2.setForeground(Color.white);
		
		pruebaradio.add(mensaje);
		pruebaradio.add(comprobar);
		pruebaradio.add(boton);
		pruebaradio.add(mensaje2);
	}
	
	public void ruta(){
		
		asignaruta.setBackground(Color.BLACK);
		asignaruta.setLayout(new FlowLayout());	
		JLabel mensaje =  new JLabel("Buenos días. Prueba para colocar todo en ruta.");
		JTextField pista = new JTextField(2);
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 =  new JLabel("Recibido. Prueba para colocar todo en ruta.");
		mensaje.setForeground(Color.white);
		mensaje2.setForeground(Color.white);
		
		
		asignaruta.add(mensaje);
		asignaruta.add(pista);
		asignaruta.add(boton);
		asignaruta.add(mensaje2);
	}
	
	public void motores(){
		
		puestaenmarcha.setBackground(Color.BLACK);
		puestaenmarcha.setLayout(new FlowLayout());	
		JLabel mensaje =  new JLabel("Buenos días. Prueba para colocar todo en motores.");
		JTextField rodadura = new JTextField(2);
		JTextField direccion = new JTextField(5);
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 =  new JLabel("Recibido. Prueba para colocar todo en motores.");
		mensaje.setForeground(Color.white);
		mensaje2.setForeground(Color.white);
		
		
		puestaenmarcha.add(mensaje);
		puestaenmarcha.add(rodadura);
		puestaenmarcha.add(direccion);
		puestaenmarcha.add(boton);
		puestaenmarcha.add(mensaje2);
	}
	
	public void despegue(){
		
		despegue.setBackground(Color.BLACK);
		despegue.setLayout(new FlowLayout());	
		JLabel mensaje =  new JLabel("Buenos días. Prueba para colocar todo en despegue.");
		JButton boton = new JButton("Enviar");
		JLabel mensaje2 =  new JLabel("Recibido. Prueba para colocar todo en motores.");
		mensaje.setForeground(Color.white);

		mensaje2.setForeground(Color.white);
		
		despegue.add(mensaje);
		despegue.add(boton);
		despegue.add(mensaje2);
	}
	

}
