package neon.utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileIO {

	public static String readFile(String filePath) {
		StringBuilder sb = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = br.readLine()) != null) {
				line = line.trim();
				line = line.replaceAll("\\s+", " ");
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
}
