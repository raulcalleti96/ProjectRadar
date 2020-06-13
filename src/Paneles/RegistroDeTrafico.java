package Paneles;

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

public class RegistroDeTrafico extends JPanel {

	static final long serialVersionUID = 1;

	JLabel titulo = new JLabel("Historial de tráfico aéreo");

	JTextArea area = new JTextArea(50, 40);
	JScrollPane scroll = new JScrollPane(area);

	public RegistroDeTrafico() {

		setLayout(new BorderLayout());

		setBackground(Color.BLACK);

		// scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		scroll.setBorder(null);
		scroll.setPreferredSize(new Dimension(300, 180));
		Font fuente = new Font("Consolas", Font.BOLD, 15);

		titulo.setFont(fuente);
		titulo.setForeground(Color.YELLOW);

		area.setFont(fuente);
		area.setBackground(Color.BLACK);
		area.setForeground(Color.RED);

		area.setLineWrap(true);
		area.setWrapStyleWord(true);

		area.setEditable(false);
		texto();

		add(titulo, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
	}


	
	public void texto() {

		try {
			String cd;

			// Flujo de lectura
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File("./registro/registro.txt"))));

			while ((cd = br.readLine()) != null)
				area.append(cd + "\n");
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}
	
}

