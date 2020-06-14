package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import contenido_Paneles.DireccionViento;

/**
 * Clase que proporciona en un panel un reloj y viento
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class Reloj extends JPanel implements ActionListener {
	
	// Constante de Versión
	public static final long serialVersionUID = 1;

	//Instanciación de las etiquetas para la fecha y hora
	JLabel time = new JLabel();
	JLabel date = new JLabel();
	
	//Instanciación de la clase viento y formato de fechas
	DireccionViento viento = new DireccionViento();
	SimpleDateFormat sdf;
	SimpleDateFormat sdft;

	/**
	 * Constructor de la clase que proporcionará el panel
	 */
	public Reloj() {

		//Configuración del panel
		setLayout(new GridLayout(4, 1));
		Color gris = new Color(91, 117, 113);
		setBackground(gris);

		// Reloj
		sdf = new SimpleDateFormat("   hh:mm:ss a");
		time.setFont(new Font("Consolas", Font.BOLD, 20));
		time.setHorizontalAlignment(SwingConstants.LEFT);
		time.setForeground(Color.GREEN);

		// Fecha
		sdft = new SimpleDateFormat(" MMMM dd yyyy");
		date.setFont(new Font("Consolas", Font.BOLD, 15));
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setForeground(Color.GREEN);

		// Viento
		viento.setFont(new Font("Consolas", Font.BOLD, 15));
		viento.setHorizontalAlignment(SwingConstants.LEFT);
		viento.setForeground(Color.GREEN);


		//Clase que dará comienzo a la hora
		Timer t = new Timer(1000, this);
		t.start();

		//Añade los elementos al panel
		add(viento);
		add(time);
		add(date);
		

	}


	/**
	 * @see ActionListener
	 * @see ActionEvent
	 */
	public void actionPerformed(ActionEvent ae) {
		
		//Instancia un objeto de la clase fehca
		Date d = new Date();
		
		//Asigna una hora a la clase
		time.setText(sdf.format(d));
		//Asigna una fecha a la clase
		date.setText(sdft.format(d));

	}
}
