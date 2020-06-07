package Contenido_Paneles;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TablalistaAvionesAeropuerto extends JPanel{

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
		
		
		
	public TablalistaAvionesAeropuerto(){
		
		setLayout(new BorderLayout());
		setBackground(Color.BLACK.brighter());
		tablaAero.setBackground(new Color(162, 212, 83));
		setToolTipText("Lista de los aviones del aeropuerto");
		
		
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
