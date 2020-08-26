package neon.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import neon.meat.program.Executable;

public class FileIO {

	public static String readFileSource(String filePath) {
		StringBuilder sb = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = br.readLine()) != null) {
				line = line.trim();
				line = line.replaceAll("\\s+", " ");
				sb.append(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static Executable readFileExecutable(String filePath) {
		Executable exe = null;
		
		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			exe = (Executable) objectIn.readObject();
			objectIn.close();
			fileIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exe;
	}
	
	public static void writeFileExecutable(String filePath, Executable exe) {
		filePath = filePath.replace(".nsf", ".neon");
		System.out.println("Writing to " + filePath);
		try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(exe);
			objectOut.flush();
			objectOut.close();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
