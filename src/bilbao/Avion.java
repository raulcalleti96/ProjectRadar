package bilbao;

public class Avion implements PermisosDespegue, PermisosAterrizaje {

	private String nombre;
	private String origen;
	private String destino;
	private String rodadura;
	private int espera;
	private int pista;
	private boolean seleccion = false;
	private boolean radio = false;
	private boolean rutaAsignada = false;
	private boolean puestaenMarcha = false;
	private boolean preparadodespegue = false;
	private boolean despegar = false;
	private boolean contacto = false;
	private boolean apagado = false;

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

	public String pruebaRadio() {
		
		String estado = " ";
		
		if(radio == true) {
			
			estado = " Aceptada";
			
		}else {
			
			estado = " Denegada";
		}
		
		return estado;

	}

	public String asignarRuta() {
		
		String estado = " ";
		
		if(rutaAsignada == true) {
			
			estado = " Aceptada. Pista: " + pista;
			
		}else {
			
			estado = " Denegada";
		}
		
		return estado;
		
	}

	public String puestaenMarcha() {
		
	String estado = " ";
		
		if(puestaenMarcha == true) {
			
			estado = " Aceptada";
			
		}else {
			
			estado = " Denegada";
		}
		
		return estado;
	}

	public String despegue() {
		String estado = " ";
		
		if(despegar == true) {
			
			estado = " Aceptado";
			
		}else {
			
			estado = " Denegado";
		}
		
		return estado;
	}

	public void checklistDespegue() {

		if (radio == true && rutaAsignada == true && puestaenMarcha == true && despegar == true) {

			System.out.println("Se puede");
		} else {

			System.out.println("NO se puede");
		}

	}

	public boolean contacto() {
		Radar rBilbao = new Radar();
		System.out.println("Buenos días. aquí " + nombre + " establecido contacto ILS");

		if (rBilbao.contacto(nombre)) {
			contacto = true;
			return contacto;
		}
		return false;
	}

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

	public int tiempoEspera() {

		if (pista == 18) {

			if ("Y2".equalsIgnoreCase(rodadura)) {
				
				espera = 1;

			} else if ("A1".equalsIgnoreCase(rodadura)) {
				
				espera = 2;

			} else if ("C2".equalsIgnoreCase(rodadura)) {
				
				espera = 3;

			} else if ("E2".equalsIgnoreCase(rodadura)) {
				
				espera = 4;

			}

		} else if (pista == 29) {
			if ("Y2".equalsIgnoreCase(rodadura)) {
				
				espera = 3;

			} else if ("A1".equalsIgnoreCase(rodadura)) {
				
				espera = 2;

			} else if ("C2".equalsIgnoreCase(rodadura)) {
				
				espera = 4;

			} else if ("E2".equalsIgnoreCase(rodadura)) {
				
				espera = 1;

			}

		} else if (pista == 35) {
			if ("Y2".equalsIgnoreCase(rodadura)) {
				
				espera = 3;

			} else if ("A1".equalsIgnoreCase(rodadura)) {
				
				espera = 2;

			} else if ("C2".equalsIgnoreCase(rodadura)) {
				
				espera = 1;

			} else if ("E2".equalsIgnoreCase(rodadura)) {
				
				espera = 4;

			}

		} else if (pista == 11) {
			if ("Y2".equalsIgnoreCase(rodadura)) {
				
				espera = 3;

			} else if ("A1".equalsIgnoreCase(rodadura)) {
				
				espera = 1;

			} else if ("C2".equalsIgnoreCase(rodadura)) {
				
				espera = 2;

			} else if ("E2".equalsIgnoreCase(rodadura)) {
				
				espera = 4;

			}

		}

		return espera;

	}

	public int getEspera() {
		return espera;
	}

	public void setEspera(int espera) {
		this.espera = espera;
	}

	public boolean getPreparadodespegue() {
		return preparadodespegue;
	}

	public void setPreparadodespegue(boolean preparadodespegue) {
		this.preparadodespegue = preparadodespegue;
	}

}
