package code16;

public class CompanyBean {
	private String companyName;
	private String business;
	
	public CompanyBean(String companyName, String business) {
		this.companyName = companyName;
		this.business = business;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	
}
