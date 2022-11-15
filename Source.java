package fixed;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"id"})
class Source {
	
	private final String name;
	
	@JsonCreator
	Source(@JsonProperty("name")String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
	
}
