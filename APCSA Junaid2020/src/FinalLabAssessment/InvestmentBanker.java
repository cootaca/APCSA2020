package FinalLabAssessment;

public class InvestmentBanker implements Comparable<InvestmentBanker> {
	private String name;
	private Job job;
	public InvestmentBanker() {
		setName("");
		setJob("","");
	}
	public InvestmentBanker(String name, String compss, String pos) {
		setName(name);
		setJob(compss,pos);
	}
	public void setName(String nam) {
		name = nam;
	}
	public void setJob(String compss, String pos) {
		job = new Job(compss, pos);
	}
	public String getName() {
		return name;
	}
	public Job getJob() {
		return job;
	}
	public String getPosition() {
		return job.getPosition();
	}
	public double baseSalary() {
		return job.getComp().get(0);
	}
	public double cashBonus() {
		return job.getComp().get(1);
	}
	public double stockBonus() {
		return job.getComp().get(2);
	}
	public double totalCompensation() {
		return job.totalCompensation();
	}
	public String highestCompensation() {
		return job.highestCompensation();
	}
	public int compareTo(InvestmentBanker invBan) {
		if(invBan.totalCompensation()>totalCompensation()) {
			return -1;
		}
		else if(totalCompensation()>invBan.totalCompensation()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public String toString() {
		return "Name is "+ name+" and their job is as follows: "+job.toString();
	}
}
