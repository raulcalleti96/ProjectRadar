package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase que alberga el panel que muestra el historial del registro aéreo
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class RegistroDeTrafico extends JPanel {

	// Constante de Versión
	static final long serialVersionUID = 1;

	//Instanciación de lo elementos del panel
	JLabel titulo = new JLabel("Historial de tráfico aéreo");
	JTextArea area = new JTextArea(50, 40);
	JScrollPane scroll = new JScrollPane(area);

	/**
	 * Constructor de la clase que creará y definirá el panel
	 */
	public RegistroDeTrafico() {

		//Instanciación de la clase Fuente de letra
		Font fuente = new Font("Consolas", Font.BOLD, 15);
		
		// Configuración del panel, el área de texto y scroll
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		scroll.setBorder(null);
		scroll.setPreferredSize(new Dimension(300, 180));
		titulo.setFont(fuente);
		titulo.setForeground(Color.YELLOW);
		area.setFont(fuente);
		area.setBackground(Color.BLACK);
		area.setForeground(Color.RED);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setEditable(false);
		
		//Método que recoge el fichero con el registro del historial de movimientos y lo muestra enpantalla
		texto();

		//Añade los elementos al panel
		add(titulo, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
	}


	/**
	 * //Método que recoge el fichero con el registro del historial de movimientos y lo muestra enpantalla
	 */
	
	public void texto() {

		try {
			//Creamos la referencia del texto que mostrará
			String cd;

			// Flujo de lectura. 
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./registro/registro.txt"))));

			//Itera cada frase y la coloca en la zona de texto
			while ((cd = br.readLine()) != null)
				area.append(cd + "\n");
		} catch (IOException e) {

		}

	}
	
}

