package Contenido_Paneles;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TablalistaAvionesRadar extends JPanel{

		static final long serialVersionUID = 1;
		
		static String avionselec = "";
		final String[] NOMBRE_COL= {"NOMBRE","ORIGEN","DESTINO"}; 
		final int FILAS = 40;
		final int COLUMNAS = 3;
		
		
		//Tabla Aeropuerto
		final JTable tablaAero = new JTable(new DefaultTableModel(NOMBRE_COL,FILAS)) {
			
			//Se configura la tabla como no editable
			static final long serialVersionUID = 1;
			public boolean isCellEditable(int filas , int columnas) {
				return false;
			}
		};
		
		//Panel de Scroll
		JScrollPane scroll = new JScrollPane(tablaAero);
		
		
		
	public TablalistaAvionesRadar(){
		
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		tablaAero.setBackground(new Color(55, 119, 171));
		setSize(50, 20);
		setToolTipText("Lista de los aviones del aeropuerto");
		/*tablaAero.setSize(45, 45);
		scroll.setSize(30, 30);*/
		
		
		//METODO DE SELECCION DEL AVIÓN
		
		tablaAero.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
						
				//Evento cuando se produzca un doble click (Recoge la fila)
				if(e.getClickCount() == 2) {
				
					//Recoge la fila
					int fila = tablaAero.rowAtPoint(e.getPoint());
					String cadena = "";
					
					//Forma una cadena con los atributos del avión para mostrarlos en la asignación de permisos
					if(fila >= 0)
						for(int i  = 0 ; i< tablaAero.getColumnCount();i++) {
							cadena += tablaAero.getValueAt(fila, i)+" ";
						}
					//Seleccion del avión para permisos
				avionselec =cadena;
				System.out.println(avionselec+"LA SELECCION FUNCIONA");
				}
			}
		});
		

		add(scroll,BorderLayout.CENTER);
	
		
	}
	
	

}
