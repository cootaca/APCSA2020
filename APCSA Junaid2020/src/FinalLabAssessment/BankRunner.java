package FinalLabAssessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BankRunner {

	public static void main(String[] args) throws IOException {
		File file = new File("/Users/junaidahmad/eclipse-workspace/Tester2Project/src/FinalLabAssessment/Bankers.dat");
		Scanner scanner = new Scanner(file);
		String BankName = scanner.nextLine();
		Bank bank= new Bank(BankName);
		int totalBankers = Integer.parseInt(scanner.nextLine());
		for(int i =0;i<totalBankers;i++) {
			String nam = scanner.nextLine();
			String pos = scanner.nextLine();
			String sal = scanner.nextLine();
			bank.addBankers(new InvestmentBanker(nam,sal,pos));
		}
		System.out.println(bank);
	}

}
