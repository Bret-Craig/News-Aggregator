package fixed;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;


class SimpleParser implements Parser {

	/**
	 * Parses a simple format for a single Article.
	 * @return List<Article>
	 */
	public List<Article> parse() throws IOException {
		File file = new File("inputs/simple.txt");
		ObjectMapper mapper = new ObjectMapper();
		Article simpleArticle = mapper.readValue(file, Article.class);
		return List.of(simpleArticle);
	}


	@Override
	public List<Article> visit(CreateParser c) throws MalformedURLException, IOException {
		return parse();
	}
	
	

	
}
