package ie.gmit.sw.ai;

import java.io.*;
import java.io.File;
import java.util.HashMap;

public class HashGram {

	
private static final HashMap<String,Double> map = new HashMap<String,Double>(); 
	
	/**
	 * Calculate the total number of counts for the entire file. 
	 */
	private static double total;
	static{
		File file = new File("./4grams.txt");
		InputStream in;
		try {
			in = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));  
	        String line = null;
	        while((line = br.readLine()) != null){
	           String[] str = line.split(" ");
	           total = total + Double.parseDouble(str[1]); 
	           map.put(str[0], Double.parseDouble(str[1])); 
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	public static void setTotal(double total) {
		HashGram.total = total;
	}

	public static HashMap<String, Double> getMap() {
		return map;
	}

	public static double getTotal() {
		// TODO Auto-generated method stub
		return total;
	}

}
