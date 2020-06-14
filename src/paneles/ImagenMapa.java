package paneles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que proporciona un panel con una imagen del plano del aeropuerto
 * 
 * @author: Pablo Borrego
 * 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class ImagenMapa extends JPanel{
	
	// Constante de Versión
	static final long serialVersionUID = 1;
	
	//Instanciación de la clase de imagen pasando nombre del fichero de la imagen y la escala
	ImageIcon imagen = new ImageIcon("pista.png");
	Image imagenR = imagen.getImage();
	Image pista = imagenR.getScaledInstance(600, 400, Image.SCALE_DEFAULT);
	ImageIcon iconopista = new ImageIcon(pista);
	
	/**
	 * Método que proporciona el panel con la imagen
	 */
	public ImagenMapa(){
		
		//imagen
		JLabel Mapa = new JLabel(iconopista);
		
		//Configuración del panel
		setLayout(new FlowLayout());
		setBackground(Color.BLACK);
		
		//Añade la imagen al panel
		add(Mapa);
	
		
	}
	

}
