package resourses;

import java.applet.AudioClip;

public class SoundSystem {
	
	private AudioClip sound;
	
	public SoundSystem(String URL) {
		sound = java.applet.Applet.newAudioClip(getClass().getResource(URL));
		
	}
	
	public void tocarSom(){
		sound.play();
		
	}
	
	public void pararSom(){
		sound.stop();
		
	}
	
	public void loopSom(){
		sound.loop();
	}
	
	

}
