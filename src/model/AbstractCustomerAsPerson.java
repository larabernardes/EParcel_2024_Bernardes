package model;

public abstract class AbstractCustomerAsPerson extends AbstractCustomer {
	
	// 1. Variables
	
	protected Person person;
	
	
	// 2. Getters and setters

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		if(person != null)
			this.person = person;
		else
			this.person = new Person();
	}
	
	
	// 3. Constructors
	
	public AbstractCustomerAsPerson() {
		super();
		setPerson(new Person());
	}
	
	public AbstractCustomerAsPerson(String name, String surname, String personCode,
			Address address, String phone) {
        super(address, phone);
        setPerson(new Person(name, surname, personCode));
    }
	
	// 4. Constructors
	
	public String toString() {
		return "Individual costumer: " + "\n" +
                "-> cID: " + getcID() + "\n" +
                "	- Address: " + getAddress() + "\n" +
                "	- Phone number: " + getPhoneNo() + '\'' + "\n" +
                "	- Customer Code: " + getCustomerCode() + '\'' + "\n" +
                "	- Person: " + person + "\n";
	}
	
	
	// 5. Other functions


}
