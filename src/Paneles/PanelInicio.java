package Paneles;

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

public class PanelInicio extends JPanel {
	private static final long serialVersionUID = 1;

	public boolean visible = true;

	JLabel titulo = new JLabel("Radar");
	JButton empezar = new JButton("Comenzar");

	private Image imagen;

	public PanelInicio(String ruta) throws IOException {

		setLayout(new FlowLayout());
		imagen = ImageIO.read(new File(ruta));
		// empezar.addActionListener(this);
		// add(empezar);
		setPreferredSize(new Dimension(800, 400));
		setBackground(Color.BLACK);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagen, 420, 150, this);
	}

}
