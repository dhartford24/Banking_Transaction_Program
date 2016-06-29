
public class Checking extends BankAccount implements Printable {

	private double checkingFee;
	
	public Checking() {
		super();
		checkingFee = 0.0;
	} //end Checking constructor
	
	public double getCheckingFee() {
		return this.checkingFee;
	}
	
	public void setCheckingFee(double checkingFee) {
		this.checkingFee = checkingFee;
	}
	
	public double calcTotalChecking() {
		return super.getTotal() - this.getCheckingFee();
	}
	
	public void printCheckingFee() {
		System.out.println("Checking fee:              " + 
				super.getFormattedAmount(this.getCheckingFee()));
	}
	
	@Override
	public String toString() {
		return super.toString() + "Checking:  " +
				super.getFormattedAmount(this.calcTotalChecking());
	}
	
	public void print() {
		System.out.println(toString());
	}
	
} //end class
