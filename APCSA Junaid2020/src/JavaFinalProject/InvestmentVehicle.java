package JavaFinalProject;

public class InvestmentVehicle {
	private String name;
	private double moneyInvested;
	private double predictedRateOfReturn;
	public InvestmentVehicle() {
		name="Jugo";
		moneyInvested=0;
		predictedRateOfReturn=0;
	}
	public InvestmentVehicle(String nam){
		setName(nam);
	}
	public InvestmentVehicle(String nam, double money){
		setName(nam);
		setMoneyInvested(money);
	}
	public InvestmentVehicle(String nam, double money, double rateOfReturn){
		setName(nam);
		setMoneyInvested(money);
		setMoneyInvested(rateOfReturn);
	}
	public void setName(String nam) {
		name=nam;
	}
	public void setMoneyInvested(double money) {
		moneyInvested = money;
	}
	public void setPredictedRateOfReturn(double rate) {
		predictedRateOfReturn = rate;
	}
	public String getName() {
		return name;
	}
	public double getMoneyInvested() {
		return moneyInvested;
	}
	public double getPredictedRateOfReturn() {
		return predictedRateOfReturn;
	}
	
}

