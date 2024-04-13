package model;

public class CustomerAsPerson extends AbstractCustomerAsPerson{

	// 3. Constructors
	public CustomerAsPerson() {
        super(); 
        setCustomerCode();
    }
	
	public CustomerAsPerson(String name, String surname, String personCode,
			Address address, String phone)
	{
		super(name, surname, personCode, address, phone);
		setCustomerCode();
     
    }

	
	
	// 4. toString
	
	 @Override
	 	public String toString() {
	        return "Individual costumer: " + "\n" +
	                super.toString();
	    }
	        
	
	// 5. Other functions 
	@Override
	public void setCustomerCode() {
		this.customerCode = Long.toString(getcID()) + "_person_" + getPerson().getPersonCode();
		
	}
	
	
}
