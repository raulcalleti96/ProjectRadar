package bilbao;

public class Avion implements PermisosDespegue, PermisosAterrizaje {

	private String nombre;
	private String origen;
	private String destino;
	private boolean radio = false;
	private boolean rutaAsignada = false;
	private boolean puestaenMarcha = false;
	private boolean despegar = false;
	private boolean contacto = false;
	private boolean apagado = false;

	Avion(String nombre, String origen, String destino) {

		setNombre(nombre);
		setOrigen(origen);
		setDestino(destino);

	}

	Avion() {
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

	public void permisoDespegue() {

		pruebaRadio();
		asignarRuta();
		puestaenMarcha();
		despegue();

	}

	public void permisoAterrizar() {

		contacto();
		apagadomotores();

	}

	@Override
	public boolean pruebaRadio() {
		Radar rBilbao = new Radar();

		System.out.println("Muy buenas. Aquí " + nombre + " para prueba de radio");

		if (rBilbao.pruebaRadio(nombre)) {
			radio = true;
			return true;
		}
		return false;
	}

	@Override
	public boolean asignarRuta() {
		Radar rBilbao = new Radar();
		System.out.println(nombre + " solicitamos ruta para " + destino);

		if (rBilbao.asignarRuta(nombre, destino)) {
			rutaAsignada = true;
			return rutaAsignada;
		}

		return false;
	}

	@Override
	public boolean puestaenMarcha() {
		Radar rBilbao = new Radar();
		System.out.println("Listos para puesta en marcha y retroceso.");

		if (rBilbao.puestaenMarcha(nombre)) {
			puestaenMarcha = true;
			return puestaenMarcha;
		}
		return false;
	}

	@Override
	public boolean despegue() {
		Radar rBilbao = new Radar();
		System.out.println(nombre + " en punto de espera para despegar");

		if (rBilbao.despegue(nombre)) {
			despegar = true;
			return despegar;
		}
		return false;
	}

	public void checklistDespegue() {

		if (radio == true && rutaAsignada == true && puestaenMarcha == true && despegar == true) {

			System.out.println("Se puede");
		} else {

			System.out.println("NO se puede");
		}

	}

	@Override
	public boolean contacto() {
		Radar rBilbao = new Radar();
		System.out.println("Buenos días. aquí " + nombre + " establecido contacto ILS");

		if (rBilbao.contacto(nombre)) {
			contacto = true;
			return contacto;
		}
		return false;
	}

	@Override
	public boolean apagadomotores() {
		Radar rBilbao = new Radar();
		System.out.println(nombre + " apagado de motores. Gracias");
		if (rBilbao.apagadoMotores(nombre, destino)) {
			apagado = true;
			return apagado;
		}

		return false;

	}

	public void checklistAterrizaje() {

		if (contacto == true) {

			System.out.println("Se puede");
		} else {

			System.out.println("NO se puede");
		}

	}

}
