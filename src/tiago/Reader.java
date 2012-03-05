package tiago;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Reader {

	private File file;
	
	private FileReader fReader;
	
	private BufferedReader buffReader;
	
	public Reader(File file) {
		this.file = file;
	}
	
	public String load() {

		StringBuilder builder = new StringBuilder();
		
		try {
			fReader = new FileReader(file);
			buffReader = new BufferedReader(fReader);
			
			String line = null;
			while((line = buffReader.readLine()) != null) {
				builder.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
}
