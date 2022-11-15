package fixed;

import java.io.IOException;
import java.util.List;

class FilterDecorator extends NewsAPIParser {
	
	private NewsAPIParser parser;
	
	/**
	 * Change filter field to filter articles by source, null for no filter.
	 */
	private static final String FILTER = "CNN";

	public FilterDecorator(NewsAPIParser parser) {
		this.parser = parser;
	}
	
	/**
	 * Uses NewsAPIParser to acquire all valid articles, then filters out
	 * articles according to the FILTER field.
	 */
	@Override
	public List<Article> visit(CreateParser c) throws IOException {
		List<Article> articles = parser.visit(c);
		if (FilterDecorator.FILTER != null) 
			System.out.println("Filtering for: " + FILTER + "\n");
			articles.removeIf(a -> !a.getSource().getName().equalsIgnoreCase(FILTER));
		return articles;
	}

}
