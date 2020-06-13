package bilbao;

import java.util.Vector;

import dialogos.Victoria;

public class Control {

	public Vector<Avion> listadoAviones = new Vector<Avion>(new MySql().rellenarLista());
	public Vector<Avion> llegadaAviones = new Vector<Avion>(new MySql().listadollegadas());
	public static boolean listadoVacio = false;
	public static boolean llegadaVacio = false;
 
	public void compruebalista() {
		System.out.println(listadoVacio + "- " + llegadaVacio);
		Victoria nueva;
		if (listadoVacio == true && llegadaVacio == true) {

			nueva = new Victoria();
			nueva.setVisible(true);
		}

	}

}
