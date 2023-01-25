package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a destination
 *
 */
public interface ISymptomWriter {
	/**
	 *
	 * @param symptomMap - write symptoms to file
	 */
	void putSymptoms(Map<String, Integer> symptomMap);
}
