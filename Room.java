package ie.itsligo.roomrouter;

public class Room {
	private String room;

	public Room() {
		
	}
	
	public String get(String data)
	{
	
		room = null;
		// TODO extract the room number eg E2004 from the data passed in
		// Here you write the code to parse the data string and extract
		// the room
		
		System.out.print("[" + data + "]");
		String delims = ":";
		String[] tokens = data.split(delims);
		
		for (int i = 0; i < tokens.length; i++)
			System.out.println(i + "]" + tokens[i]);
		
		System.out.println("[" + tokens[6] + "]");
		room = tokens[6] ;
		return(room.trim());
	}

}
