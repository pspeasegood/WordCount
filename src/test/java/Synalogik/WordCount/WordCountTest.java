package Synalogik.WordCount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class WordCountTest {
	
	
	@Test
	public void testWordCountLettersOnly() {
		String input = "Hello World";
		int wordCount = WordCount.totalWords(input);
		assertEquals(2, wordCount);
		
		Map<Integer, Integer> wordBreakDown = WordCount.WordBreakdown(input);
		assertEquals(new Integer(2), wordBreakDown.get(5));
	}
	
	@Test
	public void testWordCountMixedCharacters() {
		String input = "Hello world & good morning. The date is 18/05/2016";
		int wordCount = WordCount.totalWords("Hello world & good morning. The date is 18/05/2016");
		assertEquals(9, wordCount);
		
		Map<Integer, Integer> wordBreakDown = WordCount.WordBreakdown("Hello world & good morning. The date is 18/05/2016");
		assertEquals(new Integer(1), wordBreakDown.get(1));
		assertEquals(new Integer(1), wordBreakDown.get(2));
		assertEquals(new Integer(1), wordBreakDown.get(3));
		assertEquals(new Integer(2), wordBreakDown.get(4));
		assertEquals(new Integer(2), wordBreakDown.get(5));
		assertEquals(new Integer(1), wordBreakDown.get(8));
		assertEquals(new Integer(1), wordBreakDown.get(10));
	}
	
	@Test
	public void testWordCountWithQuotes() {
		String input = "Paul's Test";
		int wordCount = WordCount.totalWords(input);
		assertEquals(2, wordCount);
		
		Map<Integer, Integer> wordBreakDown = WordCount.WordBreakdown(input);
		assertEquals(new Integer(1), wordBreakDown.get(4));
		assertEquals(new Integer(1), wordBreakDown.get(6));
	}
	
	@Test
	public void testWordCountMultiSpaces() {
		String input = "   Hello     World   ";
		int wordCount = WordCount.totalWords(input);
		assertEquals(2, wordCount);
		
		Map<Integer, Integer> wordBreakDown = WordCount.WordBreakdown(input);
		assertEquals(new Integer(2), wordBreakDown.get(5));
	}
	
	@Test
	public void testWordCountEmpty() {
		String input = "";
		int wordCount = WordCount.totalWords("");
		assertEquals(0, wordCount);
		
		Map<Integer, Integer> wordBreakDown = WordCount.WordBreakdown(input);
		assertTrue(wordBreakDown.isEmpty());
	}
	
	@Test
	public void testWordCountBlank() {
		String input = "     ";
		int wordCount = WordCount.totalWords(input);
		assertEquals(0, wordCount);
		
		
		Map<Integer, Integer> wordBreakDown = WordCount.WordBreakdown(input);
		assertTrue(wordBreakDown.isEmpty());
	}

}
