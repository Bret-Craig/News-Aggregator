package fixed;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

class Data {
	
	private final String status;
	private final int totalResults;
	private final List<Article> articles;
	
	/**
	 * Initiates the initial JSON object parsed from the given input.
	 * Currently only uses the articles field.
	 * @param status
	 * @param totalResults
	 * @param articles
	 */
	public Data(@JsonProperty("status")String status, @JsonProperty("totalResults")int totalResults, @JsonProperty("articles")List<Article> articles) {
		this.status = status;
		this.totalResults = totalResults;
		this.articles = articles;
	}

	/**
	 * 
	 * @return List<Articles> articles
	 */
	List<Article> getArticles() {
		return articles;
	}
	
	
	
	
}
