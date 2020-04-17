package APCSA_FRQ_Set1;

public class BatteryCharger {
	private int[] rateTable= {50,60,160,60,80,100,100,120,150,150,150,200,40,240,220,220,200,200,180,180,140,100,80,60};
	public int getChargingCost(int startHour, int chargeTime) {
		int cost =0;
		int i =0;
		while(i<chargeTime) {
			int index=(startHour+i)%24;
			cost+=rateTable[index];
			i++;
		}
		return cost;
	}
	public int getChargeStartTime(int chargeTime) {
		int minimumCost = getChargingCost(0,chargeTime);
		int time = 0;
		int i=1;
		while(i<24) {
			if(getChargingCost(i,chargeTime)<minimumCost) {
				minimumCost = getChargingCost(i,chargeTime);
				time =i;
			}
			i++;
		}
		return time;
	}
}
