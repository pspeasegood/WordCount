package Synalogik.WordCount;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
	
	
	Map<Integer,Integer> wordBreakdown = new HashMap<>();
	
	public void WordBreakdown(String input) {
		wordBreakdown = new HashMap<>();
		if(input.isBlank()) {
			return;
		}
		
		String[] words = input.trim().split("\\s+");
		for (String word : words) {
			int wordLengh = word.length();
			if(wordBreakdown.containsKey(wordLengh)) {
				wordBreakdown.put(wordLengh, wordBreakdown.get(wordLengh) + 1);
			} else {
				wordBreakdown.put(wordLengh, 1);
			}
			
		}
	}
	
	
	public Map<Integer,Integer> getWordBreakdown(){
		return wordBreakdown;
	}
	
	
	public int getTotalWords() {
		int total = 0;
		for(int words : wordBreakdown.values()) {
			total += words;
		}
		return total;
		
	}
	
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


}
