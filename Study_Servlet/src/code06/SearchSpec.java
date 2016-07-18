package code06;

public class SearchSpec {
	private String name;
	private String baseUrl;
	
	public SearchSpec(String name, String baseUrl) {
		this.name = name;
		this.baseUrl = baseUrl;
	}
	
	public String makeUrl(String searchString){
		return(baseUrl+searchString);
	}

	public String getName() {
		return name;
	}
	
}
