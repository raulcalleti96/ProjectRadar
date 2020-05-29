package bilbao;

import java.util.Vector;

public class Aeropuerto {
	
	private int pista1 = 24;
	private int pista2 = 18;
	private int puerta1 = 1;
	private int puerta2 = 2;
	private int puerta3 = 3;
	private int radadura1 = 1;
	private int radadura2 = 2;
	private int radadura3 = 3;
	
	public int getRadadura1() {
		return radadura1;
	}

	public void setRadadura1(int radadura1) {
		this.radadura1 = radadura1;
	}

	public int getRadadura2() {
		return radadura2;
	}

	public void setRadadura2(int radadura2) {
		this.radadura2 = radadura2;
	}

	public int getRadadura3() {
		return radadura3;
	}

	public void setRadadura3(int radadura3) {
		this.radadura3 = radadura3;
	}

	public int getPuerta1() {
		return puerta1;
	}

	public void setPuerta1(int puerta1) {
		this.puerta1 = puerta1;
	}

	public int getPuerta2() {
		return puerta2;
	}

	public void setPuerta2(int puerta2) {
		this.puerta2 = puerta2;
	}

	public int getPuerta3() {
		return puerta3;
	}

	public void setPuerta3(int puerta3) {
		this.puerta3 = puerta3;
	}

	public int getPuerta4() {
		return puerta4;
	}

	public void setPuerta4(int puerta4) {
		this.puerta4 = puerta4;
	}

	private int puerta4 = 4;
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
