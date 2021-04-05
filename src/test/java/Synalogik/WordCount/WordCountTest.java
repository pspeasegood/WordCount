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
		
		assertEquals(5, wordCount.getAverage(),0.0001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertEquals(new Integer(2), commonLengths.get(0));
		assertEquals(new Integer(5), commonLengths.get(1));
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
		assertEquals(new Integer(1), wordBreakDown.get(8));
		assertEquals(new Integer(1), wordBreakDown.get(10));
		
		assertEquals(4.666, wordCount.getAverage(),0.001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertEquals(new Integer(2), commonLengths.get(0));
		assertEquals(new Integer(4), commonLengths.get(1));
		assertEquals(new Integer(5), commonLengths.get(2));
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
		
		assertEquals(5, wordCount.getAverage(),0.0001);
		
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
		
		assertEquals(0, wordCount.getAverage(),0.0001);
		
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
		
		assertEquals(0, wordCount.getAverage(),0.0001);
		
		List<Integer> commonLengths = wordCount.getCommonLength();
		assertTrue(commonLengths.isEmpty());
	}

}
