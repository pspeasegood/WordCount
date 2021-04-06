package Synalogik.WordCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCount {
	
	
	Map<Integer,Integer> wordBreakdown = new HashMap<>();
	
	/**
	 * Breaks down a string input into word length and occurrences
	 * @param input
	 */
	public void WordBreakdown(String input) {
		wordBreakdown = new HashMap<>();
		if(input.isBlank()) {
			return;
		}
		
		String[] words = input.trim().split("\\s+");
		for (String word : words) {
			// remove punctuation on end of word.
			word = word.replaceAll("\\w(\\.|!|\\?|,)$", "A"); 
			int wordLengh = word.length();
			if(wordBreakdown.containsKey(wordLengh)) {
				wordBreakdown.put(wordLengh, wordBreakdown.get(wordLengh) + 1);
			} else {
				wordBreakdown.put(wordLengh, 1);
			}
			
		}
	}
	
	/**
	 * Returns a Map with full breakdown of word length and number of occurrences 
	 * @return
	 */
	public Map<Integer,Integer> getWordBreakdown(){
		return wordBreakdown;
	}
	
	/**
	 * Returns the total number of works.
	 * @return
	 */
	public int getTotalWords() {
		int total = 0;
		for(int words : wordBreakdown.values()) {
			total += words;
		}
		return total;
		
	}
	
	/**
	 * Retruns the average work length
	 * @return
	 */
	public double getAverage() {
		double totalLetters = 0;
		double totalWords = 0;
		
		for (Map.Entry<Integer, Integer> entry : wordBreakdown.entrySet()) {
			int words = entry.getValue();
			totalWords += words;
		    totalLetters += entry.getKey() * words;
		}
		if(totalWords == 0 ) {
			return 0;
		} else {
			return totalLetters / totalWords;
		}
	}
	
	/**
	 * Returns the a list of words of most common length.
	 * @return First element of list is how many times it occurs, subsequent values, are the word length.  
	 */
	public List<Integer> getCommonLength() {
		List<Integer> commonLengths = new ArrayList<>();
		if(wordBreakdown.isEmpty()) {
			return commonLengths;
		}
		int maxValueInMap=(Collections.max(wordBreakdown.values()));  // This will return max value in the Hashmap
		commonLengths.add(maxValueInMap);
        for (Entry<Integer, Integer> entry : wordBreakdown.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                commonLengths.add(entry.getKey());   // add the key with max value
            }
        }
        return commonLengths;
	}


}
