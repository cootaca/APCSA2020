package APCSA_FRQ_Set1;

public class BatteryChargerRunner {
	public static void main(String args[]) {
		BatteryCharger charger = new BatteryCharger();
		System.out.println(charger.getChargingCost(12,1));
		System.out.println(charger.getChargingCost(0,2));
		System.out.println(charger.getChargingCost(22,7));
		System.out.println(charger.getChargingCost(22,30));
		
		System.out.println(charger.getChargeStartTime(1));
		System.out.println(charger.getChargeStartTime(2));
		System.out.println(charger.getChargeStartTime(7));
		System.out.println(charger.getChargeStartTime(30));
		
	}
}
