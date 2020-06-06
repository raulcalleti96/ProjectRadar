package Paneles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RegistroDeTrafico extends JPanel{
	
	static final long serialVersionUID =1;

	final String TITULO = "REGISTRO DEL TRAFICO AEREO";
	
	JTextArea area = new JTextArea(50,40);
	JScrollPane scroll= new JScrollPane(area);
	
	
	public RegistroDeTrafico() {
		
		setLayout(new FlowLayout());
	
		setBackground(Color.BLACK);
		
	/*	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		*/
		scroll.setBorder(null);
		Font fuente = new Font("Consolas",Font.BOLD,15);
		
		area.setFont(fuente);
		area.setText(TITULO);
		area.setBackground(Color.BLACK);
		area.setForeground(Color.CYAN);
		
		area.setLineWrap(true);
		area.setEditable(true);
		
		//POLLITAS
	
		add(scroll);
	}

}
