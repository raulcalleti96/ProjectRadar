package bilbao;

public class Avion implements PermisosDespegue{
	
	static private String nombre;
	private String origen;
	static private String destino;
	private boolean radio = false;
	private boolean rutaAsignada = false;
	private boolean puestaenMarcha = false;
	private boolean despegar = false;
	
	
	Avion(String nombre, String origen, String destino){
		
		setNombre(nombre);
		setOrigen(origen);
		setDestino(destino);
		
	}
	
	Avion(){}
	
	
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public boolean getRadio() {
		return radio;
	}

	public void setRadio(boolean radio) {
		radio = this.radio;
	}

	public boolean setRutaAsignada() {
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



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void permisos() {
		
		pruebaRadio();
		asignarRuta();
		puestaenMarcha();
		despegue();
		
	}

	@Override
	public boolean pruebaRadio(){
		Radar rBilbao = new Radar();
		
		System.out.println("Muy buenas. Aquí " + nombre + " para prueba de radio");
		
		if(rBilbao.pruebaRadio()) {
			radio = true;
			return true;
		}
		return false;
	}

	@Override
	public boolean asignarRuta() {
		Radar rBilbao = new Radar();
		System.out.println(nombre + " solicitamos ruta para " + destino);
		
		if(rBilbao.asignarRuta()) {
			rutaAsignada = true;
		return true;
		}
		
		return false;
	}

	@Override
	public boolean puestaenMarcha() {
		Radar rBilbao = new Radar();
		System.out.println("Listos para puesta en marcha y retroceso.");
		
		if(rBilbao.puestaenMarcha()) {
			puestaenMarcha = true;
			return true;
		}
		return false;
	}

	@Override
	public boolean despegue() {
		Radar rBilbao = new Radar();
		System.out.println(nombre + " en punto de espera para despegar");
		
		if(rBilbao.despegue()) {
			despegar = true;
			return true;
		}
		return false;
	}



}
