package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in0
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		int x = 0;
		for(int i=0; i<base64Chars.length; i++) { 
			if(base64Chars[i]==c) {
				x = i;
			}
		}
		
		return (byte) x;
		
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
	
		
		byte[] test = new byte[3];
		//System.out.println((byte)convertBase64Char(s.charAt(0)));
		//System.out.println((byte) (convertBase64Char(s.charAt(0))));
		//System.out.println((byte) s.charAt(2));
	//	System.out.println((byte) (convertBase64Char(s.charAt(0)) | convertBase64Char(s.charAt(1)) ));
		test[0] =  (byte) (convertBase64Char(s.charAt(0)) <<2 | convertBase64Char(s.charAt(1)) >>4 );
		test[1] =  (byte) (convertBase64Char(s.charAt(1)) << 4  |convertBase64Char(s.charAt(2)) >>2);
		test[2] =  (byte) ((convertBase64Char(s.charAt(2)) << 4) | (convertBase64Char(s.charAt(3))>>0));
		//test[1] = (byte) (s.charAt(1) >>2 | s.charAt(2 <<4));
	//	System.out.println(test[0]);
		//System.out.println(test[1]);
		//System.out.println(test[2]);
		
		
		//do the shifting only?
		//shift characters 
	
				
				
				
	//Bw1+
	//1 48 53 63
		return test;
	}
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file)  {
	
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_04_Base64_Decoder/base64_data.txt"));
			String line = br.readLine();
			
		
			byte[] test = new byte[line.length()];
			for(int i=0; i<line.length()-1; i++) {
				if(i == line.length()-2) {
					System.out.println("lol");
					test[i] = (byte) (convertBase64Char(line.charAt(i)) <<2 | convertBase64Char(line.charAt(i+1)) >>0 );
				}
				if((i)%2 ==0) {
					test[i] = (byte) (convertBase64Char(line.charAt(i)) <<2 | convertBase64Char(line.charAt(i+1)) >>2 );
				}
				else {
					test[i] = (byte) (convertBase64Char(line.charAt(i)) <<2 | convertBase64Char(line.charAt(i+1)) >>2 );
				}
				
				System.out.println(test[i]); //shift the unused
			}
			
			br.close();
			return test;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
return null;
		// aaaa =0000
		//////=-1

	}
	
}
