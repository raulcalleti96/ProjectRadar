package Paneles;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reloj extends JPanel implements ActionListener{
	public static final long serialVersionUID = 1;
	
	JLabel time = new JLabel();
	JLabel date = new JLabel();
	
	JLabel viento = new JLabel("Viento: Norte");
	SimpleDateFormat sdf;
	SimpleDateFormat sdft;
	
	public Reloj(){
		
		setLayout(new GridLayout(3,1));
	
		//Reloj
		sdf = new SimpleDateFormat("         MMMM dd yyyy");
		time.setFont(new Font("Consolas", Font.BOLD, 25));
        time.setHorizontalAlignment(SwingConstants.LEFT);
        time.setForeground(Color.GREEN);
		
    	//Fecha
		sdft = new SimpleDateFormat("   hh:mm:ss a");
        date.setFont(new Font("Consolas", Font.BOLD,20 ));
        date.setHorizontalAlignment(SwingConstants.CENTER);
        date.setForeground(Color.GREEN);
		
        //Viento
        viento.setFont(new Font("Consolas", Font.BOLD, 20));
        viento.setHorizontalAlignment(SwingConstants.LEFT);
        viento.setForeground(Color.GREEN);
        
        setBackground(Color.BLUE);
		
		Timer t = new Timer(250, this);
		t.start();
		
		add(viento);
		add(date);
		add(time);
	  
	}
	
	 public void actionPerformed(ActionEvent ae) {
		    Date d = new Date();
		    time.setText(sdf.format(d));
		    date.setText(sdft.format(d));
		    
		    
		  }

}
