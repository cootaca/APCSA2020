package FinalLabAssessment;

import java.io.*;
import java.util.*;

public class Bank {
	private String name;
	private ArrayList<InvestmentBanker> investmentBankers;

	public Bank() {
		setName("");
		investmentBankers = new ArrayList<InvestmentBanker>();
	}

	public Bank(String nam) {
		setName(nam);
		investmentBankers = new ArrayList<InvestmentBanker>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addBankers(InvestmentBanker investmentBanker) {
		investmentBankers.add(investmentBanker);
	}

	public String getBankName() {
		return name;
	}

	public double getAverageCompensation() {
		int totalComp = 0;
		for (InvestmentBanker banker : investmentBankers) {
			totalComp += banker.totalCompensation();
		}
		return totalComp / (investmentBankers.size());
	}

	public double getTotalCompensation() {
		int totalComp = 0;
		for (InvestmentBanker banker : investmentBankers) {
			totalComp += banker.totalCompensation();
		}
		return totalComp;
	}

	public InvestmentBanker getBanker(String nam) {
		for (InvestmentBanker invBa : investmentBankers) {
			if (invBa.getName().equals(nam)) {
				return invBa;
			}
		}
		return null;
	}

	public String getBankerWithHighestCompensation() {
		return investmentBankers.get(investmentBankers.size() - 1).getName();
	}

	public String getBankerWithLowestCompensation() {
		return investmentBankers.get(0).getName();
	}

	public String toString() {
		String output = this.name + "\n";
		for (InvestmentBanker invba : investmentBankers) {
			output += invba.toString() + "\n";
		}
		output += "The average compensation at Goldman Sachs is " + getAverageCompensation()+"\n";
		output += "The total compensation at Goldman Sachs is " + getTotalCompensation();
		return output;
	}
}
