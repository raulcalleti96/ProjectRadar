package bilbao;

import java.util.Vector;

public class Control {

	public static void main(String[] args) {

		Avion iberia = new Avion("IB5805", "Bilbao" , "Madrid");
		Avion lufthansa = new Avion("LU3425", "Bilbao" , "Munich");
		Avion aireuropa = new Avion("AE2325", "Milan" , "Bilbao");
		Avion vueling= new Avion("VU9454", "Madrid" , "Bilbao");
		Vector<Avion> listado= new Vector<Avion>();
		//System.out.println("test");
		listado.add(iberia);
		listado.add(lufthansa);		
		Aeropuerto bilbao = new Aeropuerto(listado);
		
		bilbao.aviones.elementAt(0).checklistDespegue();
		bilbao.aviones.elementAt(0).permisoDespegue();
		bilbao.aviones.elementAt(0).checklistDespegue();
		
		listado.add(aireuropa);
		listado.add(vueling);	
		System.out.println(" ");
		
		bilbao.aviones.elementAt(3).checklistAterrizaje();
		bilbao.aviones.elementAt(3).permisoAterrizar();
		bilbao.aviones.elementAt(3).checklistAterrizaje();
	}

}
