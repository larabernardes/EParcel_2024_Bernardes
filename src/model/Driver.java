package model;

public class Driver extends Person {
	
	// 1. Variables

	private long dID;
	private String licenseNo;
	private float experienceInYears;
	
	private static long counter = 0;
	
	
	
	// 2. Getters and setters

	public long getdID() {
		return dID;
	}
	

	public void setdID() {
		this.dID = counter;
		counter++;
	}
	

	public String getLicenseNo() {
		return licenseNo;
	}
	

	public void setLicenseNo(String licenseNo) {
		if(licenseNo != null  && licenseNo.matches("[A-Z0-9]{10}"))
			this.licenseNo = licenseNo;
		else
			this.licenseNo = "Undefinied";
	}
	

	public float getExperienceInYears() {
		return experienceInYears;
	}

	
	public void setExperienceInYears(float experienceInYears) {
		if(experienceInYears > 0 && experienceInYears < 60)
			this.experienceInYears = experienceInYears;
		else
			this.experienceInYears = 0;
	}

	
	// 3. Constructors
	
	public Driver() {
		super();
		setLicenseNo("00000000");
		setExperienceInYears(0);
	}
	
	
	public Driver(String name, String surname, String personCode, String licenseNo, float experienceInYears) {
		super(name, surname, personCode);
		setLicenseNo(licenseNo);
		setExperienceInYears(experienceInYears);
	}
	
	
	// 4. toStriing 
	
	@Override
	public String toString()
	{
		return dID + ": " + super.toString() + " (" + "Experience in years: " + experienceInYears + ")";
	}
	
	
	// 5. Other functions

}
