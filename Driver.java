package fixed;

import java.io.IOException;

class Driver {
	
	/**
	 * Creates a parser from user input via the CreateParser class
	 * @param args
	 * @throws SecurityException
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws SecurityException, IOException {
		//CreateParser formatter = new CreateParser("file", "newsapi");
		//CreateParser formatter = new CreateParser("file", "simple");
		CreateParser formatter = new CreateParser("url", "newsapi");
		formatter.doParsing();
	}

}
