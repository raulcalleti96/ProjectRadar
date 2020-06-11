package Contenido_Paneles;
import javax.swing.*;
import java.awt.*;

public class PermisosRadar extends JPanel{
	
	static final long serialVersionUID = 1;
	
	JTabbedPane PanelRadar = new JTabbedPane();
	
	
	
	JPanel pruebaradio = new JPanel();
	JPanel asignaruta = new JPanel();
	JPanel puestaenmarcha= new JPanel();
	JPanel despegue = new JPanel();
	
	
	public PermisosRadar() {
		
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		//Color a los demás paneles para distinguirlos
		pruebaradio.setBackground(Color.GREEN);
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
		PanelRadar.add("<html><strong>PERMISO ATERRIZAJE</strong></html>", pruebaradio);
		PanelRadar.add("<html><strong>CONTACTO</strong></html>", asignaruta);
		PanelRadar.add("<html><strong>APAGADO MOTORES</strong></html>", puestaenmarcha);
	
		add(PanelRadar,BorderLayout.CENTER);
		
	}

}
