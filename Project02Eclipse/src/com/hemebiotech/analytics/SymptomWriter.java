package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class SymptomWriter implements ISymptomWriter {

	private final String filepath;

	/**
	 *
	 * @param filepath a full or partial path to file with on each line a symptom and occurrence
	 */
	public SymptomWriter(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void putSymptoms(Map<String, Integer> symptomMap) {

		if (filepath != null) {
			try {
//				File f = new File(filepath);
				FileWriter writer = new FileWriter (filepath);
				symptomMap.entrySet().forEach(entry -> {
					try {
						writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
					} catch(IOException e) {e.printStackTrace();}
				});
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
