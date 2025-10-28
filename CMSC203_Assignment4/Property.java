/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Represents property object Project 4
 * Due: 10/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: William Lam
*/

public class Property 
{
	private String city, owner, propertyName;
	private Plot plot;
	private double rentAmount;
	
	// Creates a new Property using empty strings.
	public Property() 
	{
		plot = new Plot();
		this.city = "";
		this.owner = "";
		this.propertyName = "";
	}
	
	// 	Creates a new Property object using given values.
	public Property(String propertyName, String city, double rentAmount, String owner) 
	{
		plot = new Plot();
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
	}
	
	// Creates a new Property object using given values.
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) 
	{
		plot = new Plot(x, y, width, depth);
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
	}
	
	// Creates a new copy of the given property object.
	public Property(Property otherProperty)
	{
		this.city = otherProperty.getCity();
		this.owner = otherProperty.getOwner();
		this.propertyName = otherProperty.getPropertyName();
		this.rentAmount = otherProperty.getRentAmount();
		plot.setX(otherProperty.getPlot().getX());
		plot.setY(otherProperty.getPlot().getY());
		plot.setWidth(otherProperty.getPlot().getWidth());
		plot.setDepth(otherProperty.getPlot().getDepth());
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * @return the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Represents a Property object in the following String format: propertyName,city,owner,rentAmount
	 * @return formatted string
	 */
	public String toString()
	{
		return this.propertyName + "," + this.city + "," + this.owner + "," + this.rentAmount;
	}
	
}
