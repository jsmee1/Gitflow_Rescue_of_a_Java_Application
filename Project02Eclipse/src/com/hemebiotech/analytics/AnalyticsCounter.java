package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * New version of AnalyticsCounter
 * Count symptoms and sort them alphabetically
 */
public class AnalyticsCounter {
	/**
	 * Read symptoms from file, count and sort symptoms alphabetically, and write results to file
	 * @param symptomFilename input file containing one symptom per line
	 * @param resultFilename output file containing the symptom tally ordered alphabetically
	 */
	public static void analyticsCount(String symptomFilename, String resultFilename) {
		List<String> symptomList;
		Map<String, Integer> symptomMap;
		// Read symptoms into a list, clean data and convert to lowercase
		ISymptomReader reader = new SymptomReader(symptomFilename);
		symptomList = reader.getSymptoms();
		if (symptomList.isEmpty())
			System.out.println("No symptoms found");
		else {
			// Count symptoms, sort them alphabetically and write to file
			symptomMap = SymptomUtils.countSymptoms(symptomList);
			symptomMap = SymptomUtils.sortSymptoms(symptomMap);
			ISymptomWriter writer = new SymptomWriter(resultFilename);
			writer.putSymptoms(symptomMap);
		}

	}
	/**
	 *
	 * @param  args - default unused parameter
	 */
	public static void main(String[] args) {

		analyticsCount("symptoms.txt", "result.out");
	}
}
