import java.util.Scanner;

public class BankAccountHelper {
	
	private String choice = "y";
	private String wOrD = "";
	private String cOrS = "";
	private double amountOfMoney;
	private int checkingFeeCount = 0;
	
	public BankAccountHelper() {}

	public void startApp() {
		Scanner input = new Scanner(System.in);
		BankAccount b = new BankAccount();
		b.displayStartingBalances();
		
		System.out.println("Enter the transactions for the month\n");
		
		Checking c = new Checking();
		Savings s = new Savings();
		
		while (choice.equalsIgnoreCase("y")) {
			wOrD = Validator.getChoiceString(input, "Withdrawl or desposit? (w/d): ", "w", "d");
			cOrS = Validator.getChoiceString(input, "Checking or savings? (c/s): ", "c", "s");
			
			if (wOrD.equalsIgnoreCase("w") && cOrS.equalsIgnoreCase("c")) {
				
				amountOfMoney = Validator.getDoubleWithinRange(input, "Amount?: ", -.01, c.getTotal());
				c.withdrawal(amountOfMoney);
				checkingFeeCount++;
			} //end if
			else if (wOrD.equalsIgnoreCase("w") && cOrS.equalsIgnoreCase("s")) {
				
				amountOfMoney = Validator.getDoubleWithinRange(input, "Amount?: ", -.01, s.getTotal());
				s.withdrawal(amountOfMoney);
			} //end else if
			else if (wOrD.equalsIgnoreCase("d") && cOrS.equalsIgnoreCase("c")) {
				
				amountOfMoney = Validator.getDoubleWithMin(input, "Amount?: ", -.01);
				c.deposit(amountOfMoney);
				checkingFeeCount++;
			} //end else if
			else if (wOrD.equalsIgnoreCase("d") && cOrS.equalsIgnoreCase("s")) {
				
				amountOfMoney = Validator.getDoubleWithMin(input, "Amount?: ", -.01);
				s.deposit(amountOfMoney);
			}
			else {
				System.out.println("Error, invalid inputs");
			}
			
			choice = Validator.getChoiceString(input, "\nContinue? (y/n): ", "y", "n");
			System.out.println("");
			
		} //end while
		 
		if (checkingFeeCount > 0) {
			 c.setCheckingFee(1.0);
		 }
		 
		b.printPaymentsAndFees();
		c.printCheckingFee();
		s.printInterestPayment();
		c.print();
		s.print();
	}
	

}
