package Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Contenido_Paneles.DireccionViento;

public class Reloj extends JPanel implements ActionListener {
	public static final long serialVersionUID = 1;

	JMenu Menu = new JMenu();

	JLabel time = new JLabel();
	JLabel date = new JLabel();
	

	DireccionViento viento = new DireccionViento();
	SimpleDateFormat sdf;
	SimpleDateFormat sdft;

	public Reloj() {

		setLayout(new GridLayout(4, 1));


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

		Color gris = new Color(91, 117, 113);
		setBackground(gris);

		Timer t = new Timer(1000, this);
		t.start();

		add(viento);
		add(time);
		add(date);
		

	}

	public void actionPerformed(ActionEvent ae) {
		Date d = new Date();
		time.setText(sdf.format(d));
		date.setText(sdft.format(d));

	}
}
