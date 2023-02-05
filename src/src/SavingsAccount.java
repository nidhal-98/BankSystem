package src;

public class SavingsAccount extends Account {
	private double interest;
	
	public void setInterest(double interest ) {
		this.interest = interest ;
	}
	
	public double getInterest () {
		return interest;
	}
}