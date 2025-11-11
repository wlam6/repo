public class CheckingAccount extends BankAccount
{
	private static final double FEE = 0.15;
	
	public CheckingAccount(String name, double amount)
	{
		super(name, amount);
		super.setAccountNumber(super.getAccountNumber() + "-10");
	}
	
	@Override
	public boolean withdraw(double amount)
	{
		boolean completed = true;

		if (amount + 0.15 <= super.getBalance())
		{
			super.setBalance(super.getBalance() - (amount + 0.15));
		}
		else
		{
			completed = false;
		}
		return completed;
	}
}
