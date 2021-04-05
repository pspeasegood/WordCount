package Synalogik.WordCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


/**
 * Hello world!
 *
 */
public class App 
{
	

	
    public static void main( String[] args ) throws IOException
    {
    	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);

		server.createContext("/test", new MyHandler());
		server.createContext("/wordCount", new WordCountHandler());
		server.setExecutor(null); // creates a default executor
		server.start();
    }
    
    
	static class MyHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "Hello World!";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
	
	private static DecimalFormat df3 = new DecimalFormat("#.###");
	
	static class WordCountHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			InputStreamReader inputStreamReader = new InputStreamReader(t.getRequestBody());
	        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String requestBody = bufferedReader.lines().collect(Collectors.joining());
			
			WordCount wordCount = new WordCount();
			wordCount.WordBreakdown(requestBody);
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Word count = " + wordCount.getTotalWords() + "\n");
			stringBuilder.append("Average word length =" + df3.format(wordCount.getAverage()) + "\n");
			
			Map<Integer, Integer> wordBreakDown = wordCount.getWordBreakdown();
			for (Map.Entry<Integer, Integer> entry : wordBreakDown.entrySet()) {
				Integer wordLength = entry.getKey();
			    Integer occurrences = entry.getValue();
			    stringBuilder.append("Number of words of length " + wordLength + " is " + occurrences + "\n");
			}
			
			List<Integer> commonLengths = wordCount.getCommonLength();
			stringBuilder.append("The most frequently occurring word length occurs " + commonLengths.get(0) + " times, for word lengths of " + commonLengths.get(1));
			commonLengths.stream().skip(2).forEach(v -> stringBuilder.append("," + v));
			
			String response = stringBuilder.toString();
			System.out.println(response);
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}
