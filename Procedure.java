/* 

 * Class: CMSC203  

 * Instructor: Farnaz Eivazi

 * Description: Creates the blueprint of a procedure, containing 3 constructors

 * Due: 9/29/2025

 * Platform/compiler: Eclipse

 * I pledge that I have completed the programming  

 * assignment independently. I have not copied the code  

 * from a student or any source. I have not given my code  

 * to any student. 

   Print your Name here: William Lam 

*/ 

public class Procedure 
{
	private String procedureName, procedureDate, procedurePractitioner;
	private double procedureCharge;
	
	/*
	 * Constructor no arg
	 */ 
	public Procedure() {}
	
	/*
	 * Constructor name and date args
	 */ 
	public Procedure(String procedureName, String procedureDate)
	{
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
	}
	
	/*
	 * Constructor all args
	 */ 
	public Procedure(String procedureName, String procedureDate, String procedurePractitioner, double procedureCharge)
	{
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
		this.procedurePractitioner = procedurePractitioner;
		this.procedureCharge = procedureCharge;
	}
	
	/*
	 * Accessors for each variable
	 */
	public String getProcedureName()
	{
		return procedureName;
	}
	public String getProcedureDate()
	{
		return procedureDate;
	}
	public String getProcedurePractitioner()
	{
		return procedurePractitioner;
	}
	public double getProcedureCharge()
	{
		return procedureCharge;
	}
	
	/*
	 * Mutators for each variable
	 */
	public void setProcedureName(String procedureName)
	{
		this.procedureName = procedureName;
	}
	public void setProcedureDate(String procedureDate)
	{
		this.procedureDate = procedureDate;
	}
	public void setProcedurePractitioner(String procedurePractitioner)
	{
		this.procedurePractitioner = procedurePractitioner;
	}
	public void setProcedureCharge(double procedureCharge)
	{
		this.procedureCharge = procedureCharge;
	}
	
	/*
	 * Overwrite toString for printing
	 */
	public String toString()
	{
		return "\tProcedure: " + procedureName + "\n\tProcedureDate=" + procedureDate + "\n\tPractitioner=" + procedurePractitioner
		+ "\n\tCharge=" + procedureCharge + "\n";
	}
}
