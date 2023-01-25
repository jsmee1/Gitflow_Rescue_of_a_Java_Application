package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class SymptomReader implements ISymptomReader {

	private final String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SymptomReader(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		List<String> symptomList = new ArrayList<>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					// Trim symptom names, convert to lowercase and reject if not alphanumeric.
					// Reject empty lines.
					line = line.trim();
					line = line.toLowerCase();
					boolean isAlphaNumeric = true;
					for (int i=0; i<line.length(); i++) {
						if (line.charAt(i)!=' ' && !Character.isLetterOrDigit(line.charAt(i)))
							isAlphaNumeric = false;
					}
					if (isAlphaNumeric && !line.isEmpty()) {
						symptomList.add(line);
					}
					line = reader.readLine();
				}
				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println("File \"" + filepath + "\" not found.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return symptomList;
	}

}
