package ie.gmit.sw.ai;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
	//
	System.out.println("Input plainText");
	Scanner s = new Scanner (System.in);
	String plainText = s.nextLine();
	String plain = plainText.toUpperCase().replaceAll("[^A-Za-z0-9 ]", "");
	plain=removeDuplicates(plain).replaceAll("\\s+","");
	plain=plain.replaceAll("J","I");
	
	System.out.println("Input keyText");
	String key = s.nextLine();
	
	char replace = 'x';
	
	System.out.println("Plain: " + plain + " \nKey: " + key + "\nReplace: " + replace);
	char[] cipher = CipherBreaker.encrypt(plain.toLowerCase().toCharArray(), key.toLowerCase().toCharArray(), replace);
	System.out.println("==========================================");  
	System.out.println("Cipher: " + new String(cipher).toUpperCase());
	char[] plain1 = CipherBreaker.decrypt(cipher, key.toLowerCase().toCharArray()); 
	System.out.println("New plain:" + new String(plain1));
}
	
	
	public static String removeDuplicates(String s) {
		StringBuilder noDupes = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			String si = s.substring(i, i + 1);
			if (noDupes.indexOf(si) == -1)
				noDupes.append(si);
		}
		return noDupes.toString();
	}

}
