package ie.itsligo.roomrouter;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Directions {
	private static final int GOTO_ENGINEERING = 1; // Go to engineering message
	private static final int GOTO_BLOCKA = 2; // Go to block A

	private final int ROOM_LENGTH = 5; // size of the room string
	private char building ;
	private char floor;
	private String locaationOnFloor = null;
	
	public Directions() {

	}

	
	public char getBuilding() {
		return building;
	}


	public void setBuilding(char building) {
		this.building = building;
	}


	public char getFloor() {
		return floor;
	}


	public void setFloor(char floor) {
		this.floor = floor;
	}


	public String getLocaationOnFloor() {
		return locaationOnFloor;
	}

	public void setLocaationOnFloor(String locaationOnFloor) {
		this.locaationOnFloor = locaationOnFloor;
	}

	/*
	 * This method takes in a room eg E2004 and splits up into the correct block
	 * (Engineering, Science, Business, etc) The correct floor The correct room
	 * number
	 */
	public boolean validate(String room) {
		if (room.length() != ROOM_LENGTH) {
			return false;
		}
		if (Character.isLetter(room.charAt(0)) == false) {
			return false; // room must start with a letter
		}
		for (int i = 1; i < ROOM_LENGTH; i++) {
			if (Character.isDigit(room.charAt(i)) == false) {
				return false; // room must start with a letter
			}
		}
		
		// all ok - store the info
		building = room.charAt(0);
		floor = room.charAt(1);
		locaationOnFloor = room.substring(2);
		
		return true;
	}
	
	/*
	 * Get directions to building
	 */
	public String toBuilding() {
		String directions = null;
		switch (this.building) {
		case 'A':
			QRSound.playit(GOTO_BLOCKA);// TODO play the sound here for this here
			directions = "From reception, walk straight ahead and then turn to your right";
			break;
		case 'B':
			// TODO play the sound here for this here
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest";
			break;
		case 'C':
			// TODO play the sound here for this here
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor";
			break;
		case 'D':
			// TODO play the sound here for this here
			directions = "rom reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor";
			break;
		case 'E':
			QRSound.playit(GOTO_ENGINEERING);// TODO play the sound here for this here
			directions = "From reception, move the the centre of reception and turn left into the engineering building";
			break;
		case 'F':
			// TODO play the sound here for this here
			directions = "From reception, walk outside and turn to your right.  Walk past the engineering building and the F block is straigt in front";
			break;
		default:
			directions = "Sorry, that building in not recognised";
			break;
			
		}
		return(directions);
	}
	
	/*
	 * Get directions to floor
	 */
	public String toFloor() {
		String directions = null;
		switch (this.floor) {
		case '0':
			// TODO play the sound here for this here
			directions = "Stay on this floor";
			break;
		case '1':
			// TODO play the sound here for this here
			directions = "Ascend the stairs or take the lift to the first floor";			
			break;
		case '2':
			// TODO play the sound here for this here
			directions = "Ascend two flight of stairs or take the lift to the second floor";			
			break;
		default:
			directions = "Sorry, floor " + this.floor + " is not recognised";
			break;
			
		}
		return(directions);
	}

	/*
	 * Get directions to floor
	 */
	public String toLocation() {
		String directions = null;
		switch (this.locaationOnFloor) {
		case "006":
			// TODO play the sound here for this here
			directions = "This is a room to the right on this level";
			break;
		case "007":
			// TODO play the sound here for this here
			directions = "This is a room to the right on this level";			
			break;
		case "003":
			// TODO play the sound here for this here
			directions = "This is the last room to the right on this level";			
			break;
		case "004":
			// TODO play the sound here for this here
			directions = "This is the second last room to the right on this level";			
			break;
		default:
			directions = "Sorry, that room in not recognised";
			break;
			
		}
		return(directions);
	}
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
