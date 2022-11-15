package fixed;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

interface Parser {
	List<Article> parse() throws IOException;
	List<Article> visit(CreateParser c) throws MalformedURLException, IOException;
}
