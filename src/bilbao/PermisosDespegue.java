package bilbao;
/**
 * Interfaz que contiene los métodos necesarios para  conocer el estado el despegue
 * 
 * @author: Pablo Borrego
 * @author: Raul Santiago
 * 
 * @version: 1.2020
 * 
 */
 public interface PermisosDespegue {

	 /**
	  * Método que proporciona si se ha establecido contacto de radio
	  * @return Devuelve el estado de la radio
	  */
	 public String pruebaRadio();
	 
	 /**
	  * Método que proporciona si ya está asignada la pista y cuál
	  * @return Devuelve la ruta asignada
	  */
	 public String asignarRuta();
	 
	 /**
	  * Método que proporciona la pista de rodadura
	  * @return Devuelve la pista de rodadura
	  */
	 public String puestaenMarcha();
	 
	 /**
	  * Método que proporciona si el avion puede despegar
	  * @return Devuelve el estado del despegue
	  */
	 public String despegue();
}
