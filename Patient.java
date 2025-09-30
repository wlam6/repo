/* 

 * Class: CMSC203  

 * Instructor: Farnaz Eivazi

 * Description: Creates the blueprint of a patient, containing 3 constructors

 * Due: 9/29/2025

 * Platform/compiler: Eclipse

 * I pledge that I have completed the programming  

 * assignment independently. I have not copied the code  

 * from a student or any source. I have not given my code  

 * to any student. 

   Print your Name here: William Lam 

*/ 

public class Patient 
{
	private String firstName, middleName, lastName, streetAddress, city, state, zipCode, phoneNumber, emergencyName, emergencyPhone;
	
	/*
	 * Constructor no arg
	 */ 
	public Patient(){}
	
	/*
	 * Constructor name args
	 */ 
	public Patient(String firstName, String middleName, String lastName)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	/*
	 * Constructor all args
	 */ 
	public Patient(String firstName, String middleName, String lastName, String streetAddress, 
	String city, String state, String zipCode, String phoneNumber, String emergencyName, String emergencyPhone)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.emergencyName = emergencyName;
		this.emergencyPhone = emergencyPhone;
	}
	
	/*
	 * Accessors for each variale
	 */
	public String getFirstName()
	{
		return firstName;
	}
	public String getMiddleName()
	{
		return middleName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getStreetAddress()
	{
		return streetAddress;
	}
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public String getEmergencyName()
	{
		return emergencyName;
	}
	public String getEmergencyPhone()
	{
		return emergencyPhone;
	}
	
	/*
	 * Mutators for each variable
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public void setEmergencyName(String emergencyName)
	{
		this.emergencyName = emergencyName;
	}
	public void setEmergencyPhone(String emergencyPhone)
	{
		this.emergencyPhone = emergencyPhone;
	}
	
	/*
	 * Returns full name
	 */
	public String buildFullName()
	{
		return firstName + " " + middleName + " " + lastName;
	}
	
	/*
	 * Returns full address
	 */
	public String buildAddress()
	{
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}
	
	/*
	 * Returns emergency info
	 */
	public String buildEmergencyContact()
	{
		return emergencyName + " " + emergencyPhone;
	}
	
	/*
	 * Overwrite toString for printing
	 */
	public String toString()
	{
		return "  Name: " + buildFullName() + "\n  Address: " + buildAddress() + "\n  EmergencyContact: " + buildEmergencyContact() + "\n";
	}
}