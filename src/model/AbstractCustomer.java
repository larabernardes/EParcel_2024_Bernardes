package model;

import java.util.ArrayList;

public abstract class AbstractCustomer {

    //1. Variables
    private long cID;
    private Address address;
    private String phoneNo;
    private ArrayList<Parcel> parcels = new ArrayList<Parcel>();
    protected String customerCode;

    private static long counter = 0;

    // 2. Getters and setters

    public long getcID() {
        return cID;
    }

    public void setcID() {
        this.cID = counter;
        counter++;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address != null)
            this.address = address;
        else
            this.address = new Address();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        if (phoneNo != null && phoneNo.matches("[0-9]{8,15}"))
            this.phoneNo = phoneNo;
        else
            this.phoneNo = "Undefined";
    }

    public ArrayList<Parcel> getParcels() {
        return parcels;
    }

    public void setParcels(ArrayList<Parcel> parcels) {
        if (parcels != null)
            this.parcels = parcels;
        	
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public abstract void setCustomerCode();

    
    // 3. Constructors 
    
    public AbstractCustomer() {
    	setcID();
    	setAddress(new Address());
    	setPhoneNo("Undefined");
    }
    
    public AbstractCustomer(Address address, String phoneNo) {
    	setcID();
    	setAddress(address);
    	setPhoneNo(phoneNo); 
    } 
    
    
    // 4. toString

    public String toString() {
        return  "-> cID: " + getcID() + "\n" +
				 "	- Address: " + getAddress() + "\n" +
	             "	- Phone number: " + getPhoneNo() + "\n" + 
	             "	- Parcels: " + getParcels() + "\n"  + "\n";
    }

    
 	
    
    // 5. Other functions 
    
    public void addNewParcel(Parcel parcel) {
        if (parcel != null && !parcels.contains(parcel)) {
            parcels.add(parcel);
        }
    }
   
    
    
}
