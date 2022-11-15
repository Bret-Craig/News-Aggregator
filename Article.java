package fixed;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(value = { "author", "urlToImage", "content" })
class Article {
	
	private final Source source;
	private final String title;
	private final String description;
	private final String date;
	private final String url;
	
	/**
	 * Initiates an Article object.
	 * @param title
	 * @param description
	 * @param date
	 * @param url
	 */
	@JsonCreator
	Article(@JsonProperty("source")Source source, @JsonProperty("title")String title, @JsonProperty("description")String description,
			@JsonProperty("publishedAt")String date, @JsonProperty("url")String url) {
		this.source = source;
		this.title = title;
		this.description = description;
		this.date = date;
		this.url = url;
	}
	
	Article(String title, String description, String date, String url) {
		this.title = title;
		this.description = description;
		this.date = date;
		this.url = url;
		this.source = null;
	}
	
	
	
	String getTitle() {
		return title;
	}



	String getDescription() {
		return description;
	}



	String getDate() {
		return date;
	}



	String getUrl() {
		return url;
	}
	
	Source getSource() {
		return source;
	}


	/**
	 * Returns a string of title, description, date, and URL on separate lines.
	 */
	@Override
	public String toString() {
		return "Title: " + this.title + "\nDescription: " + this.description + "\nDate: " + this.date + "\nURL: " + this.url;
	}
	
	/**
	 * Overrides the hashCode function due to equals() being overwritten.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(date, description, title, url);
	}
	
	/**
	 * Overrides the equals function to compare the given object with this object's fields.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Article))
			return false;
		Article other = (Article) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(title, other.title) && Objects.equals(url, other.url);
	}
	
	

}
