package model;

public class CustomerAsCompany extends AbstractCustomer {

	// 1. Variables
	
	private String title;
	private String companyRegNo;
	
	
	// 2. Getters and setters
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title != null  && title.matches("[a-zA-Z0-9 ]{3,20}")) 
			this.title = title;
		else
			this.title = "Undefined";
	}

	public String getCompanyRegNo() {
		return companyRegNo;
	}

	public void setCompanyRegNo(String companyRegNo) {
		if(companyRegNo != null  && companyRegNo.matches("[A-Za-z0-9 ]{1,30}"))
			this.companyRegNo = companyRegNo;
		else
			this.companyRegNo = "Undefinied";
	}
	
	@Override 
	public void setCustomerCode() {
		
		this.customerCode = Long.toString(getcID()) + "_company_" + companyRegNo;
	}
	
	
	// 3. Constructors 
	
	 public CustomerAsCompany() {
	        super(); 
	        setTitle("Title");
		    setCompanyRegNo("00000000");
	        setCustomerCode();
	 }
	 
	 public CustomerAsCompany(Address address, String phoneNo, String title, String companyRegNo) {
		 super(address, phoneNo); 
		 setTitle(title);
	     setCompanyRegNo(companyRegNo);
	     setCustomerCode();
	  }
	
	 
	 // 4. toString 
	 
	 @Override
	 public String toString() {
		 return "Business costumer: " + "\n" +
				 super.toString() +
	             "	- Customer code: " + getCustomerCode() + "\n" +
	             " 	- Title: " + title + "\n" +
	             "	- Company registration number: " + companyRegNo + "\n";
	    }
	 
	 
	 // 5. Other functions

		
}

	