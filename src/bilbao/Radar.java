package bilbao;

public class Radar {
	private String nombre;
	private boolean radio = false;
	private boolean rutaAsignada = false;
	private boolean puestaenMarcha = false;
	private boolean despegar = false;
	private boolean contacto = false;
	private boolean apagado = false;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean getContacto() {
		return contacto;
	}

	public void setContacto(boolean contacto) {
		this.contacto = contacto;
	}

	public boolean Apagado() {
		return apagado;
	}

	public void setApagado(boolean apagado) {
		this.apagado = apagado;
	}
	
	
	public void permisos(){
		
	
	}


	public boolean pruebaRadio(String nombre) {	
		System.out.println( nombre  + " le recibo correctamente.");
		radio = true;
		return true;
	}

	public boolean asignarRuta(String nombre, String destino) {
		Aeropuerto bilbo = new Aeropuerto();
		System.out.println( nombre + " autorizado a " + destino  + ". Su plan de vuelo es: Pista " + bilbo.getPista1() + ".Viento: " + bilbo.getViento());
		rutaAsignada = true;
		return true;
		
	}


	public boolean puestaenMarcha(String nombre) {
		
		System.out.println(nombre  + " Puesta en marcha y retroceso aprobada");
		puestaenMarcha = true;
		return true;
		
	}


	public boolean despegue(String nombre) {
		
		System.out.println( nombre  + " aprobado para despegar. Buen vuelo");
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
	
	
	public boolean contacto(String nombre){
		
		Aeropuerto bilbo = new Aeropuerto();
		System.out.println( "Recibido " + nombre + " Viento:" + " ESTE" + " pista: " + bilbo.getPista1() + " Autorizado " + " para aterrizar en 40 segundos" + ".Pista de rodadura: " + bilbo.getRadadura1()+ " Puerta: " + bilbo.getPista2() ) ;
		contacto = true;
		return contacto;
		
	}
	
	public boolean apagadoMotores(String nombre, String destino) {
		
		System.out.println( nombre  + " Recibido. Buena estancia en " + destino);
		apagado = true;	
		return apagado;
	}

}
