package fixed;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;


class NewsAPIParser implements Parser {
	
	private InputStream stream;

	
	/**
	 * Parses a newsAPI format for a list of Articles.
	 * @return List<Article>
	 */
	public List<Article> parse() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Data data = mapper.readValue(stream, Data.class);
		List<Article> articles = data.getArticles();
		return articles;
	}
	
	/**
	 * Uses a CreateParser object's source to determine whether
	 * to parse a file or URL.
	 */
	public List<Article> visit(CreateParser c) throws IOException {
		if (c.getSource().equalsIgnoreCase("FILE"))
			try {
				this.stream = new FileInputStream(new File("inputs/newsapi.txt"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			 URL url = new URL("http://newsapi.org/v2/top-headlines?country=us&apiKey=a264522b8b2141bf8c97a6c20d29b55f");
			 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			 this.stream = connection.getInputStream();
		}
		return parse();
	}
	
	
}
