package dialogos;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Radio extends Thread{
	
	public Radio() {
		
		run();
	}
	
	public void run(){
		try {

			Clip sonido = AudioSystem.getClip();

			sonido.open(AudioSystem.getAudioInputStream(new File("radio.wav")));

			sonido.start();

			

			

		} catch (Exception a) {
		}
	}
    

}
