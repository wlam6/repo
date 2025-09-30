/* 

 * Class: CMSC203  

 * Instructor: Farnaz Eivazi

 * Description: Uses the patient and procedure classes to create objects for a patient and procedure and prints information

 * Due: 9/29/2025

 * Platform/compiler: Eclipse

 * I pledge that I have completed the programming  

 * assignment independently. I have not copied the code  

 * from a student or any source. I have not given my code  

 * to any student. 

   Print your Name here: William Lam 

*/ 

import java.util.Scanner;

public class PatientDriverApp
{
	public static void main(String[] args)
	{
		final String STUDENT_NAME = "William Lam";
		final String STUDENT_ID = "M21105346";
		final String DUE_DATE = "9/29/2025";
		
		String firstName, middleName, lastName, streetAddress, city, state, zipCode, phoneNumber, emergencyName, emergencyPhone;
		Scanner input = new Scanner(System.in);
		
		// User input
		System.out.println("Enter first name: ");
		firstName = input.nextLine();
		System.out.println("Enter middle name: ");
		middleName = input.nextLine();
		System.out.println("Enter last name: ");
		lastName = input.nextLine();
		System.out.println("Enter street address: ");
		streetAddress = input.nextLine();
		System.out.println("Enter city: ");
		city = input.nextLine();
		System.out.println("Enter state: ");
		state = input.nextLine();
		System.out.println("Enter zip code: ");
		zipCode = input.nextLine();
		System.out.println("Enter phone number: ");
		phoneNumber = input.nextLine();
		System.out.println("Enter emergency contact name: ");
		emergencyName = input.nextLine();
		System.out.println("Enter emergency contact phone number: ");
		emergencyPhone = input.nextLine();
		input.close();
		
		// Create objects
		Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zipCode, phoneNumber, emergencyName, emergencyPhone);
		
		Procedure procedure1 = new Procedure();
		procedure1.setProcedureName("Physical Exam");
		procedure1.setProcedureDate("7/20/2019");
		procedure1.setProcedurePractitioner("Dr. Irvine");
		procedure1.setProcedureCharge(3250.0);
		
		Procedure procedure2 = new Procedure("X-ray", "7/20/2019");
		procedure2.setProcedurePractitioner("Dr. Jamison");
		procedure2.setProcedureCharge(5500.43);
		
		Procedure procedure3 = new Procedure("Blood Test", "7/20/2019", "Dr. Smith", 1400.75);
		
		// Print to user
		System.out.println("\nPatient info:");
		displayPatient(patient);
		displayProcedure(procedure1);
		displayProcedure(procedure2);
		displayProcedure(procedure3);
		
		System.out.printf("Total Charges: $%,.2f", calcluateTotalCharges(procedure1, procedure2, procedure3));
		
		// Print programmer information
		System.out.println("\n\nStudent Name: " + STUDENT_NAME);
		System.out.println("MC#: " + STUDENT_ID);
		System.out.println("Due Date: " + DUE_DATE);
	}
	
	/*
	 * Display the patient info
	 */ 
	public static void displayPatient(Patient patient)
	{
		System.out.println(patient);
	}
	
	/*
	 * Display a procedure info
	 */ 
	public static void displayProcedure(Procedure procedure)
	{
		System.out.println(procedure);
	}
	
	/*
	 * Calculate all 3 procedure charges
	 */ 
	public static double calcluateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3)
	{
		return procedure1.getProcedureCharge() + procedure2.getProcedureCharge() + procedure3.getProcedureCharge();
	}
}
