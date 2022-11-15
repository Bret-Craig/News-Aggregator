package fixed;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;


import org.junit.Assert;
import org.junit.Test;

public class ParserTests {

	/**
	 * Tests the FilterDecorator class by comparing with the first
	 * filtered article obtained. Assumes the filter is currently
	 * set to obtain only CNET articles.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	public void testFilterDecorator() throws MalformedURLException, IOException {
		Parser filteredParser= new FilterDecorator(new NewsAPIParser());
		CreateParser formatter = new CreateParser("file", "newsapi");
		List<Article> articles = filteredParser.visit(formatter);
		
		Article test = articles.get(0);
	    Article sample = new Article(
	    		"NASA helicopter took a piece of the Wright brothers' plane to Mars - CNET",
	    		"NASA is gearing up for a dramatic Mars test flight of Ingenuity as soon as April 8.", 
	    		"2021-03-24T21:43:00Z", 
	    		"https://www.cnet.com/news/nasa-helicopter-took-a-piece-of-the-wright-brothers-famous-plane-to-mars/");
		Assert.assertEquals(sample, test);
	}
	

	/**
	 * Tests each parser's return list to ensure the correct number of articles are parsed
	 * for the given return type.
	 * @throws IOException 
	 * @throws JSONException
	 */
	@Test
	public void testArticleCount() throws IOException {
		Parser newsAPIParser = new NewsAPIParser();
		Parser simpleParser = new SimpleParser();
		
		CreateParser formatter = new CreateParser("file", "newsapi");
	    List<Article> articles = newsAPIParser.visit(formatter);
	    Assert.assertEquals(articles.size(), 20);
	    
	    formatter = new CreateParser("file", "simple");
	    articles = simpleParser.visit(formatter);
	    Assert.assertEquals(articles.size(), 1);

	}
	
	/**
	 * Uses the first article of respective inputs to test that the parsers
	 * accurately extract the required information.
	 * @throws IOException 
	 * @throws JSONException
	 */
	@Test
	public void testParseAccuracy() throws IOException {
		Parser newsAPIParser = new NewsAPIParser();
		Parser simpleParser = new SimpleParser();
		
		CreateParser formatter = new CreateParser("file", "newsapi");
		List<Article> articles = newsAPIParser.visit(formatter);
	    Article testFirst = articles.get(0);
	    Article sampleFirst = new Article(
	    		"The latest on the coronavirus pandemic and vaccines: Live updates - CNN",
	    		"The coronavirus pandemic has brought countries to a standstill. Meanwhile, vaccinations have already started in some countries as cases continue to rise. Follow here for the latest.", 
	    		"2021-03-24T22:32:00Z", 
	    		"https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html");
		Assert.assertEquals(sampleFirst, testFirst);
		
		formatter = new CreateParser("file", "simple");
		articles = simpleParser.visit(formatter);
	    testFirst = articles.get(0);
	    sampleFirst = new Article(
	    		"Assignment #2",
	    		"Extend Assignment #1 to support multiple sources and to introduce source processor.", 
	    		"2021-04-16 09:53:23.709229", 
	    		"https://canvas.calpoly.edu/courses/55411/assignments/274503");
		Assert.assertEquals(sampleFirst, testFirst);
		
	}
	
	/**
	 * Uses input with null fields to test if parsers can handle null input.
	 * Must change input to badnewsapi.txt/badsimple.txt to function
	 */
//	@Test
//	public void testNullInput() throws SecurityException, IOException {
//		Parser badNewsParser = new NewsAPIParser();
//		CreateParser formatter = new CreateParser("file", "newsapi");
//		List<Article> articles = badNewsParser.visit(formatter);
//	    Article actual = articles.get(0);
//	    Article expected = new Article(
//	    		null,
//	    		"The coronavirus pandemic has brought countries to a standstill. Meanwhile, vaccinations have already started in some countries as cases continue to rise. Follow here for the latest.", 
//	    		"2021-03-24T22:32:00Z", 
//	    		"https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html"
//	    		);
//	    Assert.assertEquals(expected, actual);
//	    
//	    Parser badSimpleParser = new SimpleParser();
//	    formatter = new CreateParser("file", "simple");
//		articles = badSimpleParser.visit(formatter);
//	    actual = articles.get(0);
//	    expected = new Article(
//	    		"Assignment #2",
//	    		"Extend Assignment #1 to support multiple sources and to introduce source processor.", 
//	    		null, 
//	    		"https://canvas.calpoly.edu/courses/55411/assignments/274503"
//	    		);
//	    Assert.assertEquals(expected, actual);		
//	}
	
}
