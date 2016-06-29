
public class Savings extends BankAccount implements Printable {

	private double interestPayment;
	
	public Savings() {
		super();
		interestPayment = 0.0;
	} //end Savings constructor
	
	public double getInterestPayment() {
		return this.interestPayment;
	} //end getInterestPayment
	
	public void calcInterest() {
		interestPayment = super.getTotal() * .01;
	} //end calcInterest
	
	public double calcTotalSavings() {
		return super.getTotal() + this.getInterestPayment();
	}
	
	public void printInterestPayment() {
		this.calcInterest();
		System.out.println("Savings interest payment:  " + 
				super.getFormattedAmount(this.getInterestPayment()) + "\n");
	}
	
	@Override
	public String toString() {
		return "Savings:   " + this.getFormattedAmount(this.calcTotalSavings());
	}
	
	public void print() {
		System.out.println(toString());
	}
	
}
