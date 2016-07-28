package code14;

public class AccessCountBean {
	private String firstPage;
	private int accessCount = 1;
	
	public String getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}
	
	public int getAccessCount() {
		return accessCount;
	}
	public void setAccessCountIncrement(int increment) {
		accessCount += increment;
	}
	
}
