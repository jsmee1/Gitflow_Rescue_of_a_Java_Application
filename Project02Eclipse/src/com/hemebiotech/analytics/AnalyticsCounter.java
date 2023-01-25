package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {

	public static void main(String[] args) throws Exception {
		// initialize each symptom counter
		int headacheCount = 0;
		int rashCount = 0;
		int pupilCount = 0;

		List<String> symptomList = new ArrayList<>();
		Map<String, Integer> symptomMap = new HashMap<>();

		// read first symptom
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		// read symptoms until end of file
		while (line != null) {
//            System.out.println("symptom from file: " + line);
			symptomList.add(line);
			line = reader.readLine();	// get next symptom
		}

		// count symptoms
		for (String symptom : symptomList) {
			Integer value = symptomMap.get(symptom);
			if (value == null)
				symptomMap.put(symptom, 1);
			else
				symptomMap.put(symptom, value+1);
		}

		// Copy the Map into a TreeMap to sort it
		TreeMap<String, Integer> mySortedMap = new TreeMap<>(symptomMap);

		// write symptom tally
		FileWriter writer = new FileWriter ("result.out");
		mySortedMap.entrySet().forEach(entry -> {
			try {
				writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
			} catch(IOException e) {e.printStackTrace();}
		});
		writer.close();

	}
}
