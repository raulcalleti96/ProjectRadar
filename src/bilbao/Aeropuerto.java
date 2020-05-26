package bilbao;

import java.util.Vector;

public class Aeropuerto {
	
	private int pista1 = 24;
	private int pista2 = 18;
	private char viento = 'n';
	Vector <Avion> aviones = new Vector<Avion>();

	
	Aeropuerto(){
	}
	
	Aeropuerto(Vector <Avion>aviones){
		
		
		this.aviones = aviones;
	}

	public int getPista1() {
		return pista1;
	}

	public void setPista1(int pista1) {
		this.pista1 = pista1;
	}

	public int getPista2() {
		return pista2;
	}

	public void setPista2(int pista2) {
		this.pista2 = pista2;
	}
	public char getViento() {
		return viento;
	}

	public void setViento(char viento) {
		this.viento = viento;
	}

	public void añadirAvion(Avion nuevo){
		
		aviones.add(nuevo);
		
	}
	
	public void quitarAvion(Avion nuevo){
		
		aviones.remove(nuevo);
	}
	

	


}
