package FinalLabAssessment;

import java.util.*;

public class Job {
	private ArrayList<Double> comp = new ArrayList<Double>();
	private String position;
	public Job() {
		setComp("");
		setPosition("");
	}
	public Job(String compss, String pos) {
		setComp(compss);
		setPosition(pos);
	}
	
	public void setComp(String compss) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(compss);
		while(scan.hasNextInt()) {
			comp.add((double)scan.nextInt());
		}
	}
	public void setPosition(String pos) {
		position = pos;
	}
	public ArrayList<Double> getComp() {
		return comp;
	}
	public String getPosition() {
		return position;
	}
	public double baseSalary() {
		if(comp.size()>0)
			return comp.get(0);
		else
			return 0;
	}
	public double cashBonus() {
		if(comp.size()>1)
			return comp.get(1);
		else
			return 0;
	}
	public double stockBonus() {
		if(comp.size()>2)
			return comp.get(2);
		else
			return 0;
	}
	public double totalCompensation() {
		int count = 0;
		for(Double dob:comp) {
			count+=dob;
		}
		return count;
	}
	public String highestCompensation() {
		if(baseSalary()>cashBonus()&&baseSalary()>stockBonus()) {
			return "Base Salary is greatest Compensation";
		}
		else if(cashBonus()>stockBonus()) {
			return "Cash bonus is the greatest compensation";
		}
		else {
			return "Stock bonus is the greates compensation";
		}
	}
	public String toString() {
		String output = "Position of banker is " + getPosition()+", Base Salary is "+baseSalary()+", cash bonus is "+cashBonus()+", stockBonus is "+stockBonus();
		return output;
	}
	
}
