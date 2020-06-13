package bilbao;

public class Avion implements PermisosDespegue, PermisosAterrizaje {

	private String nombre = null;
	private String origen = null;
	private String destino = null;
	private String rodadura = " ";
	private String horaDespegue= null;
	private String horaAterrizaje= null;
	private boolean seleccion = false;
	private boolean radio = false;
	private boolean rutaAsignada = false;
	private boolean puestaenMarcha = false;
	private boolean preparadodespegue = false;
	private boolean despegar = false;
	private boolean contacto = false;
	private boolean apagado = false;
	private int pista;
 

	Avion(String nombre, String origen, String destino) {

		setNombre(nombre);
		setOrigen(origen);
		setDestino(destino);

	}
	
	
 
	public Avion() {
	}

	public boolean getRadio() {
		return radio;
	}

	public void setRadio(boolean radio) {
		this.radio = radio;
	}

	public boolean getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}

	public boolean getContacto() {
		return contacto;
	}

	public void setContacto(boolean contacto) {
		this.contacto = contacto;
	}

	public boolean getApagado() {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPista() {
		return pista;
	}

	public void setPista(int pista) {
		this.pista = pista;
	}

	public String getRodadura() {
		return rodadura;
	}

	public void setRodadura(String rodadura) {
		this.rodadura = rodadura;
	}

	public boolean getPreparadodespegue() {
		return preparadodespegue;
	}

	public void setPreparadodespegue(boolean preparadodespegue) {
		this.preparadodespegue = preparadodespegue;
	}
	


	public String getHoraDespegue() {
		return horaDespegue;
	}

	public void setHoraDespegue(String horaDespegue) {
		this.horaDespegue = horaDespegue;
	}

	public String getHoraAterrizaje() {
		return horaAterrizaje;
	}

	public void setHoraAterrizaje(String horaAterrizaje) {
		this.horaAterrizaje = horaAterrizaje;
	}
	
	public String pruebaRadio() {

		String estado = " ";

		if (radio == true) {

			estado = " Aceptada";

		} else {

			estado = " Denegada";
		}

		return estado;

	}

	public String asignarRuta() {

		String estado = " ";

		if (rutaAsignada == true) {

			estado = " Aceptada. Pista: " + pista;

		} else {

			estado = " Denegada";
		}

		return estado;

	}

	public String puestaenMarcha() {

		String estado = " ";

		if (puestaenMarcha == true) {

			estado = " Aceptada";

		} else {

			estado = " Denegada";
		}

		return estado;
	}

	public String despegue() {
		String estado = " ";

		if (despegar == true) {

			estado = " Aceptado";

		} else {

			estado = " Denegado";
		}

		return estado;
	}
 

	
	public String estadoContacto() {

		String estado = " ";

		if (contacto == true) {

			estado = " Aceptado";

		} else {

			estado = " Denegado";
		}

		return estado;

	}
	

	public String estadoRodadura() {

		String estado = " ";

		if (rodadura == null) {

			estado = "Ninguna";

		} else {

			estado = rodadura;
		}

		return estado;

	}
	public String motores() {

		String estado = " ";

		if (radio == true) {

			estado = " Aceptada";

		} else {

			estado = " Denegada";
		}

		return estado;

	}




	public String infoAvionDesText() {

		return "Avión: " + nombre + "| Origen:" + origen + "| Destino: " + destino + " | Hora despegue: "
				+ horaDespegue;

	}

	public String infoAvionAteText() {

		return "Avión: " + nombre + "| Origen:" + origen + "| Destino: " + destino + " | Hora aterrizaje: "
				+ horaAterrizaje;

	}



	
	



}
