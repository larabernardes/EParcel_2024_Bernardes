package service;

import model.Driver;
import model.Parcel;
import model.ParcelSize;
import model.AbstractCustomer;
import model.Address;
import model.City;
import model.CustomerAsPerson;
import model.CustomerAsCompany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainService {
    
    public static ArrayList<Driver> allDrivers = new ArrayList<>();
    public static ArrayList<AbstractCustomer> allAbstractCustomer = new ArrayList<>();
    
    
    public static void main(String[] args) {
        
    	Driver driver4 = new Driver("John", "Doe", "003300-01100", "4444", 25);
        Driver driver1 = new Driver("Lara", "Bernardes", "123456-12345", "0000", 3);
        Driver driver2 = new Driver("Annija", "Aumale", "111111-11111", "1111", 4);
        Driver driver5 = new Driver("Anna", "Sprude", "113311-13311", "6666", 13);
        Driver driver3 = new Driver("Viktors", "Kokins", "000000-00000", "2222", 1);
        
        Address individualCostumer1Address = new Address(City.Ventspils, "Saules iela", 55);
        Address individualCostumer2Address = new Address(City.Daugavpils, "Tukuma iela", 33);
        Address individualCostumer3Address = new Address(City.Daugavpils, "Baznica iela", 101);
        Address testAddressForBusinessCostumer = new Address(City.Ventspils, "Inzenieru iela", 101);
        
        Address businessCostumer1Address = new Address(City.Jelgava, "Liela iela", 23);
        Address businessCostumer2Address = new Address(City.Liepaja, "Juras iela", 155);
        Address businessCostumer3Address = new Address(City.Daugavpils, "Kandavas iela", 666);
        Address testAddressForIndividualCostumer = new Address(City.Riga, "Plata iela", 696);
        
        CustomerAsPerson individualCostumer1 = new CustomerAsPerson("Vairis", "Caune", "222222-22222",
        		individualCostumer1Address, "56764456");
        CustomerAsPerson individualCostumer2 = new CustomerAsPerson("Estere", "Vitola", "654321-54321",
        		individualCostumer2Address, "65678765");
        CustomerAsPerson individualCostumer3 = new CustomerAsPerson("Arturs", "Orbidans", "456789-11111",
        		individualCostumer3Address, "76567654");
        
       CustomerAsCompany businessCostumer1 = new CustomerAsCompany(businessCostumer1Address, "65478765",
        		"Company1", "11111111");
        CustomerAsCompany businessCostumer2 = new CustomerAsCompany(businessCostumer2Address, "45678765",
        		"Company2", "22222222");
        CustomerAsCompany businessCostumer3 = new CustomerAsCompany(businessCostumer3Address, "653733738",
        		"Company3", "33333333"); 
        
        allDrivers.addAll(Arrays.asList(driver1, driver2, driver3, driver4, driver5));
        allAbstractCustomer.addAll(Arrays.asList(individualCostumer1, individualCostumer2,
        		individualCostumer3, businessCostumer1, businessCostumer2, businessCostumer3));
        
        
        
        System.out.println("ALL DRIVERS: ");
        for(Driver tempD: allDrivers) {
            System.out.println(tempD.getClass().getName() + "-> " + tempD);
            
        }
        
        System.out.println("-------------------------------");
        
        System.out.println("ALL CUSTOMERS: ");
        for(AbstractCustomer tempA: allAbstractCustomer) {
            System.out.println(tempA.getClass().getName() + "-> " + tempA);
            
        }
        
        System.out.println("-------------------------------");
        
        
        
        
        try
        {
        	System.out.println("1 - CREATING NEW DRIVER (SELVAM): ");
        	
        	createNewDriver("Selvam", "Sethupathi", "112299-88776", "77778", 9);
        	
        	for(Driver tempD: allDrivers) {
                System.out.println(tempD.getClass().getName() + "-> " + tempD);
                
            }
        	
        	System.out.println("-------------------------------");
        	
        	
        	System.out.println("2 - RETRIEVING DRIVER (LARA) BY PERSON CODE: ");
        	System.out.println(retrieveDriverByPersonCode("123456-12345"));
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("3 - UPDATING DRIVER (LARA) BY PERSON CODE: ");
        	
        	updateDriverLicenseNoByPersonCode("123456-12345", "12345");
        	
        	for(Driver tempD: allDrivers) {
                System.out.println(tempD.getClass().getName() + "-> " + tempD);
                break;
            }
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("4 - UPDATING DRIVER'S (LARA'S) EXPERIENCE (IN YEARS):");
        	
        	updateDriverExperienceinYearsByPersonCode("123456-12345", 15);
        	
        	for(Driver tempD: allDrivers) {
                System.out.println(tempD.getClass().getName() + "-> " + tempD);
                break;
            }
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("5 - REMOVING DRIVER (LARA) BY PERSON CODE:");
        	
        	removeDriverByPersonCode("123456-12345");
        	
        	for(Driver tempD: allDrivers) {
                System.out.println(tempD.getClass().getName() + "-> " + tempD);
            }
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("6 - RETRIEVING ALL CUSTOMERS AS COMPANY:");
        	ArrayList<CustomerAsCompany> businessCostumers = retrieveAllCostumersAsCompany();
        	
        	for(CustomerAsCompany tempC: businessCostumers) {
                System.out.println(tempC);
                
            } 
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("7 - RETRIEVING ALL CUSTOMERS AS PERSON:");
        	
        	ArrayList<CustomerAsPerson> allIndividualCustomers = retrieveAllCostumersasPerson();
        	for(CustomerAsPerson tempC: allIndividualCustomers) {
                System.out.println(tempC);
        	}
                
            System.out.println("-------------------------------");
            
            System.out.println("8 - CREATING NEW CUSTOMER (ANDRIS) AS PERSON:");
            
            createNewCustomerAsPerson("Andris", "Daksa", "112213-12345", testAddressForIndividualCostumer, "123456789");
            
            ArrayList<CustomerAsPerson> allIndividualCustomersUpdated = retrieveAllCostumersasPerson();
            for(CustomerAsPerson tempC: allIndividualCustomersUpdated) {
                System.out.println(tempC);
        	}
            
            System.out.println("-------------------------------");
            
            System.out.println("9 - CREATING NEW CUSTOMER (VeA) AS COMPANY:");
            
            createNewCustomerAsCompany(testAddressForBusinessCostumer, "371872636", "Ventspils Augstskola", "37162182");
            
            ArrayList<CustomerAsCompany> businessCostumersUpdated = retrieveAllCostumersAsCompany();
            for(CustomerAsCompany tempC: businessCostumersUpdated) {
                System.out.println(tempC);
                
            } 
            
            System.out.println("-------------------------------");
            
            System.out.println("10 - CREATING PARCELS FOR CUSTOMERS (VAIRIS, ESTERE AND COMPANY1: ");
            
            createNewParcelForCustomer(LocalDateTime.now(), ParcelSize.L, true, driver1, individualCostumer1.getCustomerCode());
            createNewParcelForCustomer(LocalDateTime.now(), ParcelSize.X, true, driver2, individualCostumer1.getCustomerCode());
        	createNewParcelForCustomer(LocalDateTime.now(), ParcelSize.M, true, driver3, individualCostumer2.getCustomerCode());
        	createNewParcelForCustomer(LocalDateTime.now(), ParcelSize.XL, false, driver3, businessCostumer1.getCustomerCode());
        	
        	for(AbstractCustomer tempA: allAbstractCustomer) {
                System.out.println(tempA.getClass().getName() + "-> " + tempA);
                
            }
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("11 - RETRIEVING ALL PARCELS BY CUSTOMER CODE (VAIRIS)");
        	
        	ArrayList<Parcel> individualCostumer1Parcels =
            		retrieveAllParcelsByCustomerCode(individualCostumer1.getCustomerCode());
            
            for(Parcel tempP: individualCostumer1Parcels) {
                System.out.println(tempP);
            }
            
            System.out.println("-------------------------------");
            
            System.out.println("12 - RETRIEVING ALL PARCELS BY DRIVERS (VIKTORS) PERSON CODE:"); 
            
            ArrayList<Parcel> parcelsPerDriver = retrieveAllParcelsByDriverPersonCode("000000-00000");
            for(Parcel tempP: parcelsPerDriver) {
                System.out.println(tempP);
            }
            
            System.out.println("-------------------------------");
            
            System.out.println("13 - RETRIEVING ALL PARCELS BY CITY (DAUGAVPILS):"); 
            
            ArrayList<Parcel> daugavpilsParcels = retrieveallParcelsByCity(City.Daugavpils);
            for(Parcel tempP: daugavpilsParcels) {
                System.out.println(tempP);
            }
        	
            System.out.println("-------------------------------");
            
            System.out.println("14 - RETRIEVING ALL PARCELS BY SIZE (XL):"); 
           
            ArrayList<Parcel> parcelsBySize = retrieveallParcelsByParcelSize(ParcelSize.XL);
            for(Parcel tempP: parcelsBySize) {
                System.out.println(tempP);
            }
            
            System.out.println("-------------------------------");
            
            System.out.println("15 - CALCULATING THE PRICE OF ALL CUSTOMER'S (VAIRIS) PARCELS: ");
            System.out.println(calculatePriceOfAllCustomerParcelsByCustomerCode(individualCostumer1.getCustomerCode()));
            
            System.out.println("-------------------------------");
            
            System.out.println("16 - RETRIEVING STATISTICS (VAIRIS) OF A CUSTOMER PARCEL SIZES: ");
           
            int[] statistics = retrieveStatisticsOfCustomerParcelSize(individualCostumer1.getCustomerCode());
        	System.out.print("[");
        	for (int i = 0; i < statistics.length; i++) {
        	    System.out.print(statistics[i]);
        	    if (i < statistics.length - 1) {
        	        System.out.print(", ");
        	    }
        	}
        	System.out.println("]");
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("16 - CALCULATING HOW MANY PARCELS WILL BE DELIVERED TODAY TO SPECIFIC CITY (RIGA): ");
        	System.out.print(calculateHowManyParcelsTodayDeliveredToSpecificCity(City.Riga));
        	System.out.println();
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("17 - SORTING DRIVERS BY EXPERIENCE: ");
        	
        	System.out.println("Before sorting: ");
        	for(Driver tempD: allDrivers) {
                System.out.println(tempD.getClass().getName() + "-> " + tempD);
                
            }
        	System.out.println();
        	sortDriversByExperience();
        	
        	System.out.println("After sorting: ");
        	for(Driver tempD: allDrivers) {
                System.out.println(tempD.getClass().getName() + "-> " + tempD);
                
            }
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("18 - GENERATING RANDOM CUSTOMER AS PERSON AND PARCEL: ");
        	generateCustomerAsPersonAndParcel();
        	ArrayList<CustomerAsPerson> allIndividualCustomersWithARandom = retrieveAllCostumersasPerson();
        	for(CustomerAsPerson tempC: allIndividualCustomersWithARandom) {
                System.out.println(tempC);
        	}
        	
        	System.out.println("-------------------------------");
        	
        	System.out.println("19 - GENERATING RANDOM CUSTOMER AS COMPANY AND PARCEL: ");
        	generateCustomerAsCompanyAndParcel();
        	ArrayList<CustomerAsCompany> businessCostumersWithARandom = retrieveAllCostumersAsCompany();
        	
        	for(CustomerAsCompany tempC: businessCostumersWithARandom) {
                System.out.println(tempC);
                
            } 
        	
        	System.out.println("-------------------------------");
           
        } catch (Exception e)
        {
            // e.printStackTrace();
            System.out.println(e);
        }
 
            
    }
    
    public static void createNewDriver(String name, String surname, String personCode,
            String licenseNo, float experienceInYears) throws Exception {
        
        if (name == null || surname == null || personCode == null || licenseNo == null)
            throw new Exception("Problems with input");

        for (Driver driver : allDrivers) {
            if (driver instanceof Driver && driver.getPersonCode().equals(personCode)) {
                throw new Exception("Driver already exists!");
            }
        }
        
        Driver newDriver = new Driver(name, surname, personCode, licenseNo, experienceInYears);
        allDrivers.add(newDriver);
    }
    
    
    public static Driver retrieveDriverByPersonCode(String inputPersonCode) throws Exception {
        if(inputPersonCode == null) throw new Exception("Problems with input");    
        
        for(Driver tempD: allDrivers) {
            if(tempD.getPersonCode().equals(inputPersonCode)){
                return tempD;
            }
        }
        
        throw new Exception("Driver is not found");
        
    }
    
    
    public static void updateDriverLicenseNoByPersonCode(String inputPersonCode, String licenseNo) throws Exception
    {
    	if(inputPersonCode == null || licenseNo == null) throw new Exception("Problems with input");
    	
    	for(Driver tempD: allDrivers) {
            if(tempD.getPersonCode().equals(inputPersonCode)){
                tempD.setLicenseNo(licenseNo);
                return;
            }
        }
    	
    	throw new Exception("Driver is not found");
    }
    
    
    public static void updateDriverExperienceinYearsByPersonCode(String inputPersonCode, float inputExperienceInYears) throws Exception
    {
    	if(inputPersonCode == null || inputExperienceInYears < 0.0f || inputExperienceInYears > 60.0f ) throw new Exception("Problems with input");
    	
    	for(Driver tempD: allDrivers) {
            if(tempD.getPersonCode().equals(inputPersonCode)){
                tempD.setExperienceInYears(inputExperienceInYears);
                return;
            }
        }
    	
    	throw new Exception("Driver is not found");
    }
    
    
    public static void removeDriverByPersonCode(String inputPersonCode) throws Exception
    {
    	if(inputPersonCode == null) throw new Exception("Problems with input");
    	
    	for(Driver tempD: allDrivers) {
            if(tempD.getPersonCode().equals(inputPersonCode)){
            	allDrivers.remove(tempD);
				return;
            }
        }
    	
    	throw new Exception("Driver is not found");
    }
    
    
    public static ArrayList<CustomerAsCompany> retrieveAllCostumersAsCompany() {
    	ArrayList<CustomerAsCompany> businessCustomers = new ArrayList<>();
    	
    	for(AbstractCustomer customer : allAbstractCustomer) {
            if(customer instanceof CustomerAsCompany) {
            	businessCustomers.add((CustomerAsCompany) customer);
            }
        }
    	
    	return businessCustomers;
	}
    
    
    public static ArrayList<CustomerAsPerson> retrieveAllCostumersasPerson() {
        ArrayList<CustomerAsPerson> individualCustomers = new ArrayList<>();
        
        for(AbstractCustomer customer : allAbstractCustomer) {
            if(customer instanceof CustomerAsPerson) {
                individualCustomers.add((CustomerAsPerson)customer);
            }
        }
        
        return individualCustomers;
    }
    
    
    public static void createNewCustomerAsPerson(String name, String surname, String personCode,
            Address address, String phone) throws Exception {
        
        if (name == null || surname == null || personCode == null || address == null || phone == null)
            throw new Exception("Problems with input");

        for (AbstractCustomer customer : allAbstractCustomer) {
            if (customer instanceof CustomerAsPerson && ((CustomerAsPerson) customer).getPerson().getPersonCode().equals(personCode)) {
                throw new Exception("Customer already exists!");
            }
        }
        
        CustomerAsPerson newCustomer = new CustomerAsPerson(name, surname, personCode, address, phone);
        allAbstractCustomer.add(newCustomer);
    }
        
    
    public static void createNewCustomerAsCompany(Address address, String phone, String companyName, String companyRegistrationNumber) throws Exception
    {
 	   if (address == null || phone == null || companyName == null || companyRegistrationNumber == null) {
 		   throw new Exception("Problems with input");
 	   }

        for (AbstractCustomer customer : allAbstractCustomer) {
            if (customer instanceof CustomerAsCompany && ((CustomerAsCompany) customer).getCompanyRegNo().equals(companyRegistrationNumber)){
         	   throw new Exception("Company already exists!");
             }
        
    		}

             
        CustomerAsCompany newCustomer = new CustomerAsCompany(address, phone, companyName, companyRegistrationNumber);
        allAbstractCustomer.add(newCustomer);
     }
    
    
    public static void createNewParcelForCustomer(LocalDateTime plannedDelivery, ParcelSize size,
    		boolean isFragile, Driver driver, String costumerCode) throws Exception {
    	
    	if (size == null || driver == null || costumerCode == null)
            throw new Exception("Problems with input");
    	
    	boolean customerFound = false;
    	
    	for (AbstractCustomer customer : allAbstractCustomer) {
            if (customer.getCustomerCode().equals(costumerCode)) {
            	Parcel newParcel = new Parcel(isFragile, size, plannedDelivery, driver);
    			customer.addNewParcel(newParcel);
    			customerFound = true;
    	        return; 
            }
        }
    	
    	if (!customerFound) {
	        throw new Exception("Customer with code '" + costumerCode + "' not found.");
	    }
    	
    }
    
   
   
    public static ArrayList<Parcel> retrieveAllParcelsByCustomerCode(String customerCode) throws Exception {
        if (customerCode == null) throw new Exception("Problems with input");
        
        
        ArrayList<Parcel> allParcels = new ArrayList<>();
        boolean customerFound = false;
        
        for (AbstractCustomer customer : allAbstractCustomer) {
            if (customer.getCustomerCode().equals(customerCode)) {
                allParcels.addAll(customer.getParcels());
                customerFound = true;
            }
        }
        
        if (!customerFound) {
	        throw new Exception("No parcels found.");
	    }
	    
        
        return allParcels;
    }
    
    
    public static ArrayList<Parcel> retrieveAllParcelsByDriverPersonCode(String personCode) throws Exception{
    	 if (personCode == null) throw new Exception("Problems with input");
    	 
    	 ArrayList<Parcel> allParcels = new ArrayList<>();
    	 boolean driverFound = false;
    	 
    	 for (AbstractCustomer customer : allAbstractCustomer) {
    	        for (Parcel parcel : customer.getParcels()) {
    	            if (parcel.getDriver().getPersonCode().equals(personCode)) {
    	                allParcels.add(parcel);
    	                driverFound = true;
    	            }
    	        }
    	    }
    	 
    	 if (!driverFound) {
    	        throw new Exception("No parcels found.");
    	    }
    	    
    	 return allParcels;
    	
    }
    
    
    public static ArrayList<Parcel> retrieveallParcelsByCity(City city) throws Exception{
    	if (city == null) throw new Exception("Problems with input");
   	 
   	 	ArrayList<Parcel> allParcels = new ArrayList<>();
   	 	boolean cityFound = false;
   	 	
	   	 for (AbstractCustomer customer : allAbstractCustomer) {
		        if(customer.getAddress().getCity().equals(city)) {
		                allParcels.addAll(customer.getParcels());
		                cityFound = true;
		         }
		 }
    
	    if (!cityFound) {
	        throw new Exception("No parcels found.");
	    }
	    
	    return allParcels;
	    	
	    	
	    }
    
    public static ArrayList<Parcel> retrieveallParcelsByParcelSize(ParcelSize parcelSize) throws Exception{
    	if (parcelSize == null) throw new Exception("Problems with input");
   	 
   	 	ArrayList<Parcel> allParcels = new ArrayList<>();
   	 	boolean sizeFound = false;
   	 	
	   	 for (AbstractCustomer customer : allAbstractCustomer) {
		        for (Parcel parcel : customer.getParcels()) {
		            if (parcel.getSize().equals(parcelSize)) {
		                allParcels.add(parcel);
		                sizeFound = true;
		            }
		        }
		    }
		 
		 if (!sizeFound) {
		        throw new Exception("No parcels found.");
		    }
		    
		 return allParcels;
    	
    	
    }
    
    
    
    public static float calculatePriceOfAllCustomerParcelsByCustomerCode(String costumerCode) throws Exception {
    	
    	if (costumerCode == null) throw new Exception("Problems with input");
    	
    	float totalPrice = 0;
    	boolean customerFound = false;
    	
    	for (AbstractCustomer customer : allAbstractCustomer) {
    		if (customer.getCustomerCode().equals(costumerCode)) {
    			for(Parcel tempParcel: customer.getParcels()) {
    				totalPrice += tempParcel.getPrice();
    				customerFound = true;
    			}
    		}
    	}
    	
    	if (!customerFound) {
	        throw new Exception("Customer not found");
	    }
    	
    	return totalPrice;
    	
    }
    
    
    public static int[] retrieveStatisticsOfCustomerParcelSize(String customerCode) throws Exception {
        if (customerCode == null) {
        	throw new Exception("Problems with input");
        }

        int[] statisticsOfParcel = new int[ParcelSize.values().length];
        boolean customerFound = false;

        for (AbstractCustomer customer : allAbstractCustomer) {
            if (customer.getCustomerCode().equals(customerCode)) {
                customerFound = true; 
                for (Parcel parcel : customer.getParcels()) {
                    ParcelSize size = parcel.getSize();

                    switch (size) {
                        case X:
                            statisticsOfParcel[0]++;
                            break;
                        case S:
                            statisticsOfParcel[1]++;
                            break;
                        case M:
                            statisticsOfParcel[2]++;
                            break;
                        case L:
                            statisticsOfParcel[3]++;
                            break;
                        case XL:
                            statisticsOfParcel[4]++;
                            break;
                        case Undefined:
                            statisticsOfParcel[5]++;
                            break;
                    }
                }
            }
        }

        if (!customerFound) {
            throw new Exception("Customer not found");
        }

        return statisticsOfParcel;
    }
    
    
    public static int calculateHowManyParcelsTodayDeliveredToSpecificCity(City city) throws Exception {
        if (city == null) {
        	throw new Exception("Problems with input");
        }
        
        int parcelsDeliveredToday = 0;
        boolean cityFound = false;
        
        LocalDate today = LocalDate.now(); 
        
        for (AbstractCustomer customer : allAbstractCustomer) {
            if (customer.getAddress().getCity().equals(city)) {
                cityFound = true;
                for (Parcel parcel : customer.getParcels()) {
                    if (parcel.getPlannedDelivery().toLocalDate().isEqual(today)) {
                        parcelsDeliveredToday++;
                    }
                }
            }
        }
        
        if (!cityFound) {
            throw new Exception("No parcels found for city: " + city);
        }
        
        return parcelsDeliveredToday;
    }

    
    
    public static void sortDriversByExperience() { // bubble sort
        int numberOfDrivers = allDrivers.size(); 

        for (int i = 0; i < numberOfDrivers - 1; i++) {
            for (int j = 0; j < numberOfDrivers - i - 1; j++) {
                if (allDrivers.get(j).getExperienceInYears() > allDrivers.get(j + 1).getExperienceInYears()) {
                    Driver temp = allDrivers.get(j);
                    allDrivers.set(j, allDrivers.get(j + 1));
                    allDrivers.set(j + 1, temp);
                }
            }
        }
    }
    
    
    public static void generateCustomerAsPersonAndParcel() {
       
    	Random random = new Random();
        
    	String[] randomNames = {"Mary", "Laura", "Vivian", "Karina", "Claudio", "Agnes", "Matiss", "Eriks", "Juris"};
        String[] randomSurnames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez"};
        String[] randomStreetTitles = {"Elm Street", "Maple Street", "Oak Street", "Pine Street", "Cedar Street", "Main Street"};
        String[] randomPhoneNumbers = {"5551234", "5555678", "5559876", "5554321", "5558765", "5552345"};
        
        String personCode = String.format("%06d-%05d", random.nextInt(1000000), random.nextInt(100000));
        
        String name = randomNames[random.nextInt(randomNames.length)];
        String surname = randomSurnames[random.nextInt(randomSurnames.length)];
        String street = randomStreetTitles[random.nextInt(randomStreetTitles.length)];
        int houseNo = random.nextInt(100) + 1;
        
        City[] cities = Arrays.copyOfRange(City.values(), 0, City.values().length - 1);
        City city = cities[random.nextInt(cities.length)];
        
        Address address = new Address(city, street, houseNo);
        String phoneNo = randomPhoneNumbers[random.nextInt(randomPhoneNumbers.length)];

        CustomerAsPerson randomCustomer = null;
        try {
            randomCustomer = new CustomerAsPerson(name, surname, personCode, address, phoneNo);
        } catch (Exception e) {
            System.out.println("Failed to create customer: " + e.getMessage());
            return;
        }

        allAbstractCustomer.add(randomCustomer);

        LocalDateTime plannedDelivery = LocalDateTime.now().plusDays(random.nextInt(7) + 1);

        ParcelSize[] sizes = Arrays.copyOfRange(ParcelSize.values(), 0, ParcelSize.values().length - 1);
        ParcelSize parcelSize = sizes[random.nextInt(sizes.length)];
       
        boolean isFragile = random.nextBoolean();

        Driver randomDriver = allDrivers.get(random.nextInt(allDrivers.size()));

        try {
            createNewParcelForCustomer(plannedDelivery, parcelSize, isFragile, randomDriver, randomCustomer.getCustomerCode());
        } catch (Exception e) {
            System.out.println("Failed to create parcel for customer: " + e.getMessage());
            return;
        }
    }

    
    public static void generateCustomerAsCompanyAndParcel() {
        Random random = new Random();

        String[] randomTitles = {"ABC Corporation", "XYZ Industries", "Smith & Co.", "Johnson Ltd.", "Miller Enterprises", "Brown Group"};
        String[] randomStreetTitles = {"Elm Street", "Maple Street", "Oak Street", "Pine Street", "Cedar Street", "Main Street"};
        String[] randomPhoneNumbers = {"5551234", "5555678", "5559876", "5554321", "5558765", "5552345"};

        String companyRegNo = String.format("%09d", random.nextInt(1000000000));

        String title = randomTitles[random.nextInt(randomTitles.length)];
        String street = randomStreetTitles[random.nextInt(randomStreetTitles.length)];
        int houseNo = random.nextInt(100) + 1;
        
        City[] cities = Arrays.copyOfRange(City.values(), 0, City.values().length - 1);
        City city = cities[random.nextInt(cities.length)];

        Address address = new Address(city, street, houseNo);
        String phoneNo = randomPhoneNumbers[random.nextInt(randomPhoneNumbers.length)];

        CustomerAsCompany randomCompany = null;
        try {
            randomCompany = new CustomerAsCompany(address, phoneNo, title, companyRegNo);
        } catch (Exception e) {
            System.out.println("Failed to create company: " + e.getMessage());
            return;
        }

        allAbstractCustomer.add(randomCompany);

        LocalDateTime plannedDelivery = LocalDateTime.now().plusDays(random.nextInt(7) + 1);

        ParcelSize[] sizes = Arrays.copyOfRange(ParcelSize.values(), 0, ParcelSize.values().length - 1);
        ParcelSize parcelSize = sizes[random.nextInt(sizes.length)];
        
        boolean isFragile = random.nextBoolean();

        Driver randomDriver = allDrivers.get(random.nextInt(allDrivers.size()));

        try {
            createNewParcelForCustomer(plannedDelivery, parcelSize, isFragile, randomDriver, randomCompany.getCustomerCode());
        } catch (Exception e) {
            System.out.println("Failed to create parcel for customer: " + e.getMessage());
            return;
        }
    }

    
    
}
