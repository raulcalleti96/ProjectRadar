package dialogos;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Hilo que proporciona el sonido real de la radio del Aeropuerto Internacional de Tampa Bay de E.E.U.U
 * 
 * @author: Pablo Borrego
 * @author: Raul Santiago 
 * 
 * @version: 1.2020
 * 
 */

public class Radio extends Thread{
	
	/**
	 * Constructor de la clase que ejecuta el sonido
	 */
	public Radio() {
		
		run();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		try {

			//Clase que proporciona el sistema para reproducir el audio
			Clip sonido = AudioSystem.getClip();

			//Se abre el fichero con el archivo de audio
			sonido.open(AudioSystem.getAudioInputStream(new File("radio.wav")));

			//Ejecuta el audio
			sonido.start();


		} catch (Exception a) {
		}
	}
    

}
