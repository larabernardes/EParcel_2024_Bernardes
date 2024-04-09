package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Parcel {

	// 1. Variables
	
	private boolean isFragile;
	private ParcelSize size;
	private LocalDateTime orderCreated;
	private LocalDateTime plannedDelivery;
	private float price;
	private Driver driver;
	
	
	// 2. Getters and setters
	
	public boolean getIsFragile() {
		return isFragile;
	}
	
	public void setIsFragile(boolean isFragile) {
		this.isFragile = isFragile;
	}
	
	public ParcelSize getSize() {
		return size;
	}
	
	public void setSize(ParcelSize size) {
		if(size != null)
			this.size = size;
		else
			this.size = ParcelSize.M; // ask professor if i should leave it as null!
	}
	
	public LocalDateTime getOrderCreated() {
		return orderCreated;
	}
	
	public void setOrderCreated() {
		this.orderCreated = LocalDateTime.now();
	}
	
	public LocalDateTime getPlannedDelivery() {
		return plannedDelivery;
	}
	
	public void setPlannedDelivery(LocalDateTime plannedDelivery) {
		if (plannedDelivery.toLocalDate().isAfter(LocalDate.now())) {
            this.plannedDelivery = plannedDelivery;
		} 
		else {
	        this.plannedDelivery = LocalDateTime.now().plusDays(5);
	    }
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice() {
        float basePrice = 1.99f;
        float fragileFee = 2.99f;
        
        if (size != null) {
	        this.price = size.ordinal() * basePrice; 
	        if (isFragile) {
	            this.price += fragileFee;
	        }
        }
        else {
        	this.price = 0;
        }
    }
	
	public Driver getDriver() {
		return driver;
	}
	
	public void setDriver(Driver driver) {
		if(driver != null)
			this.driver = driver;
		else
			this.driver = new Driver();
	}
	
	
	// 3. Constructors 
	
	public Parcel() {
		setIsFragile(false);
		setOrderCreated();
		setPlannedDelivery(plannedDelivery);
		setPrice();
		setDriver(new Driver());
		
	}
	
	
	public Parcel(boolean isFragile, ParcelSize size, LocalDateTime plannedDelivery, Driver driver)
	{
		setIsFragile(isFragile);
		setSize(size);
		setOrderCreated();
		setPlannedDelivery(plannedDelivery);
		setPrice();
		setDriver(driver);
		
	}
	
	
	// 4.toString
	
	public String toString() {
        return "Parcel details: \n" +
               "isFragile: " + isFragile + "\n" +
               "Size: " + size + "\n" +
               "Order created: " + orderCreated + "\n" +
               "Planned delivery: " + plannedDelivery + "\n" +
               "Price: $" + String.format("%.2f", price) + "\n" +
               "Driver: " + (driver != null ? driver.getName() : "Not assigned");
    }
	
	
	// 5. Other functions 

}
