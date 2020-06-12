package dialogos;

import bilbao.Control;

public class Cuentaatras extends Thread {

	Control control = null;
	// Contructor porque la clase es heredada
	public Cuentaatras(Control control) {
		super();
		this.control = control;
		
	}
	
	// El Contador de minutos
	public static int nuMin = 0;
	// El Contador de de segundos
	public static int nuSeg = 0;
	// El Contador de Horas
	public static int nuHora = 0;

	
	public void run() {
		// si ocurre un error al dormir el proceso(sleep(999))
		try {
			// inicio del for infinito
			for (;;) {
				// si no es el ultimo segundo
				if (nuSeg != 0) {
					// decremento el numero de segundos
					nuSeg--; 
				} else {
					// si no es el ultimo minuto
					if (nuMin != 0) {
						// segundos comienzan en 59
						nuSeg = 59;
						// decremento el numero de minutos
						nuMin--;
					} else {
						
						if (nuHora != 0) {
							
							// decremento el numero de horas
							nuHora--;
							// minutos comienzan en 59
							nuMin = 59;
							// segundos comienzan en 59
							nuSeg = 59;
						} else {
							// se acabo el tiempo fin hilo
							break;
						}
					}
				}
				// Muestro en pantalla el temporizador
				System.out.println(nuHora + ":" + nuMin + ":" + nuSeg);
				// Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
				sleep(998);
			}
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		} // Fin try
		
	}
	
}
