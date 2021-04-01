package Synalogik.WordCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
	
	
	public static Map<Integer, Integer> WordBreakdown(String input) {
		String[] words = input.split("\\s+");
		Map<Integer,Integer> wordBreakdown = new HashMap<>();
		
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
