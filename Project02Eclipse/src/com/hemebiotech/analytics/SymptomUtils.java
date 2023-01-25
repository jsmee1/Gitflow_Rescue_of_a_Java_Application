package com.hemebiotech.analytics;

import java.util.*;
//import java.util.stream.Collectors;

/**
 * Symptom analysis tools
 * countSymptoms and sortSymptoms methods
 */
public class SymptomUtils {
    /**
     * Count symptoms
     * @param symptomList the list of symptoms
     * @return the occurrence of each symptom
     */
    public static Map<String, Integer> countSymptoms(List<String> symptomList) {
        Map<String, Integer> myMap = new HashMap<>();
        for (String symptom : symptomList) {
            Integer value = myMap.get(symptom);
            if (value == null)
                myMap.put(symptom, 1);
            else
                myMap.put(symptom, value+1);
        }
        return myMap;
    }

    /**
     * Sort symptoms by name
     * @param symptomMap - list of symptom occurrences
     * @return list of symptom occurrences sorted by name
     */
    public static TreeMap<String, Integer> sortSymptoms(Map<String, Integer> symptomMap) {
        return new TreeMap<String, Integer>(symptomMap);
    }

}
