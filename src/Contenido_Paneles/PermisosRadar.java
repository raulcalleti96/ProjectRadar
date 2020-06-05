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
		
		setLayout(new FlowLayout());
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
		PanelRadar.add("RADIO", pruebaradio);
		PanelRadar.add("Asignar Ruta", asignaruta);
		PanelRadar.add("Puesta en Marcha", puestaenmarcha);
		PanelRadar.add("Despegue", despegue);
		
		add(PanelRadar);
		
	}

}
