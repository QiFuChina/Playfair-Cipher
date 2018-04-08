package ie.gmit.sw.ai;

import java.util.Scanner;
import java.io.*;
public class Runner {
	public Runner() {
	}
	
	public static String readFile(String filename) throws Exception, Throwable {
		
		InputStream file = new FileInputStream(filename);
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		
		byte[] buffer = new byte[1024];
		int length;
		
		while ((length = file.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		file.close();
		return prime((result.toString().length() > 750) ? result.toString().substring(0, 750) : result.toString());
	}
	/*This method allows application read the text inside of file 
	 *After finish read, the byte buffer stream will be closed
	 *Then convert the result to string type 
	 */
	
	public static String prime(String p) {

		p = (p.length() % 2 == 0) ? p.toUpperCase().replaceAll("\\W", "").replaceAll("[0-9]", "").replace("J", "")
				: p.toUpperCase().replaceAll("\\W", "").replaceAll("[0-9]", "").replace("J", "") + "X";

		return removeDuplicates(p);
	}
	/*Edits plain text to make it become the excepted text
	 * */
	
	
	public static void main(String[] args) throws Exception, Throwable {
//	//
	System.out.println("Please input file likes: run.txt");
	Scanner s = new Scanner (System.in);
	ShuffleKey sk = new ShuffleKey();
	String file = s.nextLine(); 
	
	String message = readFile(file);
	String mess = sk.CiperBreaker(10, 50000, 1, message.toString());
	
	System.out.println("Please input key");
	String key = s.nextLine().toUpperCase();
	key = removeDuplicates(key).replaceAll("\\s+","");
//	String plainText = s.nextLine();
//	String plain = plainText.toUpperCase().replaceAll("[^A-Za-z0-9 ]", "");
//	plain=removeDuplicates(plain).replaceAll("\\s+","");
//	plain=plain.replaceAll("J","I");
//	

//	
	char replace = 'x';
//	
	System.out.println("Plain: " + file + " \nKey: " + key + "\nReplace: " + replace);
	char[] cipher = PlayFair.encrypt(file.toLowerCase().toCharArray(), key.toLowerCase().toCharArray(), replace);
	System.out.println("==========================================");  
	System.out.println("Cipher: " + new String(cipher).toUpperCase());
	char[] plain1 = PlayFair.decrypt(cipher, key.toLowerCase().toCharArray()); 
	System.out.println("New plain:" + new String(plain1));
    }
//	
	
	public static String removeDuplicates(String p) {
		StringBuilder noDupes = new StringBuilder();
		for (int i = 0; i < p.length(); i++) {
			String pt = p.substring(i, i + 1);
			if (noDupes.indexOf(pt) == -1)
				noDupes.append(pt);
		}
		return noDupes.toString();
	}

}
