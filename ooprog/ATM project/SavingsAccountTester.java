public class SavingsAccountTester
{
	public static void main(String[] args)
	{
		SavingsAccount jimmysSavings = new SavingsAccount(1000, 0.10);
		jimmysSavings.withdraw(250);
		jimmysSavings.deposit(400);
		jimmysSavings.addInterest();
		System.out.println(jimmysSavings.getBalance());
		System.out.println("Expected: 1265.0");
		//1000-250=750 => 750+400=1150 => 1150+1150*0.10=1265.0
	}
}