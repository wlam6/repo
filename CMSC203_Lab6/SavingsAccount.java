public class SavingsAccount extends BankAccount
{
	private double rate = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double balance)
	{
		super(name, balance);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public SavingsAccount(SavingsAccount account, double balance)
	{
		super(account.getOwner(), balance);
		accountNumber = super.getAccountNumber() + "-" + (savingsNumber + 1);
	}
	
	public void postInterest()
	{
		super.deposit(super.getBalance() * rate);
	}
	
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}
}
