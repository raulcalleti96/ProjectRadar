package bilbao;

public class Control {

	public static void main(String[] args) {

		Avion iberia = new Avion("IB5805", "Bilbao" , "Madrid");
		Avion lufthansa = new Avion("LU3425", "Bilbao" , "Munich");
		//System.out.println("test");
		Aeropuerto bilbao = new Aeropuerto();
		
		bilbao.añadirAvion(iberia);
		bilbao.añadirAvion(lufthansa);
		
		bilbao.aviones.elementAt(0).permisos();

	}

}
