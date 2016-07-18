package code06;

public class SearchUtil {
	private static SearchSpec[] commonSpecs ={ 
			new SearchSpec("Google",
					"http://www.google.com/search?q="),
			new SearchSpec("AllTheWeb",
					"http://www.alltheweb.com/search?q="),
			new SearchSpec("Yahoo",
                     "http://search.yahoo.com/bin/search?p="),
			new SearchSpec("AltaVista",
                     "http://www.altavista.com/web/results?q="),
			new SearchSpec("Lycos",
                     "http://search.lycos.com/default.asp?query="),
			new SearchSpec("HotBot",
                 	 "http://hotbot.com/default.asp?query="),
			new SearchSpec("MSN",
                     "http://search.msn.com/results.asp?q="),
	};
	
	public static SearchSpec[] getCommonSpecs() {
		return commonSpecs;
	}

	public static String makeUrl(String searchEngineName,String searchString){
	    String searchURL = null;
	    for(int i=0; i<commonSpecs.length; i++) {
	    	SearchSpec spec = commonSpecs[i];
	      if (spec.getName().equalsIgnoreCase(searchEngineName)) {
	        searchURL = spec.makeUrl(searchString);
	        break;
	      }
	    }
	    return searchURL;
	}
}
