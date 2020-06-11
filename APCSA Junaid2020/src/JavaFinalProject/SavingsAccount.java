package JavaFinalProject;

import java.io.IOException;
import java.time.Instant;
import java.util.Scanner;

public class SavingsAccount extends InvestmentVehicle{
	private double interestRate;
	private double moneyInitiallyInvested;
	private double savingsProfit;
	private String dateMoneyPutIn;
	private double yearsPutIn;
	public SavingsAccount() {
		super();
	}
	public SavingsAccount(String nam){
		setName(nam);
	}
	public SavingsAccount(String nam, double money){
		super(nam,money); 
	}
	public SavingsAccount(String nam, double money, double rateOfReturn){
		super(nam,money, rateOfReturn);
	}
	public void setInterestRate(double interestRate) {
		this.interestRate= interestRate;
	}
	public void setMoneyInvested(double moneyInitiallyInvested) {
		this.moneyInitiallyInvested= moneyInitiallyInvested;
	}
	public void setSavingsProfit() {
		this.savingsProfit= moneyInitiallyInvested*Math.pow(Math.E,interestRate*yearsPutIn);
	}
	public void setYearsMoneyPutIn(double yearsPutIn) {
		this.yearsPutIn= yearsPutIn;
	}
	public void setDateMoneyPutIn(String dateMoneyPutIn) {
		Integer tempHolder= Stock.dateToSeconds(dateMoneyPutIn+"T00:00:00.000-0000");
		Instant instant = Instant.now();
		Integer currentTime = (int)instant.getEpochSecond();
		this.yearsPutIn = (double)((double)currentTime-tempHolder)/(31540000.0);
		this.dateMoneyPutIn= dateMoneyPutIn;
	}
	public double getInterestRate(){
		return this.interestRate;
	}
	
	public double getMoneyInvested() {
		return this.moneyInitiallyInvested;
	}
	public double getSavingsProfit() {
		this.savingsProfit= moneyInitiallyInvested*Math.pow(Math.E,interestRate/100*yearsPutIn);
		return this.savingsProfit;
	}
	public String getDatePutIn() {
		return this.dateMoneyPutIn;
	}
	public double getYearsPutIn() {
		return this.yearsPutIn;
	}
	public static void main(String args[]) throws IOException{
	   	  Scanner scan = new Scanner(System.in);
	      System.out.println("Enter the date the money was put in: ");
	      String date = scan.next();
	      System.out.println("Enter the amount of money that was put in: ");
	      double mons = scan.nextDouble();
	      System.out.println("Enter the APY: ");
	      double rate = scan.nextDouble();
	      SavingsAccount account = new SavingsAccount();
	      account.setDateMoneyPutIn(date);
	      account.setMoneyInvested(mons);
	      account.setInterestRate(rate);
	      System.out.println(account.getSavingsProfit());
	      
	   }
}
