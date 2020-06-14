package bilbao;

/**
 * Clase con la información de los aviones
 * 
 * @author: Pablo Borrego 
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
public class Avion implements PermisosDespegue, PermisosAterrizaje {

	// Variables con la información del avión
	private String nombre = null;
	private String origen = null;
	private String destino = null;
	private String rodadura = " ";
	private String horaDespegue = null;
	private String horaAterrizaje = null;
	private boolean seleccion = false;
	private boolean radio = false;
	private boolean rutaAsignada = false;
	private boolean puestaenMarcha = false;
	private boolean preparadodespegue = false;
	private boolean despegar = false;
	private boolean contacto = false;
	private boolean apagado = false;
	private int pista;

	/**
	 * Constructor que asigna a las variables los datos proporcionados
	 * 
	 * @param nombre  Matricula del avión
	 * @param origen  Origen del avión
	 * @param destino Destino del avión
	 */
	Avion(String nombre, String origen, String destino) {

		setNombre(nombre);
		setOrigen(origen);
		setDestino(destino);

	}

	/**
	 * Constructor vacio del avión
	 */
	public Avion() {
	}

	/**
	 * Método que proporciona el valor de la variable del avión
	 * @return Devuelve si ha contactado con la radio
	 */
	public boolean getRadio() {
		return radio;
	}

	/**
	 * Método que asigna el valor pasado como parámetro a la radio
	 * @param radio Asigna el valor del parámetro a radio
	 */
	public void setRadio(boolean radio) {
		this.radio = radio;
	}

	/**
	 * Método proporciona el valor pasado si se ha seleccionado
	 * @return Devuelve si se ha seleccionado el avión
	 */
	public boolean getSeleccion() {
		return seleccion;
	}

	/**
	 * Método que asigna el valor pasado como parámetro a la selección
	 * @param seleccion Asigna el valor del parámetro a radio
	 */
	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}
	
	/**
	 * Método proporciona el valor pasado si se ha contactado
	 * @return Devuelve si se ha contactado
	 */
	public boolean getContacto() {
		return contacto;
	}
   /**
	 * Método que asigna el valor pasado como parámetro a la contacto
	 * @param contacto Asigna el valor del parámetro a contacto
	 */
	public void setContacto(boolean contacto) {
		this.contacto = contacto;
	}

	/**
	 * Método proporciona el valor pasado si se ha apagado
	 * @return Devuelve si se ha apagado
	 */
	public boolean getApagado() {
		return apagado;
	}

	/**
	  * Método que asigna el valor pasado como parámetro a la apagado
	  * @param apagado Asigna el valor del parámetro a apagado
	  */	
	public void setApagado(boolean apagado) {
		this.apagado = apagado;
	}
	/**
	 * Método proporciona el valor pasado del origen del avión
	 * @return Devuelve el origen del avión
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	  * Método que asigna el valor pasado como parámetro al origen 
	  * @param origen Asigna el valor del parámetro al origen
	  */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * Método proporciona el valor pasado su destino
	 * @return Devuelve el destino del vuelo
	 */
	public String getDestino() {
		return destino;
	}
	/**
	  * Método que asigna el valor pasado como parámetro a la destino
	  * @param destino Asigna el valor del parámetro a destino
	  */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/**
	 * Método proporciona el valor pasado si se ha asignado la ruta
	 * @return Devuelve si se ha asignado
	 */
	public boolean getRutaAsignada() {
		return rutaAsignada;
	}
	/**
	  * Método que asigna el valor pasado como parámetro a la rutaAsignada
	  * @param rutaAsignada Asigna el valor del parámetro a rutaAsignada
	  */
	public void setRutaAsignada(boolean rutaAsignada) {
		this.rutaAsignada = rutaAsignada;
	}
	/**
	 * Método proporciona el valor pasado esta en puesta en marcha
	 * @return Devuelve si está en puesta en marcha
	 */
	public boolean getPuestaenMarcha() {
		return puestaenMarcha;
	}
	/**
	  * Método que asigna el valor pasado como parámetro a la puestaenMarcha
	  * @param puestaenMarcha Asigna el valor del parámetro a puestaenMarcha
	  */
	public void setPuestaenMarcha(boolean puestaenMarcha) {
		this.puestaenMarcha = puestaenMarcha;
	}
	/**
	 * Método proporciona el valor pasado está preparado para despegar
	 * @return Devuelve si está está preparado para despegar
	 */
	public boolean getDespegar() {
		return despegar;
	}
	/**
	  * Método que asigna el valor pasado como parámetro a la despegar
	  * @param despegar Asigna el valor del parámetro a despegar
	  */
	public void setDespegar(boolean despegar) {
		this.despegar = despegar;
	}
	/**
	 * Método proporciona el valor pasado el nombre del avión
	 * @return Devuelve el nombre del avión
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	  * Método que asigna el valor pasado como parámetro al nombre
	  * @param nombre Asigna el valor del parámetro a nombre
	  */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Método proporciona el valor pasado el número de pista
	 * @return Devuelve el número de pista
	 */
	public int getPista() {
		return pista;
	}
	/**
	  * Método que asigna el valor pasado como parámetro a la pista
	  * @param pista Asigna el valor del parámetro a pista
	  */
	public void setPista(int pista) {
		this.pista = pista;
	}
	/**
	 * Método proporciona el valor pasado el número de rodadura
	 * @return Devuelve el número de rodadura
	 */
	public String getRodadura() {
		return rodadura;
	}
	/**
	  * Método que asigna el valor pasado como parámetro a la rodadura
	  * @param rodadura Asigna el valor del parámetro a rodadura
	  */
	public void setRodadura(String rodadura) {
		this.rodadura = rodadura;
	}
	/**
	 * Método proporciona si está preparado para el despegue
	 * @return Devuelve si está preparado para el despegue
	 */
	public boolean getPreparadodespegue() {
		return preparadodespegue;
	}
	/**
	  * Método que asigna el valor pasado como parámetro a preparadodespegue
	  * @param preparadodespegue Asigna el valor del parámetro a preparadodespegue
	  */
	public void setPreparadodespegue(boolean preparadodespegue) {
		this.preparadodespegue = preparadodespegue;
	}
	/**
	 * Método proporciona la hora del despegue
	 * @return Devuelve la hora hora de despegue
	 */
	public String getHoraDespegue() {
		return horaDespegue;
	}
	/**
	  * Método que asigna el valor pasado como parámetro a la hora de despegue
	  * @param horaDespegue Devuelve la hora de despegue
	  */
	public void setHoraDespegue(String horaDespegue) {
		this.horaDespegue = horaDespegue;
	}
	/**
	 * Método proporciona la hora del aterrizaje
	 * @return Devuelve la hora hora de aterrizaje
	 */
	public String getHoraAterrizaje() {
		return horaAterrizaje;
	}
	/**
	  * Método que asigna el valor pasado como parámetro a la hora de aterrizaje
	  * @param horaAterrizaje Devuelve la hora de aterrizaje
	  */
	public void setHoraAterrizaje(String horaAterrizaje) {
		this.horaAterrizaje = horaAterrizaje;
	}
	
	
	/**
	 * Método que comprueba el estado de la prueba de radio y lo imprime en String
	 *@return estado de la radio 
	 */
	public String pruebaRadio() {

		String estado = " ";

		if (radio == true) {

			estado = " Aceptada";

		} else {

			estado = " Denegada";
		}

		return estado;

	}

	/**
	 * Método que comprueba el estado de la pista y lo imprime
	 * @return estado de la pista y el número de pista
	 */
	
	public String asignarRuta() {

		String estado = " ";

		if (rutaAsignada == true) {

			estado = " Aceptada. Pista: " + pista;

		} else {

			estado = " Denegada";
		}

		return estado;

	}

	/**
	 * Método para comprobar el estado de la puesta en marcha
	 * @return estado de la petición
	 */
	public String puestaenMarcha() {

		String estado = " ";

		if (puestaenMarcha == true) {

			estado = " Aceptada";

		} else {

			estado = " Denegada";
		}

		return estado;
	}

	/**
	 * Método para comprobar el estado de la petición de despegue
	 * @return estado de la petición para despegar
	 */	
	public String despegue() {
		String estado = " ";

		if (despegar == true) {

			estado = " Aceptado";

		} else {

			estado = " Denegado";
		}

		return estado;
	}

	/**
	 * Método para comprobar si se ha establecido conexión con la torre
	 * @return estado del contacto
	 */		
	public String estadoContacto() {

		String estado = " ";

		if (contacto == true) {

			estado = " Aceptado";

		} else {

			estado = " Denegado";
		}

		return estado;

	}

	/**
	 * Método para comprobar si ya se asignó una pista de rodadura
	 * @return rodadura asignada
	 */	
	public String estadoRodadura() {

		String estado = " ";

		if (rodadura == null) {

			estado = "Ninguna";

		} else {

			estado = rodadura;
		}

		return estado;

	}
	/**
	 * Método para comprobar el estado de los motores
	 * @return estado de los motores
	 */	
	public String motores() {

		String estado = " ";

		if (radio == true) {

			estado = " Aceptada";

		} else {

			estado = " Denegada";
		}

		return estado;

	}
	/**
	 * Método para dar información de los aviones y hora de despegue
	 * @return información del avión y hora de despegue
	 */	
	public String infoAvionDesText() {

		return "Avión: " + nombre + "| Origen:" + origen + "| Destino: " + destino + " | Hora despegue: "
				+ horaDespegue;

	}
	/**
	 * Método para dar información de los aviones y hora de aterrizaje
	 * @return información del avión y hora de aterrizaje
	 */	
	public String infoAvionAteText() {

		return "Avión: " + nombre + "| Origen:" + origen + "| Destino: " + destino + " | Hora aterrizaje: "
				+ horaAterrizaje;

	}

}
