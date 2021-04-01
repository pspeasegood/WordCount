package Synalogik.WordCount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordCountTest {
	
	
	@Test
	public void testWordCountLettersOnly() {
		int wordCount = WordCount.totalWords("Hello World");
		assertEquals(2, wordCount);
	}
	
	@Test
	public void testWordCountMixedCharacters() {
		int wordCount = WordCount.totalWords("Hello world & good morning. The date is 18/05/2016");
		assertEquals(9, wordCount);
	}
	
	@Test
	public void testWordCountWithQuotes() {
		int wordCount = WordCount.totalWords("Paul's Test");
		assertEquals(2, wordCount);
	}
	
	@Test
	public void testWordCountMultiSpaces() {
		int wordCount = WordCount.totalWords("   Hello     World!!   ");
		assertEquals(2, wordCount);
	}
	
	@Test
	public void testWordCountEmpty() {
		int wordCount = WordCount.totalWords("");
		assertEquals(0, wordCount);
	}
	
	@Test
	public void testWordCountBlank() {
		int wordCount = WordCount.totalWords("    ");
		assertEquals(0, wordCount);
	}

}
