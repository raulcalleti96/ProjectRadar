package bilbao;

public class Radar implements PermisosDespegue{
	private String nombre;
	private boolean radio = false;
	private boolean rutaAsignada = false;
	private boolean puestaenMarcha = false;
	private boolean despegar = false;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	public void permisos() {
		
	
	}


	public boolean pruebaRadio() {
		Avion nuevo = new Avion();
		Aeropuerto bilbo = new Aeropuerto();
		System.out.println( nuevo.getNombre() + " le recibo correctamente.");
		radio = true;
		return true;
	}

	public boolean asignarRuta() {
		Avion nuevo = new Avion();
		Aeropuerto bilbo = new Aeropuerto();
		System.out.println( nuevo.getNombre() + " autorizado a " + nuevo.getDestino() + ". Su plan de vuelo es: Pista " + bilbo.getPista1() + ".Viento: " + bilbo.getViento());
		rutaAsignada = true;
		return true;
		
	}


	public boolean puestaenMarcha() {
		Avion nuevo = new Avion();
		Aeropuerto bilbo = new Aeropuerto();
		System.out.println( nuevo.getNombre() + " Puesta en marcha y retroceso aprobada");
		puestaenMarcha = true;
		return true;
		
	}


	public boolean despegue() {
		Avion nuevo = new Avion();
		Aeropuerto bilbo = new Aeropuerto();
		System.out.println( nuevo.getNombre() + " aprobado para despegar. Buen vuelo");
		despegar = true;
		return true;
		
	}

	public boolean getRadio() {
		return radio;
	}

	public void setRadio(boolean radio) {
		radio = this.radio;
	}

	public boolean getRutaAsignada() {
		return rutaAsignada;
	}

	public void setRutaAsignada(boolean rutaAsignada) {
		this.rutaAsignada = rutaAsignada;
	}

	public boolean getPuestaenMarcha() {
		return puestaenMarcha;
	}

	public void setPuestaenMarcha(boolean puestaenMarcha) {
		this.puestaenMarcha = puestaenMarcha;
	}

	public boolean getDespegar() {
		return despegar;
	}

	public void setDespegar(boolean despegar) {
		this.despegar = despegar;
	}

}
