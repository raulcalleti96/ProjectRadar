package Paneles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagenMapa extends JPanel{
	static final long serialVersionUID = 1;
	
	ImageIcon imagen = new ImageIcon("pista.png");
	Image imagenR = imagen.getImage();
	Image pista = imagenR.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
	ImageIcon iconopista = new ImageIcon(pista);
	
	public ImagenMapa(){
		
		
		JLabel Mapa = new JLabel(iconopista);
		
		setLayout(new FlowLayout());
		setBackground(Color.BLACK);
		add(Mapa);
	
		
	}
	
	
	

}
