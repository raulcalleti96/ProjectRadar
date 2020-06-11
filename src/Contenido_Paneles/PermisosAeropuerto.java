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
		
		add(PanelTerminal,BorderLayout.CENTER);
		
		
		
	}

}
