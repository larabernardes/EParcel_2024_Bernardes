package model;

public class CustomerAsPerson extends AbstractCustomerAsPerson {

	// 3. Constructors
	public CustomerAsPerson() {
        super(); 
    }
	
	
	public CustomerAsPerson(String name, String surname, String personCode,
			Address address, String phone)
	{
        super(name, surname, personCode);
        
     
    }

	
	
	
	// 4. toString
	
	 @Override
	 	public String toString() {
	        return "CustomerAsPerson{" +
	                "cID=" + getcID() +
	                ", address=" + getAddress() +
	                ", phoneNo='" + getPhoneNo() + '\'' +
	                ", parcels=" + getParcels() +
	                ", customerCode='" + getCustomerCode() + '\'' +
	                ", person=" + person +
	                '}';
	    }
	        
	
	// 5. Other functionss 
	@Override
	public void setCustomerCode() {
		this.customerCode = Long.toString(getcID()) + "_" + + person.getPersonCode();
		
	}
	
	
	
}
