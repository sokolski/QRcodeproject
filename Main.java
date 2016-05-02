package ie.itsligo.roomrouter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Main {

		static JTextField textField = null;
		static String qrCodeData = "Day: Tuesday\nTime: 09:00 to 11:00\nSubject: Software Engineering\nRoom: E2004";
		static String filePath = "myQRCode.png";
		
		static QR qr = new QR(qrCodeData, filePath);
		static Room room = new Room();
		static Directions directions = new Directions();

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String[] args) throws WriterException, IOException, NotFoundException {
			// Initial hardcoded data for test program 
			String qrCodeData = "Day: Tuesday\nTime: 09:00 to 11:00\nSubject: Software Engineering\nRoom: E2004";
			String filePath = "myQRCode.png";
			
			Map hintMap = new HashMap();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

			// create the QR barcode
			qr.createQRCode(qrCodeData, filePath, hintMap, 200, 200);
			System.out.println("QR Code image created successfully!");

			// read the barcode
			String QRdata = qr.readQRCode(filePath, hintMap);
			System.out.println("The barcode reads : " + QRdata);
			
			// Find the room
			String theRoom = room.get(QRdata);
			System.out.println("The room is " + theRoom);
			
			// get directions
			if (directions.validate(theRoom) == false) {
				System.out.println("The directions to this room are unknown");
			}
			else {
				System.out.println("DIRECTIONS");
				System.out.println(directions.toBuilding());
				System.out.println(directions.toFloor());
				System.out.println(directions.toLocation());
			}
			
			
		}


}
