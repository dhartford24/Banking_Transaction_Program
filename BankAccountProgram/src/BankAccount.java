import java.text.NumberFormat;

public class BankAccount implements BankAccountRW {

	private double startingAmount;
	private double total;
	
	public BankAccount() {
		startingAmount = 1000.00;
		total = startingAmount;
	} //end BankAccount constructor
	
	public void displayStartingBalances() {
		System.out.println("Welcome to the Account application\n");
		System.out.println("Starting Balances");
		System.out.println("Checking: " + this.getFormattedAmount(this.getStartingAmount()));
		System.out.println("Savings: " + this.getFormattedAmount(this.getStartingAmount()));
		System.out.println("");
	} //end displayStartingBalance
	
	public double getStartingAmount() {
		return this.startingAmount;
	}
	
	public String getFormattedAmount(double myAmount) {
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setMaximumFractionDigits(2);
		return currency.format(myAmount);
	} //end getFormattedAmount
	
	public void withdrawal(double amount) {
		total -= amount;
	} //end withdrawal
	
	public void deposit(double amount) {
		total += amount;
	} //end deposit
	
	public double getTotal() {
		return this.total;
	}
	
	public void printPaymentsAndFees() {
		System.out.println("Monthly Payments and Fees");
	}
	
	@Override
	public String toString() {
		return "Final Balances\n";
	} //end toString
	
} //end BankAccount class
