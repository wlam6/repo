/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Represents management company object Project 4
 * Due: 10/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: William Lam
*/

public class ManagementCompany 
{
	static final int MAX_PROPERTY = 5, MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name, taxID;
	private int numberOfProperties;
	private Plot plot;
	private Property[] properties = new Property[MAX_PROPERTY];
	
	// Creates a ManagementCompany object using empty strings, creates a default Plot with maximum width and depth and it initializes the properties array.
	public ManagementCompany()
	{
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	// Creates a ManagementCompany object using the given values, creates a default Plot with maximum width and depth and it initializes the properties array.
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	// Creates a ManagementCompany object using the given values creates a Plot using the given values and it initializes the properties array.
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
	}
	
	// Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
	public int addProperty(String name, String city, double rent, String owner)
	{
		Property property = new Property(name, city, rent, owner);
		
		if (property.getPlot().encompasses(this.plot) == false)
		{
			return -3;
		}
		else if (property.getPlot().overlaps(this.plot))
		{
			return -4;
		}
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				properties[i] = property;
				return i;
			}
		}
		
		// Array is full (no null spaces)
		return -1;
	}
	
	// Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
		if (property.getPlot().encompasses(this.plot) == false)
		{
			return -3;
		}
		else if (property.getPlot().overlaps(this.plot))
		{
			return -4;
		}
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				properties[i] = property;
				return i;
			}
		}
		
		// Array is full (no null spaces)
		return -1;
	}
	
	// Creates a property object by copying from another property and adds it to the properties array.
	public int addProperty(Property property)
	{
		if (property == null)
		{
			return -2;
		}
		else if (property.getPlot().encompasses(this.plot) == false)
		{
			return -3;
		}
		else if (property.getPlot().overlaps(this.plot))
		{
			return -4;
		}
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				properties[i] = property;
				return i;
			}
		}
		
		// Array is full (no null spaces)
		return -1;
	}
	
	/**
	 * @return Returns the index of the property with the maximum rent amount.
	 */
	public Property getHighestRentProperty()
	{
		Property highest = properties[0];
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] != null && properties[i].getRentAmount() > highest.getRentAmount())
			{
				highest = properties[i];
			}
		}
		return highest;
	}
	
	/**
	 * @return Returns the index of the property with the maximum rent amount.
	 */
	private int getHighestRentPropertyIndex()
	{
		int highestIndex = 0;
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] != null && properties[i].getRentAmount() > properties[highestIndex].getRentAmount())
			{
				highestIndex = i;
			}
		}
		return highestIndex;
	}
	
	/**
	 * @return the mgmFeePer
	 */
	public double getMgmFeePer() {
		return mgmFeePer;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the taxID
	 */
	public String getTaxID() {
		return taxID;
	}

	/**
	 * @return the numberOfProperties
	 */
	public int getPropertiesCount() {
		return numberOfProperties;
	}

	/**
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * @return the properties
	 */
	public Property[] getProperties() {
		return properties;
	}
	
	/**
	 * @return Returns the total rent of the properties in the properties array
	 */
	public double getTotalRent() {
		double total = 0;
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] != null)
			{
				total += properties[i].getRentAmount();
			}
		}
		return total;
	}
	
	/**
	 * @return Checks if the management company has a valid (between 0-100) fee
	 */
	public boolean isMangementFeeValid()
	{
		return mgmFeePer >= 0 && mgmFeePer <= 100;
	}
	
	/**
	 * @return Checks if the properties array has reached the maximum capacity
	 */
	public boolean isPropertiesFull()
	{
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] == null)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @return Removes(nullifies) the LAST property in the properties array
	 */
	public void removeLastProperty()
	{
		for (int i = MAX_PROPERTY - 1; i >= 0; i--)
		{
			if (properties[i] != null)
			{
				properties[i] = null;
				break;
			}
		}
	}
	
	/**
	 * @return Represents the information of all the properties in the properties array.
	 */
	public String toString()
	{
		String total = 
		"List of the properties for " + name + ", taxID: " + taxID + "______________________________________________________";
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] != null)
			{
				total += properties[i];
			}
			total += "\n";
		}
		total += "______________________________________________________" + "\n\ntotal management Fee: " + getTotalRent();
		return total;
	}
}
