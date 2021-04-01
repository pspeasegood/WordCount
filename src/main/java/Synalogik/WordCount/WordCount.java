package Synalogik.WordCount;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
	
	
	public static Map<Integer, Integer> WordBreakdown(String input) {
		Map<Integer,Integer> wordBreakdown = new HashMap<>();
		if(input.isBlank()) {
			return wordBreakdown;
		}
		
		String[] words = input.split("\\s+");
		for (String word : words) {
			int wordLengh = word.length();
			if(wordBreakdown.containsKey(wordLengh)) {
				wordBreakdown.put(wordLengh, wordBreakdown.get(wordLengh) + 1);
			} else {
				wordBreakdown.put(wordLengh, 1);
			}
			
		}
		
		
		
		return wordBreakdown;	
	}
	
	public static int totalWords(String input) {
		if (input.isBlank()) {
			return 0;
		} else 
		{
			return input.trim().split("\\s+").length;
		}
		
	}

}
