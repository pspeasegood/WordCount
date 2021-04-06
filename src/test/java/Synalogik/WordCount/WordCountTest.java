package Synalogik.WordCount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class WordCountTest {
	
	
	@Test
	public void testWordCountLettersOnly() {
		String input = "Hello World";
		WordCount wordCount = new WordCount();
		wordCount.WordBreakdown(input);
		assertEquals(2,  wordCount.getTotalWords());
		
		Map<Integer, Integer> wordBreakDown = wordCount.getWordBreakdown();
		assertEquals(new Integer(2), wordBreakDown.get(5));
		
		assertEquals(5, wordCount.getAverage(),0.001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertEquals(new Integer(2), commonLengths.get(0));
		assertEquals(new Integer(5), commonLengths.get(1));
	}
	
	
	@Test
	public void testWordCountAllLetters() {
		String input = "The quick brown fox jumps over the lazy dog";
		WordCount wordCount = new WordCount();
		wordCount.WordBreakdown(input);
		assertEquals(9,  wordCount.getTotalWords());
		
		Map<Integer, Integer> wordBreakDown = wordCount.getWordBreakdown();
		assertEquals(new Integer(4), wordBreakDown.get(3));
		assertEquals(new Integer(2), wordBreakDown.get(4));
		assertEquals(new Integer(3), wordBreakDown.get(5));
		
		assertEquals(3.889, wordCount.getAverage(),0.001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertEquals(new Integer(4), commonLengths.get(0));
		assertEquals(new Integer(3), commonLengths.get(1));
	}
	
	@Test
	public void testWordCountMixedCharacters() {
		String input = "Hello world & good morning. The date is 18/05/2016";
		WordCount wordCount = new WordCount();
		wordCount.WordBreakdown(input);
		assertEquals(9,  wordCount.getTotalWords());
		
		Map<Integer, Integer> wordBreakDown = wordCount.getWordBreakdown();
		assertEquals(new Integer(1), wordBreakDown.get(1));
		assertEquals(new Integer(1), wordBreakDown.get(2));
		assertEquals(new Integer(1), wordBreakDown.get(3));
		assertEquals(new Integer(2), wordBreakDown.get(4));
		assertEquals(new Integer(2), wordBreakDown.get(5));
		assertEquals(new Integer(1), wordBreakDown.get(7));
		assertEquals(new Integer(1), wordBreakDown.get(10));
		
		assertEquals(4.556, wordCount.getAverage(),0.001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertEquals(new Integer(2), commonLengths.get(0));
		assertEquals(new Integer(4), commonLengths.get(1));
		assertEquals(new Integer(5), commonLengths.get(2));
	}
	
	@Test
	public void testWordCountLoremIpsum() {
		String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		WordCount wordCount = new WordCount();
		wordCount.WordBreakdown(input);
		assertEquals(69,  wordCount.getTotalWords());
		
		Map<Integer, Integer> wordBreakDown = wordCount.getWordBreakdown();
		assertEquals(new Integer(13), wordBreakDown.get(2));
		assertEquals(new Integer(5), wordBreakDown.get(3));
		assertEquals(new Integer(11), wordBreakDown.get(4));
		assertEquals(new Integer(10), wordBreakDown.get(5));
		assertEquals(new Integer(9), wordBreakDown.get(6));
		assertEquals(new Integer(8), wordBreakDown.get(7));
		assertEquals(new Integer(4), wordBreakDown.get(8));
		assertEquals(new Integer(4), wordBreakDown.get(9));
		assertEquals(new Integer(2), wordBreakDown.get(10));
		assertEquals(new Integer(1), wordBreakDown.get(11));
		assertEquals(new Integer(1), wordBreakDown.get(12));
		assertEquals(new Integer(1), wordBreakDown.get(13));
		
		assertEquals(5.348, wordCount.getAverage(),0.001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertEquals(new Integer(13), commonLengths.get(0));
		assertEquals(new Integer(2), commonLengths.get(1));
	}
	
	@Test
	public void testWordCountWithQuotes() {
		String input = "Paul's Test";
		WordCount wordCount = new WordCount();
		wordCount.WordBreakdown(input);
		assertEquals(2,  wordCount.getTotalWords());
		
		Map<Integer, Integer> wordBreakDown = wordCount.getWordBreakdown();
		assertEquals(new Integer(1), wordBreakDown.get(4));
		assertEquals(new Integer(1), wordBreakDown.get(6));
		
		assertEquals(5, wordCount.getAverage(),0.001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertEquals(new Integer(1), commonLengths.get(0));
		assertEquals(new Integer(4), commonLengths.get(1));
		assertEquals(new Integer(6), commonLengths.get(2));
	}
	
	@Test
	public void testWordCountMultiSpaces() {
		String input = "   Hello     World   ";
		WordCount wordCount = new WordCount();
		wordCount.WordBreakdown(input);
		assertEquals(2,  wordCount.getTotalWords());
		
		Map<Integer, Integer> wordBreakDown = wordCount.getWordBreakdown();
		assertEquals(new Integer(2), wordBreakDown.get(5));
		
		assertEquals(5, wordCount.getAverage(),0.0001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertEquals(new Integer(2), commonLengths.get(0));
		assertEquals(new Integer(5), commonLengths.get(1));
	}
	
	@Test
	public void testWordCountEmpty() {
		String input = "";
		WordCount wordCount = new WordCount();
		wordCount.WordBreakdown(input);
		assertEquals(0,  wordCount.getTotalWords());
		
		Map<Integer, Integer> wordBreakDown = wordCount.getWordBreakdown();
		assertTrue(wordBreakDown.isEmpty());
		
		assertEquals(0, wordCount.getAverage(),0.001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertTrue(commonLengths.isEmpty());
	}
	
	@Test
	public void testWordCountBlank() {
		String input = "     ";
		WordCount wordCount = new WordCount();
		wordCount.WordBreakdown(input);
		assertEquals(0,  wordCount.getTotalWords());
		
		
		Map<Integer, Integer> wordBreakDown = wordCount.getWordBreakdown();
		assertTrue(wordBreakDown.isEmpty());
		
		assertEquals(0, wordCount.getAverage(),0.001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertTrue(commonLengths.isEmpty());
	}

}
