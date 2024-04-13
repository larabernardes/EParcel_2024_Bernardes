package model;

public class Address {
	
	// 1. Variables

	private City city;
	private String streetOrHouseTitle;
	private int houseNo;
	
	// 2. Getters and setters
	
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		if(city != null)
			this.city = city;
		else
			this.city = null;
	}
	
	public String getStreetOrHouseTitle() {
		return streetOrHouseTitle;
	}
	
	public void setStreetOrHouseTitle(String streetOrHouseTitle) {
		if(streetOrHouseTitle != null  && streetOrHouseTitle.matches("[A-Za-z ]{1,30}"))
			this.streetOrHouseTitle = streetOrHouseTitle;
		else
			this.streetOrHouseTitle = "Undefinied";
	}
	
	public int getHouseNo() {
		return houseNo;
	}
	
	public void setHouseNo(int houseNo) {
		if(houseNo >= 0 && houseNo <= 1000000000)
			this.houseNo = houseNo;
		else
			this.houseNo = 0;
	}
	
	
	// 3. Constructors
	
	public Address() {
		setCity(City.Undefined); 
		setHouseNo(0);
		setStreetOrHouseTitle("Undefined");
		
	}
	
	
	public Address(City city, String streetOrHouseTitle, int houseNo) {
		setCity(city);
		setStreetOrHouseTitle(streetOrHouseTitle);
		setHouseNo(houseNo);
	}
	
	
	// 5. toString
	
	public String toString()
	{
		return "City: " + city  + "; Street/House title: " + streetOrHouseTitle + "; Number: " +  houseNo;
	}
	
	
	
}
