package paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que proporciona un panel inicial con una imagen
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class PanelInicio extends JPanel {
	
	//Constante de versión
	private static final long serialVersionUID = 1;

	//Variable para mostrar
	public boolean visible = true;

	//Elementos del panel
	JLabel titulo = new JLabel("Radar");
	JButton empezar = new JButton("Comenzar");
	private Image imagen;
 
	/**
	 * Constructor del panel que muestra el logo del programa
	 * @param ruta  Muestra la ruta de la imagen del programa
	 * @throws IOException En caso de error lanzará el error
	 */
	public PanelInicio(String ruta) throws IOException {

		//Configuración del panel
		setLayout(new FlowLayout());
		imagen = ImageIO.read(new File(ruta));
		setPreferredSize(new Dimension(800, 400));
		setBackground(Color.BLACK);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagen, 150, 40, this);
	}

}
