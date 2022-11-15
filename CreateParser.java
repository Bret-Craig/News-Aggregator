package fixed;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class CreateParser {
	
	private String source;
	private String format;
	
	CreateParser(String source, String format) {
		this.source = source;
		this.format = format;
	}
	
	/**
	 * Accepts a Parser and calls visit to obtain a list of articles.
	 * @param p
	 * @return
	 */
	List<Article> accept(Parser p) {
		try {
			return p.visit(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Based on source and format given by the user during initialization, 
	 * creates parsers to obtain a list of articles, then prints them while
	 * logging bad articles.
	 * @throws SecurityException
	 * @throws IOException
	 */
	void doParsing() throws SecurityException, IOException {
		Logger logger = Logger.getLogger(Driver.class.getName());
		FileHandler fh = new FileHandler("MyLog.log");  
	    logger.addHandler(fh);
	    SimpleFormatter formatter = new SimpleFormatter();  
	    fh.setFormatter(formatter);
	    logger.setUseParentHandlers(false);
	    
	    List<Article> articles;
		if ((this.source.equalsIgnoreCase("FILE") && this.format.equalsIgnoreCase("NEWSAPI")) || this.source.equalsIgnoreCase("URL")) {
			Parser p = new FilterDecorator(new NewsAPIParser());
			articles = accept(p);
		}
		else if (this.source.equalsIgnoreCase("FILE") && this.format.equalsIgnoreCase("SIMPLE")) {
			Parser p = new SimpleParser();
			articles = accept(p);
		} else articles = Collections.emptyList();
		
		for (Article a: articles) {
			if (a.getDate() == null) {
				logger.warning("Encountered an article with a missing publishing time");
			}
			if (a.getDescription() == null) {
				logger.warning("Encountered an article with a missing discription");
			}
			if (a.getTitle() == null) {
				logger.warning("Encountered an article with a missing title");
			}
			if (a.getUrl() == null) {
				logger.warning("Encountered an article with a missing URL");
			} else {
				System.out.println(a + "\n");
			}
		}
	}


	String getSource() {
		return source;
	}
	
}
