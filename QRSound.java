package ie.itsligo.roomrouter;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class QRSound {
	private static final int GOTO_ENGINEERING = 1; // Go to engineering message
	private static final int GOTO_BLOCKA = 2; // Go to block A
	private static final int GOTO_BLOCKB = 3; // Go to block B
	private static final int GOTO_BLOCKC = 4; // Go to block C
	private static final int GOTO_BLOCKD = 5; // Go to block D
	private static final int GOTO_BLOCKF = 6; // Go to block F

	public static void main(String[] args) {
		playit(GOTO_BLOCKA);
		delayfor(7);
		playit(GOTO_ENGINEERING);
		delayfor(7);	// delay for 7 seconds
		playit(GOTO_BLOCKB);
		delayfor(7);
		playit(GOTO_BLOCKC);
		delayfor(7);
		playit(GOTO_BLOCKD);
		delayfor(7);
		playit(GOTO_BLOCKF);
		delayfor(7);
	}
	
	public static void delayfor(int n)
	{
		try {
		    Thread.sleep(n * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
    /*
	 * Method is passed a sound flag it will play that sound there is only one
	 * currently supported. To use this sound - call new playit(SOUND);
	 */
	public static void playit(int soundRequired) {
		String fn = null;
		File sound; 
        URL location = QRSound.class.getProtectionDomain().getCodeSource().getLocation();
        
		switch (soundRequired) {
		case GOTO_ENGINEERING:
			System.out.println(location.getFile());
			fn = location.getFile() + "/resources/engineering.wav";
			
			break;
		case GOTO_BLOCKA:
			System.out.println(location.getFile());
			fn = location.getFile() + "/resources/blockA.wav";
			
			break;
		case GOTO_BLOCKB:
			System.out.println(location.getFile());
			fn = location.getFile() + "/resources/blockB.wav";
			
			break;
		case GOTO_BLOCKC:
			System.out.println(location.getFile());
			fn = location.getFile() + "/resources/blockC.wav";
			
			break;
		case GOTO_BLOCKD:
			System.out.println(location.getFile());
			fn = location.getFile() + "/resources/blockD.wav";
			
			break;
		case GOTO_BLOCKF:
			System.out.println(location.getFile());
			fn = location.getFile() + "/resources/blockF.wav";
			
			break;
		default:
			break;

		}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

