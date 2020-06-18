package JavaFinalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

import org.w3c.dom.Text;

public class UserInterface implements ActionListener {
	private String userName = "";

	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton logInButton;

	private JFrame frame;

	private JButton loginButton;
	private JButton signUpButton;
	private JPanel signUpPanel;
	private JPasswordField signUpPasswordField;
	private JPasswordField passwordReenter;
	private JLabel passwordCheckLabel;
	private JLabel missingInfo;
	private JPanel logInPanel;
	private JButton goBackToSignUp;
	private JButton goBackToLogin;
	private JLabel loginInUnsuccessful;
	private JPanel stockSearcherPanel;
	private JLabel currentStockPriceTitle;
	private JTextField tickerField;
	private JLabel displayCurrentStockPrice;
	private JButton getCurrentStockButton;
	private JTextField tickerFieldWithDate;
	private JLabel tickerLabelDate;
	private JLabel getStockByDateTitle;
	private JLabel dateLabel;
	private JTextField fetchStockDateField;
	private JButton getStockPriceByDateButton;
	private JLabel displayStockPriceByDate;
	private JLabel displayStockPriceByDate2;
	private JPanel introductionScreenPanel;
	private JLabel introductionScreenTitle;
	private JLabel introductionScreenText;

	private JPanel addSavingsPanel;
	private JLabel addSavingsTitle;
	private JLabel amountSavingsByYearsLabel;
	private JTextField amountSavingsByYearsField;
	private JLabel yearsAmountSavedLabel;
	private JTextField yearsAmountSavedField;
	private JLabel APYByYearsLabel;
	private JTextField APYByYearsField;
	private JLabel bankYearsLabel;
	private JTextField bankYearsField;
	private JButton addSavingsByYearsButton;
	private JLabel displaySuccessOfSavingsByYear;

	private JLabel addDateSavingsTitle;
	private JLabel amountSavingsByDateLabel;
	private JTextField amountSavingsByDateField;
	private JLabel dateAmountSavedLabel;
	private JTextField dateAmountSavedField;
	private JLabel APYByDateLabel;
	private JTextField APYByDateField;
	private JLabel bankdDateLabel;
	private JTextField bankDateField;
	private JButton addSavingsByDateButton;
	private JLabel displaySuccessOfSavingsByDate;

	private JPanel mainMenuPanel;
	private JLabel MainMenuTitle;
	private JButton viewStocksMainMenuButton;
	private JButton addSavingsButtonMainMenu;
	private JButton mainMenuSignOutButton;

	private JButton stockSearcherInterfaceReturnToMainButton;
	private JButton addSavingsReturnToMainButton;

	private JPanel displaySavingsAccountPanel;
	private JLabel displaySavingsAccountTitle;

	private JTextArea displaySavingsText;
	private JScrollPane displaySavingsPane;

	private JPanel buttonOnButtomOfDisplaySavingsPanel;
	private JButton returnToMainSavingsDisplayButton;

	private JButton mainMenuGoToAddStockButton;
	private JButton mainMenuGoToViewSavingsButton;

	private JPanel addStockPanel;
	private JLabel addStockByManualTitle;

	private JLabel addStockByManualTickerLabel;
	private JTextField addStockByManualTickerTextField;

	private JLabel addStockByManualPriceBoughtLabel;
	private JTextField addStockByManualPriceBoughtTextField;

	private JLabel addStockByManualYearsInvestedLabel;
	private JTextField addStockByManualYeatsInvestedTextField;

	private JLabel addStockByManualNumberOfSharesLabel;
	private JTextField addStockByManualNumberOfSharesTextField;

	private JButton addStockByManualButton;
	private JLabel addStockByManualSuccess;

	private JLabel addStockByDateTitle;

	private JLabel addStockByDateTickerLabel;
	private JTextField addStockByDateTickerTextField;

	private JLabel addStockByDateDateLabel;
	private JTextField addStockByDateDateTextField;

	private JLabel addStockByDateNumberOfSharesLabel;
	private JTextField addStockByDateNumberOfSharesTextField;

	private JButton addStockByDateButton;
	private JLabel addStockByDateSuccess;

	private JButton addStockByDateReturnToHomeButton;

	private JButton mainMenuGoToViewStockPortfolioButton;

	private JPanel displayStocksPanel;
	private JLabel displayStocksTitle;

	private JTextArea displayStockText;
	private JScrollPane displayStockPane;

	private JPanel buttonOnButtomOfDisplayStockPanel;

	private JButton returnToMainStockDisplayButton;

	private JButton mainMenuGoToTotalInvestmentsScreenDisplayButton;

	private JPanel displayTotalPortfolioPanel;
	private JLabel displayTotalPortfolioTitle;
	private JTextArea displayTotalPortfolioTextArea;
	private JScrollPane totalPortolioScrollPane;

	private JPanel buttonOnTotalPortfolioDisplay;
	private JButton returnToMainFromTotalPortfolioButton;

	public UserInterface() {
		frame = new JFrame("Finance App");

		introScreen();
		//diplayTotalPortfolio();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void introScreen() {
		frame.setSize(400, 251);
		introductionScreenPanel = new JPanel();
		introductionScreenPanel.setLayout(null);
		frame.add(introductionScreenPanel);

		introductionScreenTitle = new JLabel("Welcome to the Finance App");
		introductionScreenTitle.setFont(new Font("Georgia", Font.BOLD, 25));
		introductionScreenTitle.setBounds(10, 20, 400, 30);
		introductionScreenPanel.add(introductionScreenTitle);

		String text = "This app will allow you to access information about current stocks. It will also allow you to store "
				+ "and access investment information.";
		String formatted = text.replace("\n", "<br>");
		formatted = "<html><font size='4'>" + formatted + "</font></html>";

		introductionScreenText = new JLabel(formatted);
		introductionScreenText.setBounds(10, 60, 390, 100);
		introductionScreenText.setForeground(new Color(203, 87, 242));
		introductionScreenPanel.add(introductionScreenText);

		loginButton = new JButton("Log in");
		loginButton.setBounds(25, 150, 150, 25);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(introductionScreenPanel);
				logInScreen();

			}
		});

		signUpButton = new JButton("Sign Up Here");
		signUpButton.setBounds(25, 190, 150, 25);
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(introductionScreenPanel);
				signUpScreen();

			}
		});

		introductionScreenPanel.add(loginButton);
		introductionScreenPanel.add(signUpButton);

		frame.add(introductionScreenPanel);
	}

	public void logInScreen() {
		// frame.removeAll();

		frame.revalidate();

		logInPanel = new JPanel();
		frame.add(logInPanel);
		// frame.setVisible(true);
		frame.setSize(400, 200);

		logInPanel.setLayout(null);

		userLabel = new JLabel("User");
		userLabel.setBounds(10, 20, 80, 25);
		logInPanel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		logInPanel.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 60, 80, 25);
		logInPanel.add(passwordLabel);

		passwordText = new JPasswordField();
		passwordText.setBounds(100, 60, 165, 25);
		logInPanel.add(passwordText);

		loginInUnsuccessful = new JLabel("");
		loginInUnsuccessful.setBounds(100, 90, 300, 25);
		loginInUnsuccessful.setForeground(new Color(255, 64, 80));
		logInPanel.add(loginInUnsuccessful);

		logInButton = new JButton("Login");
		logInButton.setBounds(10, 90, 80, 25);
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean userExists = false;
				boolean correctUserAndPassword = false;
				String userNam = userText.getText();
				String user = userText.getText().toLowerCase();
				String password = new String(passwordText.getPassword());

				List<String> lines = Collections.emptyList();
				try {
					File file = new File("src/JavaFinalProject/Database.txt");
					Scanner sc = new Scanner(file);
					lines = Files.readAllLines(Paths.get("src/JavaFinalProject/Database.txt"));
					for (String line : lines) {
						String[] arrs = line.split(", ", 0);
						if (arrs[0].toLowerCase().equals(user))
							userExists = true;
						if (arrs[0].toLowerCase().equals(user) && arrs[1].equals(password))
							correctUserAndPassword = true;
					}
				} catch (Exception error) {

				}

				if (correctUserAndPassword) {
					// frame.setVisible(false);
					frame.remove(logInPanel);
					userName = userNam;
					mainMenuScreen();
				} else if (userExists) {
					loginInUnsuccessful.setText("The Password Entered is Not Correct");
				} else {
					loginInUnsuccessful.setText("That Username does not exist");
				}

			}
		});
		logInPanel.add(logInButton);

		goBackToSignUp = new JButton("Go To Sign Up");
		goBackToSignUp.setBounds(10, 125, 125, 25);
		goBackToSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// frame.setVisible(false);
				frame.remove(logInPanel);
				signUpScreen();

			}

		});
		logInPanel.add(goBackToSignUp);

	}

	public void signUpScreen() {
		// frame.setVisible(true);
		frame.revalidate();
		frame.setSize(400, 250);
		signUpPanel = new JPanel();

		signUpPanel.setLayout(null);

		userLabel = new JLabel("User: ");
		userLabel.setBounds(10, 20, 80, 25);
		signUpPanel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(140, 20, 165, 25);

		signUpPanel.add(userText);

		passwordLabel = new JLabel("Enter a Password: ");
		passwordLabel.setBounds(10, 60, 120, 25);
		signUpPanel.add(passwordLabel);

		signUpPasswordField = new JPasswordField("");
		signUpPasswordField.setBounds(140, 60, 165, 25);
		signUpPanel.add(signUpPasswordField);

		passwordCheckLabel = new JLabel("Check Password: ");
		passwordCheckLabel.setBounds(10, 100, 120, 25);
		signUpPanel.add(passwordCheckLabel);

		passwordReenter = new JPasswordField("");
		passwordReenter.setBounds(140, 100, 165, 25);
		signUpPanel.add(passwordReenter);

		signUpButton = new JButton("Sign Up");
		signUpButton.setBounds(10, 135, 80, 25);
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				missingInfo.setText("");
				String user = userText.getText();
				String password = new String(signUpPasswordField.getPassword());
				String passwordCheck = new String(passwordReenter.getPassword());
				if ((user.equals("") || password.equals("") || passwordCheck.equals(""))) {
					missingInfo.setText("Please Enter The Missing Information");
				}
				boolean userExists = false;

				List<String> lines = Collections.emptyList();
				try {
					File file = new File("src/JavaFinalProject/Database.txt");
					Scanner sc = new Scanner(file);
					lines = Files.readAllLines(Paths.get("src/JavaFinalProject/Database.txt"));
					for (String line : lines) {
						String[] arrs = line.split(", ", 0);
						if (arrs[0].toLowerCase().equals(user.toLowerCase()))
							userExists = true;
					}
				} catch (Exception error) {

				}
				if (user.equals("") || password.equals("") || passwordCheck.equals("")) {
					missingInfo.setText("Please Fill In the Missing Information");
				} else if (userExists) {
					missingInfo.setText("This User Already Exists");
				} else if (password.equals(passwordCheck)) {
					try {
						FileWriter writer = new FileWriter("src/JavaFinalProject/Database.txt", true);

						BufferedWriter bufferedWriter = new BufferedWriter(writer);

						bufferedWriter.write(user + ", " + password + "\n");
						bufferedWriter.close();

					} catch (IOException e1) {
						e1.printStackTrace();
					}

					// frame.setVisible(false);
					frame.remove(signUpPanel);
					logInScreen();

				} else {
					missingInfo.setText("The passwords do not match");
					passwordReenter.setText("");
				}

			}
		});

		goBackToLogin = new JButton("Go To Login");
		goBackToLogin.setBounds(10, 175, 110, 25);
		goBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// frame.setVisible(false);
				frame.remove(signUpPanel);
				logInScreen();

			}

		});

		signUpPanel.add(goBackToLogin);
		missingInfo = new JLabel("");
		missingInfo.setBounds(90, 135, 250, 25);
		signUpPanel.add(missingInfo);
		missingInfo.setForeground(new Color(255, 64, 80));
		signUpPanel.add(signUpButton);
		frame.add(signUpPanel);
	}

	public void addSavingsAccountScreen() {

		frame.revalidate();

		addSavingsPanel = new JPanel();
		frame.add(addSavingsPanel);

		frame.setSize(400, 610);
		addSavingsPanel.setLayout(null);
		// Add Savings By the number of years invested
		addSavingsTitle = new JLabel("Add Savings by Number of Years Invested: ");

		addSavingsTitle.setBounds(10, 10, 400, 35);

		addSavingsTitle.setFont(new Font("Georgia", Font.BOLD, 15));

		addSavingsPanel.add(addSavingsTitle);

		// Add Label for Amount Field
		amountSavingsByYearsLabel = new JLabel("Amount: ");

		amountSavingsByYearsLabel.setBounds(10, 50, 80, 25);

		addSavingsPanel.add(amountSavingsByYearsLabel);

		// Add Amount field
		amountSavingsByYearsField = new JTextField(20);

		amountSavingsByYearsField.setBounds(80, 50, 120, 25);

		addSavingsPanel.add(amountSavingsByYearsField);

		// Add Label for Years Field
		yearsAmountSavedLabel = new JLabel("Years: ");

		yearsAmountSavedLabel.setBounds(10, 90, 80, 25);

		addSavingsPanel.add(yearsAmountSavedLabel);

		// Add Years field
		yearsAmountSavedField = new JTextField(20);

		yearsAmountSavedField.setBounds(80, 90, 120, 25);

		addSavingsPanel.add(yearsAmountSavedField);

		// Add Label for APY Field
		APYByYearsLabel = new JLabel("APY: ");

		APYByYearsLabel.setBounds(10, 130, 80, 25);

		addSavingsPanel.add(APYByYearsLabel);

		// Add APY field
		APYByYearsField = new JTextField(20);

		APYByYearsField.setBounds(80, 130, 120, 25);

		addSavingsPanel.add(APYByYearsField);

		// Add Label for Bank Field
		bankYearsLabel = new JLabel("Bank: ");

		bankYearsLabel.setBounds(10, 170, 80, 25);

		addSavingsPanel.add(bankYearsLabel);

		// Add Bank field
		bankYearsField = new JTextField(20);

		bankYearsField.setBounds(80, 170, 120, 25);

		addSavingsPanel.add(bankYearsField);

		// Add button to handle above field information
		addSavingsByYearsButton = new JButton("Add Savings Information");

		addSavingsByYearsButton.setBounds(10, 210, 200, 25);

		addSavingsByYearsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amount = amountSavingsByYearsField.getText();
				String years = yearsAmountSavedField.getText();
				String apy = APYByYearsField.getText();
				String bankName = bankYearsField.getText();
				double money = 0;
				double totalYears = 0;
				double interestRate = -1000000000000000000000000000000000000000000000000.0;
				boolean userExists = false;

				if (amount.equals("")) {
					amountSavingsByYearsField.setBackground(new Color(255, 0, 0, 100));
				} else {

					amountSavingsByYearsField.setBackground(Color.white);
				}
				if (years.equals("")) {
					yearsAmountSavedField.setBackground(new Color(255, 0, 0, 100));
				} else {
					yearsAmountSavedField.setBackground(Color.white);
				}

				if (apy.equals("")) {
					APYByYearsField.setBackground(new Color(255, 0, 0, 100));
				} else {
					APYByYearsField.setBackground(Color.white);
				}

				if (bankName.equals("")) {
					bankYearsField.setBackground(new Color(255, 0, 0, 100));
				} else {
					bankYearsField.setBackground(Color.white);
				}

				if (amount.equals("") || years.equals("") || apy.equals("") || bankName.equals("")) {
					displaySuccessOfSavingsByYear.setForeground(new Color(255, 64, 80));
					displaySuccessOfSavingsByYear.setText("Please enter missing information");
				} else {
					try {
						money = Double.parseDouble(amount);
					} catch (Exception error) {
					}
					try {
						totalYears = Double.parseDouble(years);
					} catch (Exception error) {
					}
					try {
						interestRate = Double.parseDouble(apy);
					} catch (Exception error) {
					}
					if (money == 0 && totalYears == 0) {
						displaySuccessOfSavingsByYear.setForeground(new Color(255, 64, 80));
						displaySuccessOfSavingsByYear.setText("Please enter a nonzero number for the Amount and Years");
						amountSavingsByYearsField.setBackground(new Color(255, 0, 0, 100));
						yearsAmountSavedField.setBackground(new Color(255, 0, 0, 100));
					} else if (money == 0) {
						displaySuccessOfSavingsByYear.setForeground(new Color(255, 64, 80));
						displaySuccessOfSavingsByYear.setText("Please enter a nonzero number for the Amount field");
						amountSavingsByYearsField.setBackground(new Color(255, 0, 0, 100));
					} else if (totalYears == 0) {
						displaySuccessOfSavingsByYear.setForeground(new Color(255, 64, 80));
						displaySuccessOfSavingsByYear.setText("Please enter a nonzero number for the Years field");
						yearsAmountSavedField.setBackground(new Color(255, 0, 0, 100));
					}

					else if (interestRate == -1000000000000000000000000000000000000000000000000.0) {
						displaySuccessOfSavingsByYear.setForeground(new Color(255, 64, 80));
						displaySuccessOfSavingsByYear.setText("Please enter a number for the APY field");
						APYByYearsField.setBackground(new Color(255, 0, 0, 100));
					}

					else {
						amountSavingsByYearsField.setText("");
						yearsAmountSavedField.setText("");
						APYByYearsField.setText("");
						bankYearsField.setText("");
						displaySuccessOfSavingsByYear.setText("");

						SavingsAccount account = new SavingsAccount(bankName, money);
						account.setMoneyInvested(money);
						account.setYearsMoneyPutIn(totalYears);
						account.setInterestRate(interestRate);
						System.out.println("Money Invested: " + money);
						System.out.println("Total years invested: " + totalYears);
						System.out.println("Interest rate: " + interestRate);
						System.out.println("Bank name: " + bankName);
						// System.out.println("Savings Profit:
						// "+String.format("%.2f",account.getSavingsProfit()));
						System.out.println("Savings Profit: " + account.getSavingsProfit());

						List<String> lines = Collections.emptyList();
						try {
							File file = new File("src/JavaFinalProject/userPortfolio.txt");
							Scanner sc = new Scanner(file);
							lines = Files.readAllLines(Paths.get("src/JavaFinalProject/userPortfolio.txt"));
							int count = 1;

							for (String line : lines) {
								String[] arrs = line.split(" ", 0);
								if (arrs[0].toLowerCase().equals(userName.toLowerCase())) {
									userExists = true;
									String temp = " " + "Savings:" + "moneyInvested:" + account.getMoneyInvested()
											+ "-yearsInvested:" + account.getYearsPutIn() + "-interestRate:"
											+ interestRate + "-bankName:" + bankName.replaceAll("\\s+", "addSpaceHere")
											+ "-savingProfit:" + String.format("%.2f", account.getSavingsProfit());
									;
									Path path = Paths.get("src/JavaFinalProject/userPortfolio.txt");
									// List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
									lines.set(count - 1, line + temp);
									Files.write(path, lines, StandardCharsets.UTF_8);
									frame.remove(addSavingsPanel);
									mainMenuScreen();
									break;
								}
								count++;
							}
							if (userExists == false) {
								FileWriter writer = new FileWriter("src/JavaFinalProject/userPortfolio.txt", true);
								String temp = userName + " " + "Savings:" + "moneyInvested:"
										+ account.getMoneyInvested() + "-yearsInvested:" + account.getYearsPutIn()
										+ "-interestRate:" + interestRate + "-bankName:"
										+ bankName.replaceAll("\\s+", "addSpaceHere") + "-savingProfit:"
										+ String.format("%.2f", account.getSavingsProfit());
								Path path = Paths.get("src/JavaFinalProject/userPortfolio.txt");
								// List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
								lines.add(lines.size(), temp);
								Files.write(path, lines, StandardCharsets.UTF_8);
								frame.remove(addSavingsPanel);
								mainMenuScreen();

							}
						} catch (Exception except) {

							System.out.println("\nThere was an error retrieving the files\n" + except);
						}

					}

				}
			}

		});

		addSavingsPanel.add(addSavingsByYearsButton);

		// Display user submit information
		displaySuccessOfSavingsByYear = new JLabel("");

		displaySuccessOfSavingsByYear.setBounds(10, 240, 400, 25);

		addSavingsPanel.add(displaySuccessOfSavingsByYear);

		// Add Savings By the Date invested
		addDateSavingsTitle = new JLabel("Add Savings by The Date Invested: ");

		addDateSavingsTitle.setBounds(10, 280, 400, 35);

		addDateSavingsTitle.setFont(new Font("Georgia", Font.BOLD, 15));

		addSavingsPanel.add(addDateSavingsTitle);

		// Add Label for Amount Field
		amountSavingsByDateLabel = new JLabel("Amount: ");

		amountSavingsByDateLabel.setBounds(10, 320, 80, 25);

		addSavingsPanel.add(amountSavingsByDateLabel);

		// Add Amount field
		amountSavingsByDateField = new JTextField(20);

		amountSavingsByDateField.setBounds(80, 320, 120, 25);

		addSavingsPanel.add(amountSavingsByDateField);

		// Add Label for Date Field
		dateAmountSavedLabel = new JLabel("Date: ");

		dateAmountSavedLabel.setBounds(10, 360, 80, 25);

		addSavingsPanel.add(dateAmountSavedLabel);

		// Add Date field
		dateAmountSavedField = new JTextField(20);

		dateAmountSavedField.setBounds(82, 360, 115, 25);

		dateAmountSavedField.setUI(new JTextFieldHintUI("MM-DD-YYYY", new Color(120, 138, 137)));

		addSavingsPanel.add(dateAmountSavedField);

		// Add Label for APY Field
		APYByDateLabel = new JLabel("APY: ");

		APYByDateLabel.setBounds(10, 400, 80, 25);

		addSavingsPanel.add(APYByDateLabel);

		// Add APY field
		APYByDateField = new JTextField(20);

		APYByDateField.setBounds(80, 400, 120, 25);

		addSavingsPanel.add(APYByDateField);

		// Add Label for Bank Field
		bankdDateLabel = new JLabel("Bank: ");

		bankdDateLabel.setBounds(10, 440, 80, 25);

		addSavingsPanel.add(bankdDateLabel);

		// Add Bank field
		bankDateField = new JTextField(20);

		bankDateField.setBounds(80, 440, 120, 25);

		addSavingsPanel.add(bankDateField);

		// Add button to handle above field information
		addSavingsByDateButton = new JButton("Add Savings Information");

		addSavingsByDateButton.setBounds(10, 480, 200, 25);

		addSavingsByDateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amount = amountSavingsByDateField.getText();
				String date = dateAmountSavedField.getText();
				String apy = APYByDateField.getText();
				String bankName = bankDateField.getText();

				double money = 0;
				double totalYears = 0;
				double interestRate = -1000000000000000000000000000000000000000000000000.0;
				boolean userExists = false;

				if (amount.equals("")) {
					amountSavingsByDateField.setBackground(new Color(255, 0, 0, 100));
				} else {

					amountSavingsByDateField.setBackground(Color.white);
				}
				if (date.equals("")) {
					dateAmountSavedField.setBackground(new Color(255, 0, 0, 100));
				} else {
					dateAmountSavedField.setBackground(Color.white);
				}

				if (apy.equals("")) {
					APYByDateField.setBackground(new Color(255, 0, 0, 100));
				} else {
					APYByDateField.setBackground(Color.white);
				}

				if (bankName.equals("")) {
					bankDateField.setBackground(new Color(255, 0, 0, 100));
				} else {
					bankDateField.setBackground(Color.white);
				}

				if (amount.equals("") || date.equals("") || apy.equals("") || bankName.equals("")) {
					displaySuccessOfSavingsByDate.setForeground(new Color(255, 64, 80));
					displaySuccessOfSavingsByDate.setText("Please enter missing information");
				} else {
					try {
						money = Double.parseDouble(amount);
					} catch (Exception error) {
					}

					try {
						interestRate = Double.parseDouble(apy);
					} catch (Exception error) {
					}

					if (money == 0) {
						displaySuccessOfSavingsByDate.setForeground(new Color(255, 64, 80));
						displaySuccessOfSavingsByDate.setText("Please enter a nonzero number for the Amount field");
						amountSavingsByDateField.setBackground(new Color(255, 0, 0, 100));
					}

					else if (interestRate == -1000000000000000000000000000000000000000000000000.0) {
						displaySuccessOfSavingsByDate.setForeground(new Color(255, 64, 80));
						displaySuccessOfSavingsByDate.setText("Please enter a number for the APY field");
						APYByDateField.setBackground(new Color(255, 0, 0, 100));
					}

					else {
						amountSavingsByDateField.setText("");
						dateAmountSavedField.setText("");
						APYByDateField.setText("");
						bankDateField.setText("");
						displaySuccessOfSavingsByDate.setText("");

						SavingsAccount account = new SavingsAccount(bankName, money);
						account.setMoneyInvested(money);
						account.setDateMoneyPutIn(date);

						totalYears = account.getYearsPutIn();

						account.setInterestRate(interestRate);
						System.out.println("Money Invested: " + money);

						System.out.println("Total years invested: " + totalYears);
						System.out.println("Interest rate: " + interestRate);
						System.out.println("Bank name: " + bankName);
						// System.out.println("Savings Profit:
						// "+String.format("%.2f",account.getSavingsProfit()));
						System.out.println("Savings Profit: " + account.getSavingsProfit());

						List<String> lines = Collections.emptyList();
						try {
							File file = new File("src/JavaFinalProject/userPortfolio.txt");
							Scanner sc = new Scanner(file);
							lines = Files.readAllLines(Paths.get("src/JavaFinalProject/userPortfolio.txt"));
							int count = 1;

							for (String line : lines) {
								String[] arrs = line.split(" ", 0);
								if (arrs[0].toLowerCase().equals(userName.toLowerCase())) {
									userExists = true;
									String temp = " " + "Savings:" + "moneyInvested:" + account.getMoneyInvested()
											+ "-yearsInvested:" + account.getYearsPutIn() + "-interestRate:"
											+ interestRate + "-bankName:" + bankName.replaceAll("\\s+", "addSpaceHere")
											+ "-savingProfit:" + String.format("%.2f", account.getSavingsProfit());
									Path path = Paths.get("src/JavaFinalProject/userPortfolio.txt");
									// List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
									lines.set(count - 1, line + temp);
									Files.write(path, lines, StandardCharsets.UTF_8);
									frame.remove(addSavingsPanel);
									mainMenuScreen();
									break;
								}
								count++;
							}
							if (userExists == false) {
								FileWriter writer = new FileWriter("src/JavaFinalProject/userPortfolio.txt", true);
								String temp = userName + " " + "Savings:" + "moneyInvested:"
										+ account.getMoneyInvested() + "-yearsInvested:" + account.getYearsPutIn()
										+ "-interestRate:" + interestRate + "-bankName:"
										+ bankName.replaceAll("\\s+", "addSpaceHere") + "-savingProfit:"
										+ String.format("%.2f", account.getSavingsProfit());
								Path path = Paths.get("src/JavaFinalProject/userPortfolio.txt");

								lines.add(lines.size(), temp);
								Files.write(path, lines, StandardCharsets.UTF_8);
								frame.remove(addSavingsPanel);
								mainMenuScreen();

							}
						} catch (Exception except) {

							System.out.println("\nThere was an error retrieving the files\n" + except);
						}

					}

				}

			}

		});

		addSavingsPanel.add(addSavingsByDateButton);

		// Display user submit information
		displaySuccessOfSavingsByDate = new JLabel("");

		displaySuccessOfSavingsByDate.setBounds(10, 520, 350, 25);

		addSavingsPanel.add(displaySuccessOfSavingsByDate);

		addSavingsReturnToMainButton = new JButton("Return to Main Menu");

		addSavingsReturnToMainButton.setBounds(0, 557, 400, 30);

		addSavingsPanel.add(addSavingsReturnToMainButton);

		addSavingsReturnToMainButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(addSavingsPanel);
				mainMenuScreen();

			}

		});

	}

	public void displaySavingsAccount() {

		displaySavingsAccountPanel = new JPanel();

		frame.setSize(new Dimension(400, 400));

		displaySavingsAccountTitle = new JLabel("Savings Accounts", SwingConstants.CENTER);
		displaySavingsAccountTitle.setFont(new Font("Georgia", Font.BOLD, 25));
		displaySavingsAccountPanel.add(displaySavingsAccountTitle);

		List<String> lines = Collections.emptyList();
		try {
			File file = new File("src/JavaFinalProject/userPortfolio.txt");
			Scanner sc = new Scanner(file);
			lines = Files.readAllLines(Paths.get("src/JavaFinalProject/userPortfolio.txt"));
			int count = 1;
		} catch (Exception e) {

		}

		String text = "";
		for (String line : lines) {
			String[] arrs = line.split(" ", 0);
			if (arrs[0].toLowerCase().equals(userName.toLowerCase())) {
				for (int i = 1; i < arrs.length; i++) {
					String[] arrs2 = arrs[i].split(":");

					if (arrs2[0].equals("Savings")) {

						String[] arr3 = arrs2[5].split("-");
						String bankName = arr3[0].replaceAll("addSpaceHere", " ");

						text += "\n" + "  Bank: " + bankName;

						String arr4[] = arrs2[2].split("-");
						Double moneyInvested = Double.parseDouble(arr4[0]);
						text += "\n" + "  Capital Initially Invested: " + String.format("%.2f", moneyInvested);
						if (arrs2[4].substring(0, 1).equals("-")) {
							StringBuilder stringBuild = new StringBuilder();
							stringBuild.append(arrs2[4]);
							String tempor = stringBuild.reverse().toString();
							String arr5[] = tempor.split("-", 2);

							StringBuilder stringBuild2 = new StringBuilder();
							stringBuild2.append(arr5[1]);
							String tempor2 = stringBuild2.reverse().toString();

							Double interestRate = Double.parseDouble(tempor2);

							text += "\n" + "  APY: " + interestRate;
						} else {
							String arr5[] = arrs2[4].split("-");
							Double interestRate = Double.parseDouble(arr5[0]);

							text += "\n" + "  APY: " + interestRate;
						}

						String arr6[] = arrs2[3].split("-");
						Double yearsInvested = Double.parseDouble(arr6[0]);
						text += "\n" + "  Years Invested: " + String.format("%.2f", yearsInvested);

						Double finalSavings = Double.parseDouble(arrs2[6]);
						text += "\n" + "  Final Amount in Account: " + String.format("%.2f", finalSavings);

						text += "\n" + "  Savings Profit: " + String.format("%.2f", finalSavings - moneyInvested)
								+ "\n\n";
						// }
					}
				}
			}

		}

		displaySavingsText = new JTextArea();
		if (text.equals("")) {
			displaySavingsText.setText("\n\n  You have added no Savings Accounts to your portfolio");
		} else
			displaySavingsText.setText(text);

		displaySavingsPane = new JScrollPane(displaySavingsText);

		displaySavingsText.setBackground(frame.getBackground());
		displaySavingsText.setEditable(false);
		displaySavingsText.setSelectionStart(0);
		displaySavingsText.setSelectionEnd(0);
		displaySavingsPane.setViewportView(displaySavingsText);

		buttonOnButtomOfDisplaySavingsPanel = new JPanel();

		returnToMainSavingsDisplayButton = new JButton("Return to Main Menu");
		buttonOnButtomOfDisplaySavingsPanel.add(returnToMainSavingsDisplayButton);

		frame.add(displaySavingsAccountPanel, BorderLayout.NORTH);
		frame.add(displaySavingsPane, BorderLayout.CENTER);
		frame.add(returnToMainSavingsDisplayButton, BorderLayout.SOUTH);

		returnToMainSavingsDisplayButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(displaySavingsAccountPanel);
				frame.remove(displaySavingsPane);
				frame.remove(returnToMainSavingsDisplayButton);
				mainMenuScreen();
			}

		});

	}

	public void mainMenuScreen() {

		/*
		 * private JPanel mainMenuPanel; private JLabel MainMenuTitle; private JButton
		 * viewStocksMainMenuButton; private JButton addSavingsButtonMainMenu; private
		 * JButton mainMenuGoToViewSavingsButton; private JButton
		 * mainMenuGoToAddStockButton; private JButton
		 * mainMenuGoToViewStockPortfolioButton;
		 * 
		 */

		mainMenuPanel = new JPanel();
		mainMenuPanel.setLayout(null);
		frame.add(mainMenuPanel);
		frame.setSize(400, 300);

		MainMenuTitle = new JLabel("Main Menu", SwingConstants.CENTER);
		MainMenuTitle.setFont(new Font("Georgia", Font.BOLD, 25));
		MainMenuTitle.setBounds(0, 10, 400, 30);
		mainMenuPanel.add(MainMenuTitle);

		viewStocksMainMenuButton = new JButton("View Stock Prices");

		viewStocksMainMenuButton.setBounds(20, 60, 150, 35);
		mainMenuPanel.add(viewStocksMainMenuButton);

		viewStocksMainMenuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenuPanel);
				stockSearcherInterface();

			}

		});

		addSavingsButtonMainMenu = new JButton("Add Savings Account");

		addSavingsButtonMainMenu.setBounds(200, 60, 170, 35);
		mainMenuPanel.add(addSavingsButtonMainMenu);

		addSavingsButtonMainMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenuPanel);
				addSavingsAccountScreen();

			}

		});

		mainMenuSignOutButton = new JButton("Sign Out");

		mainMenuSignOutButton.setBounds(0, 250, 400, 25);
		mainMenuPanel.add(mainMenuSignOutButton);

		mainMenuSignOutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenuPanel);
				logInScreen();

			}

		});

		mainMenuGoToViewSavingsButton = new JButton("View Savings Accounts");

		mainMenuGoToViewSavingsButton.setBounds(200, 110, 170, 35);
		mainMenuPanel.add(mainMenuGoToViewSavingsButton);

		mainMenuGoToViewSavingsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenuPanel);
				displaySavingsAccount();

			}

		});

		mainMenuGoToAddStockButton = new JButton("Add Stock");

		mainMenuGoToAddStockButton.setBounds(20, 110, 150, 35);
		mainMenuPanel.add(mainMenuGoToAddStockButton);

		mainMenuGoToAddStockButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenuPanel);
				addStockScreen();

			}

		});

		mainMenuGoToViewStockPortfolioButton = new JButton("View Stock Portfolio");

		mainMenuGoToViewStockPortfolioButton.setBounds(20, 160, 150, 35);
		mainMenuPanel.add(mainMenuGoToViewStockPortfolioButton);

		mainMenuGoToViewStockPortfolioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenuPanel);
				displayStockPortfolio();

			}

		});

		mainMenuGoToTotalInvestmentsScreenDisplayButton = new JButton("View Portfolio Stats");

		mainMenuGoToTotalInvestmentsScreenDisplayButton.setBounds(200, 160, 170, 35);
		mainMenuPanel.add(mainMenuGoToTotalInvestmentsScreenDisplayButton);

		mainMenuGoToTotalInvestmentsScreenDisplayButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenuPanel);
				diplayTotalPortfolio();
			}

		});

	}

	public void addStockScreen() {

		/*
		 * private JPanel addStockPanel; private JLabel addStockByManualTitle;
		 * 
		 * private JLabel addStockByManualTickerLabel; private JTextField
		 * addStockByManualTickerTextField;
		 * 
		 * private JLabel addStockByManualPriceBoughtLabel; private JTextField
		 * addStockByManualPriceBoughtTextField;
		 * 
		 * private JLabel addStockByManualYearsInvestedLabel; private JTextField
		 * addStockByManualYeatsInvestedTextField;
		 * 
		 * private JLabel addStockByManualNumberOfSharesLabel; private JTextField
		 * addStockByManualNumberOfSharesTextField;
		 * 
		 * private JButton addStockByManualButton; private JLabel
		 * addStockByManualSuccess;
		 * 
		 * private JButton addStockByDateReturnToHomeButton;
		 * 
		 */
		frame.revalidate();

		addStockPanel = new JPanel();
		frame.add(addStockPanel);

		frame.setSize(400, 560);
		addStockPanel.setLayout(null);
		// Add Stock By the price
		addStockByManualTitle = new JLabel("Add Stock By Buy Price: ");

		addStockByManualTitle.setBounds(20, 10, 400, 35);

		addStockByManualTitle.setFont(new Font("Georgia", Font.BOLD, 15));

		addStockPanel.add(addStockByManualTitle);

		// Add Label for Ticker Field
		addStockByManualTickerLabel = new JLabel("Ticker: ");

		addStockByManualTickerLabel.setBounds(10, 50, 130, 25);

		addStockPanel.add(addStockByManualTickerLabel);

		// Add Ticker field
		addStockByManualTickerTextField = new JTextField(20);

		addStockByManualTickerTextField.setBounds(130, 50, 120, 25);

		addStockPanel.add(addStockByManualTickerTextField);

		// Add Label for Price Bought Field
		addStockByManualPriceBoughtLabel = new JLabel("Price Bought: ");

		addStockByManualPriceBoughtLabel.setBounds(10, 90, 130, 25);

		addStockPanel.add(addStockByManualPriceBoughtLabel);

		// Add Price Bought field
		addStockByManualPriceBoughtTextField = new JTextField(20);

		addStockByManualPriceBoughtTextField.setBounds(130, 90, 120, 25);

		addStockPanel.add(addStockByManualPriceBoughtTextField);

		// Add Label for Years Invested Field
		addStockByManualYearsInvestedLabel = new JLabel("Years Invested: ");

		addStockByManualYearsInvestedLabel.setBounds(10, 130, 130, 25);

		addStockPanel.add(addStockByManualYearsInvestedLabel);

		// Add Years Invested field
		addStockByManualYeatsInvestedTextField = new JTextField(20);

		addStockByManualYeatsInvestedTextField.setBounds(130, 130, 120, 25);

		addStockPanel.add(addStockByManualYeatsInvestedTextField);

		// Add Label for number of shares Field
		addStockByManualNumberOfSharesLabel = new JLabel("Number of Shares: ");

		addStockByManualNumberOfSharesLabel.setBounds(10, 170, 130, 25);

		addStockPanel.add(addStockByManualNumberOfSharesLabel);

		// Add number of shares field
		addStockByManualNumberOfSharesTextField = new JTextField(20);

		addStockByManualNumberOfSharesTextField.setBounds(130, 170, 120, 25);

		addStockPanel.add(addStockByManualNumberOfSharesTextField);

		// Add button to handle above field information
		addStockByManualButton = new JButton("Add Stock Information");

		addStockByManualButton.setBounds(10, 210, 200, 25);

		addStockByManualButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ticker = addStockByManualTickerTextField.getText();
				String priceBought = addStockByManualPriceBoughtTextField.getText();
				String yearsInvested = addStockByManualYeatsInvestedTextField.getText();
				String numberOfShares = addStockByManualNumberOfSharesTextField.getText();

				double priceInitial = -1;
				double totalYears = -1;
				double currentPrice = 0;
				try {
					currentPrice = Stock.fetchStockPrice(ticker);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				double shareNum = -1;

				boolean userExists = false;

				if (ticker.equals("")) {
					addStockByManualTickerTextField.setBackground(new Color(255, 0, 0, 100));
				} else {
					addStockByManualTickerTextField.setBackground(Color.white);
				}
				if (priceBought.equals("")) {
					addStockByManualPriceBoughtTextField.setBackground(new Color(255, 0, 0, 100));
				} else {
					addStockByManualPriceBoughtTextField.setBackground(Color.white);
				}

				if (yearsInvested.equals("")) {
					addStockByManualYeatsInvestedTextField.setBackground(new Color(255, 0, 0, 100));
				} else {
					addStockByManualYeatsInvestedTextField.setBackground(Color.white);
				}

				if (numberOfShares.equals("")) {
					addStockByManualNumberOfSharesTextField.setBackground(new Color(255, 0, 0, 100));
				} else {
					addStockByManualNumberOfSharesTextField.setBackground(Color.white);
				}

				if (ticker.equals("") || yearsInvested.equals("") || numberOfShares.equals("")
						|| priceBought.equals("")) {
					addStockByManualSuccess.setForeground(new Color(255, 64, 80));
					addStockByManualSuccess.setText("Please enter missing information");
				} else {
					if (currentPrice == 0) {
						addStockByManualSuccess.setForeground(new Color(255, 64, 80));
						addStockByManualSuccess.setText("That stock doesn't exist");
					} else if (currentPrice == -1) {
						addStockByManualSuccess.setForeground(new Color(255, 64, 80));
						addStockByManualSuccess.setText("That company is not publicly traded");
					} else {
						try {
							priceInitial = Double.parseDouble(priceBought);
						} catch (Exception error) {
						}
						try {
							totalYears = Double.parseDouble(yearsInvested);
						} catch (Exception error) {
						}
						try {
							shareNum = Double.parseDouble(numberOfShares);
						} catch (Exception error) {
						}
						if (priceInitial < 0 && totalYears < 0) {
							addStockByManualSuccess.setForeground(new Color(255, 64, 80));
							addStockByManualSuccess.setText("Please enter a positive number for the price and years");
							addStockByManualPriceBoughtTextField.setBackground(new Color(255, 0, 0, 100));
							addStockByManualYeatsInvestedTextField.setBackground(new Color(255, 0, 0, 100));
						} else if (priceInitial < 0) {
							addStockByManualSuccess.setForeground(new Color(255, 64, 80));
							addStockByManualSuccess.setText("Please enter a positive number for the initial price");
							addStockByManualPriceBoughtTextField.setBackground(new Color(255, 0, 0, 100));
						} else if (totalYears < 0) {
							addStockByManualSuccess.setForeground(new Color(255, 64, 80));
							addStockByManualSuccess.setText("Please enter a positive number for the Years field");
							addStockByManualYeatsInvestedTextField.setBackground(new Color(255, 0, 0, 100));
						}

						else if (shareNum < 0) {
							addStockByManualSuccess.setForeground(new Color(255, 64, 80));
							addStockByManualSuccess.setText("Please enter a positive number for the shares field");
							addStockByManualNumberOfSharesTextField.setBackground(new Color(255, 0, 0, 100));
						}

						else {
							addStockByManualTickerTextField.setText("");
							addStockByManualPriceBoughtTextField.setText("");
							addStockByManualYeatsInvestedTextField.setText("");
							addStockByManualNumberOfSharesTextField.setText("");
							addStockByManualSuccess.setText("");

							Stock stonk = new Stock(ticker);
							stonk.setBuyPrice(priceInitial);

							stonk.setYearsHeld(totalYears);
							stonk.setNumberOfShares(shareNum);
							System.out.println("Ticker: " + stonk.getName());
							System.out.println("Buy Price: " + priceInitial);
							System.out.println("Years Held: " + stonk.getYearsHeld());
							System.out.println("Number of shares: " + stonk.getNumberOfShares());

							// System.out.println("Savings Profit:
							// "+String.format("%.2f",account.getSavingsProfit()));
							System.out.println("Total Money: " + stonk.getNumberOfShares() * currentPrice);

							List<String> lines = Collections.emptyList();
							try {
								File file = new File("src/JavaFinalProject/userPortfolio.txt");
								Scanner sc = new Scanner(file);
								lines = Files.readAllLines(Paths.get("src/JavaFinalProject/userPortfolio.txt"));
								int count = 1;

								for (String line : lines) {
									String[] arrs = line.split(" ", 0);
									if (arrs[0].toLowerCase().equals(userName.toLowerCase())) {
										userExists = true;
										String temp = " " + "Stock:" + "ticker:" + stonk.getName() + "-buyPrice:"
												+ stonk.getBuyPrice() + "-yearsHeld:" + stonk.getYearsHeld()
												+ "-numShares:" + stonk.getNumberOfShares() + "-currentPrice:"
												+ currentPrice;
										;
										Path path = Paths.get("src/JavaFinalProject/userPortfolio.txt");
										// List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
										lines.set(count - 1, line + temp);
										Files.write(path, lines, StandardCharsets.UTF_8);
										frame.remove(addStockPanel);
										mainMenuScreen();
										break;
									}
									count++;
								}
								if (userExists == false) {
									FileWriter writer = new FileWriter("src/JavaFinalProject/userPortfolio.txt", true);
									String temp = userName + " " + "Stock:" + "ticker:" + stonk.getName() + "-buyPrice:"
											+ stonk.getBuyPrice() + "-yearsHeld:" + stonk.getYearsHeld() + "-numShares:"
											+ stonk.getNumberOfShares() + "-currentPrice:" + currentPrice;
									Path path = Paths.get("src/JavaFinalProject/userPortfolio.txt");
									// List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
									lines.add(lines.size(), temp);
									Files.write(path, lines, StandardCharsets.UTF_8);
									frame.remove(addStockPanel);
									mainMenuScreen();

								}
							} catch (Exception except) {

								System.out.println("\nThere was an error retrieving the files\n" + except);
							}

						}

					}
				}
			}

		});

		addStockPanel.add(addStockByManualButton);

		// Display user submit information
		addStockByManualSuccess = new JLabel("");

		addStockByManualSuccess.setBounds(10, 240, 400, 25);

		addStockPanel.add(addStockByManualSuccess);

		/*
		 * private JLabel addStockByDateTitle;
		 * 
		 * private JLabel addStockByDateTickerLabel; private JTextField
		 * addStockByDateTickerTextField;
		 * 
		 * private JLabel addStockByDateDateLabel; private JButton
		 * addStockByDateDateTextField;
		 * 
		 * private JLabel addStockByDateNumberOfSharesLabel; private JTextField
		 * addStockByDateNumberOfSharesTextField;
		 * 
		 * private JButton addStockByDateButton; private JLabel addStockByDateSuccess;
		 */

		// Add Stock By the Date
		addStockByDateTitle = new JLabel("Add Stock By Date Bought: ");

		addStockByDateTitle.setBounds(20, 270, 400, 35);

		addStockByDateTitle.setFont(new Font("Georgia", Font.BOLD, 15));

		addStockPanel.add(addStockByDateTitle);

		// Add Label for Ticker Field
		addStockByDateTickerLabel = new JLabel("Ticker: ");

		addStockByDateTickerLabel.setBounds(10, 310, 130, 25);

		addStockPanel.add(addStockByDateTickerLabel);

		// Add Ticker field
		addStockByDateTickerTextField = new JTextField(20);

		addStockByDateTickerTextField.setBounds(130, 310, 120, 25);

		addStockPanel.add(addStockByDateTickerTextField);

		// Add Label for Date Field
		addStockByDateDateLabel = new JLabel("Date Bought: ");

		addStockByDateDateLabel.setBounds(10, 350, 130, 25);

		addStockPanel.add(addStockByDateDateLabel);

		// Add Date field
		addStockByDateDateTextField = new JTextField(20);

		addStockByDateDateTextField.setBounds(133, 350, 115, 25);

		addStockByDateDateTextField.setUI(new JTextFieldHintUI("MM-DD-YYYY", new Color(120, 138, 137)));

		addStockPanel.add(addStockByDateDateTextField);

		// Add Label for Number of shares Field
		addStockByDateNumberOfSharesLabel = new JLabel("Number of Shares: ");

		addStockByDateNumberOfSharesLabel.setBounds(10, 390, 130, 25);

		addStockPanel.add(addStockByDateNumberOfSharesLabel);

		// Add number of shares field
		addStockByDateNumberOfSharesTextField = new JTextField(20);

		addStockByDateNumberOfSharesTextField.setBounds(130, 390, 120, 25);

		addStockPanel.add(addStockByDateNumberOfSharesTextField);

		// Add button to handle above field information
		addStockByDateButton = new JButton("Add Stock Information");

		addStockByDateButton.setBounds(10, 430, 200, 25);

		addStockByDateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ticker = addStockByDateTickerTextField.getText();
				String date = addStockByDateDateTextField.getText();
				String numberOfShares = addStockByDateNumberOfSharesTextField.getText();

				double priceInitial = 0;
				double currentPrice = 0;

				try {
					currentPrice = Stock.fetchStockPrice(ticker);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				try {
					priceInitial = Stock.getPriceAtDate(date, ticker);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				double shareNum = -1;

				boolean userExists = false;
				if (ticker.equals("")) {
					addStockByDateTickerTextField.setBackground(new Color(255, 0, 0, 100));
				} else {
					addStockByDateTickerTextField.setBackground(Color.white);
				}
				if (date.equals("")) {
					addStockByDateDateTextField.setBackground(new Color(227, 130, 123));
				} else {
					addStockByDateDateTextField.setBackground(Color.white);
				}

				if (numberOfShares.equals("")) {
					addStockByDateNumberOfSharesTextField.setBackground(new Color(255, 0, 0, 100));
				} else {
					addStockByDateNumberOfSharesTextField.setBackground(Color.white);
				}

				if (ticker.equals("") || numberOfShares.equals("") || date.equals("")) {
					addStockByDateSuccess.setForeground(new Color(255, 64, 80));
					addStockByDateSuccess.setText("Please enter missing information");
				} else {
					if (currentPrice == 0) {
						addStockByDateSuccess.setForeground(new Color(255, 64, 80));
						addStockByDateSuccess.setText("That stock doesn't exist");
						addStockByDateTickerTextField.setBackground(new Color(255, 0, 0, 100));
					} else if (currentPrice == -1) {
						addStockByDateSuccess.setForeground(new Color(255, 64, 80));
						addStockByDateSuccess.setText("That company is not publicly traded");
						addStockByDateTickerTextField.setBackground(new Color(255, 0, 0, 100));
					} else {
						if (priceInitial <= 0) {
							addStockByDateSuccess.setForeground(new Color(255, 64, 80));
							addStockByDateSuccess.setText("Either company wasn't publicly traded or markets closed");
							addStockByDateDateTextField.setBackground(new Color(227, 130, 123));

						} else {

							try {
								shareNum = Double.parseDouble(numberOfShares);
							} catch (Exception error) {
							}

							if (shareNum < 0) {
								addStockByDateSuccess.setForeground(new Color(255, 64, 80));
								addStockByDateSuccess.setText("Please enter a positive number for the shares field");
								addStockByDateNumberOfSharesTextField.setBackground(new Color(255, 0, 0, 100));
							}

							else {
								addStockByDateTickerTextField.setText("");
								addStockByDateDateTextField.setText("");
								addStockByDateNumberOfSharesTextField.setText("");
								addStockByDateSuccess.setText("");

								addStockByDateTickerTextField.setBackground(Color.white);
								addStockByDateDateTextField.setBackground(Color.white);

								Stock stonk = new Stock(ticker);

								stonk.setBuyPrice(priceInitial);

								Integer tempHolder = Stock.dateToSeconds(date + "T00:00:00.000-0000");
								Instant instant = Instant.now();
								Integer currentTime = (int) instant.getEpochSecond();
								double totalYears = (double) ((double) currentTime - tempHolder) / (31540000.0);

								stonk.setYearsHeld(totalYears);

								stonk.setNumberOfShares(shareNum);

								System.out.println("Ticker: " + stonk.getName());
								System.out.println("Buy Price: " + priceInitial);
								System.out.println("Years Held: " + stonk.getYearsHeld());
								System.out.println("Number of shares: " + stonk.getNumberOfShares());

								// System.out.println("Savings Profit:
								// "+String.format("%.2f",account.getSavingsProfit()));
								System.out.println("Total Money: " + stonk.getNumberOfShares() * currentPrice);

								List<String> lines = Collections.emptyList();
								try {
									File file = new File("src/JavaFinalProject/userPortfolio.txt");
									Scanner sc = new Scanner(file);
									lines = Files.readAllLines(Paths.get("src/JavaFinalProject/userPortfolio.txt"));
									int count = 1;

									for (String line : lines) {
										String[] arrs = line.split(" ", 0);
										if (arrs[0].toLowerCase().equals(userName.toLowerCase())) {
											userExists = true;
											String temp = " " + "Stock:" + "ticker:" + stonk.getName() + "-buyPrice:"
													+ stonk.getBuyPrice() + "-yearsHeld:" + stonk.getYearsHeld()
													+ "-numShares:" + stonk.getNumberOfShares() + "-currentPrice:"
													+ currentPrice;
											;
											Path path = Paths.get("src/JavaFinalProject/userPortfolio.txt");
											// List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
											lines.set(count - 1, line + temp);
											Files.write(path, lines, StandardCharsets.UTF_8);
											frame.remove(addStockPanel);
											mainMenuScreen();
											break;
										}
										count++;
									}
									if (userExists == false) {
										FileWriter writer = new FileWriter("src/JavaFinalProject/userPortfolio.txt",
												true);
										String temp = userName + " " + "Stock:" + "ticker:" + stonk.getName()
												+ "-buyPrice:" + stonk.getBuyPrice() + "-yearsHeld:"
												+ stonk.getYearsHeld() + "-numShares:" + stonk.getNumberOfShares()
												+ "-currentPrice:" + currentPrice;
										Path path = Paths.get("src/JavaFinalProject/userPortfolio.txt");
										// List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
										lines.add(lines.size(), temp);
										Files.write(path, lines, StandardCharsets.UTF_8);
										frame.remove(addStockPanel);
										mainMenuScreen();

									}
								} catch (Exception except) {

									System.out.println("\nThere was an error retrieving the files\n" + except);
								}

							}
						}

					}
				}
			}

		});

		addStockPanel.add(addStockByDateButton);

		// Display user submit information
		addStockByDateSuccess = new JLabel("");

		addStockByDateSuccess.setBounds(10, 470, 400, 25);

		addStockPanel.add(addStockByDateSuccess);

		// Return to home button
		addStockByDateReturnToHomeButton = new JButton("Return to Main Menu");

		addStockByDateReturnToHomeButton.setBounds(0, 510, 400, 25);

		addStockPanel.add(addStockByDateReturnToHomeButton);

		addStockByDateReturnToHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(addStockPanel);
				mainMenuScreen();

			}
		});

	}

	public void displayStockPortfolio() {

		/*
		 * private JPanel displayStocksPanel; private JLabel displayStocksTitle;
		 */

		displayStocksPanel = new JPanel();

		frame.setSize(new Dimension(400, 301));

		displayStocksTitle = new JLabel("Stock Portfolio", SwingConstants.CENTER);
		displayStocksTitle.setFont(new Font("Georgia", Font.BOLD, 25));
		displayStocksPanel.add(displayStocksTitle);

		List<String> lines = Collections.emptyList();
		try {
			File file = new File("src/JavaFinalProject/userPortfolio.txt");
			Scanner sc = new Scanner(file);
			lines = Files.readAllLines(Paths.get("src/JavaFinalProject/userPortfolio.txt"));
			int count = 1;
		} catch (Exception e) {

		}

		String text = "";
		for (String line : lines) {
			String[] arrs = line.split(" ", 0);
			if (arrs[0].toLowerCase().equals(userName.toLowerCase())) {
				for (int i = 1; i < arrs.length; i++) {
					String[] arrs2 = arrs[i].split(":");

					if (arrs2[0].equals("Stock")) {

						String[] ticker = arrs2[2].split("-");

						text += "\n" + "  Stock: " + ticker[0];

						String buyPrice[] = arrs2[3].split("-");
						Double initialPrice = Double.parseDouble(buyPrice[0]);
						text += "\n" + "  Buy Price: " + initialPrice;

						String arr6[] = arrs2[4].split("-");
						Double yearsInvested = Double.parseDouble(arr6[0]);
						text += "\n" + "  Years Held: " + String.format("%.2f", yearsInvested);

						double currentValue = 0;

						try {
							currentValue = Stock.fetchStockPrice(ticker[0]);
						} catch (Exception except) {
						}

						String arr7[] = arrs2[5].split("-");
						Double shareNum = Double.parseDouble(arr7[0]);

						text += "\n" + "  Number of Shares: " + shareNum;

						text += "\n" + "  Current Price: " + currentValue;
						if (currentValue >= initialPrice)
							text += "\n" + "  Unrealized Profit: "
									+ String.format("%.2f", (currentValue - initialPrice) * shareNum);
						else
							text += "\n" + "  Unrealized Loss: "
									+ String.format("%.2f", (initialPrice - currentValue) * shareNum);

						text += "\n" + "  Total Return: "
								+ String.format("%.2f", (currentValue - initialPrice) / initialPrice * 100) + "%";

						double numberOfDays = yearsInvested * 365;
						text += "\n" + "  Annualized Return: "
								+ String.format("%.2f",
										(Math.pow(currentValue / initialPrice, 365 / numberOfDays) - 1) * 100)
								+ "%\n\n";

					}
				}
			}

		}

		/*
		 * private JTextArea displayStockText; private JScrollPane displayStockPane;
		 * 
		 * private JPanel buttonOnButtomOfDisplayStockPanel;
		 * 
		 * private JButton returnToMainStockDisplayButton;
		 * 
		 */
		displayStockText = new JTextArea();
		if (text.equals("")) {
			displayStockText.setText("\n\n  You have added no Shares in your portfolio");
		} else
			displayStockText.setText(text);

		displayStockPane = new JScrollPane(displayStockText);

		displayStockText.setBackground(frame.getBackground());
		displayStockText.setEditable(false);
		displayStockText.setSelectionStart(0);
		displayStockText.setSelectionEnd(0);
		displayStockPane.setViewportView(displayStockText);

		buttonOnButtomOfDisplayStockPanel = new JPanel();

		returnToMainStockDisplayButton = new JButton("Return to Main Menu");
		buttonOnButtomOfDisplayStockPanel.add(returnToMainStockDisplayButton);

		frame.add(displayStocksPanel, BorderLayout.NORTH);
		frame.add(displayStockPane, BorderLayout.CENTER);
		frame.add(returnToMainStockDisplayButton, BorderLayout.SOUTH);

		returnToMainStockDisplayButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(displayStocksPanel);
				frame.remove(displayStockPane);
				frame.remove(returnToMainStockDisplayButton);
				mainMenuScreen();
			}

		});

	}

	public void stockSearcherInterface() {

		frame.revalidate();

		stockSearcherPanel = new JPanel();
		frame.add(stockSearcherPanel);
		// frame.setVisible(true);
		frame.setSize(400, 420);

		stockSearcherPanel.setLayout(null);

		currentStockPriceTitle = new JLabel("Enter a ticker to get its current stock price: ");
		currentStockPriceTitle.setBounds(10, 20, 280, 25);
		stockSearcherPanel.add(currentStockPriceTitle);

		tickerField = new JTextField(20);
		tickerField.setBounds(300, 20, 70, 25);
		stockSearcherPanel.add(tickerField);

		getCurrentStockButton = new JButton("Get Price");
		getCurrentStockButton.setBounds(10, 60, 100, 25);

		getCurrentStockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stockTicker = tickerField.getText();
				double price = 0;
				try {
					price = Stock.fetchStockPrice(stockTicker);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if (price == 0) {
					displayCurrentStockPrice.setForeground(new Color(255, 64, 80));
					displayCurrentStockPrice.setText("That stock doesn't exist");
				} else if (price == -1) {
					displayCurrentStockPrice.setForeground(new Color(255, 64, 80));
					displayCurrentStockPrice.setText("That company is not publicly traded");
				} else {
					displayCurrentStockPrice.setForeground(new Color(150, 40, 209));
					displayCurrentStockPrice.setText(stockTicker + " price is: " + price);
				}
			}

		});
		stockSearcherPanel.add(getCurrentStockButton);

		displayCurrentStockPrice = new JLabel("");
		displayCurrentStockPrice.setBounds(10, 100, 250, 25);
		displayCurrentStockPrice.setForeground(new Color(150, 40, 209));
		stockSearcherPanel.add(displayCurrentStockPrice);

		getStockByDateTitle = new JLabel("Get the stock price at a certain date: ");
		getStockByDateTitle.setBounds(10, 140, 350, 25);
		stockSearcherPanel.add(getStockByDateTitle);

		tickerLabelDate = new JLabel("Ticker: ");
		tickerLabelDate.setBounds(10, 180, 80, 25);
		stockSearcherPanel.add(tickerLabelDate);

		tickerFieldWithDate = new JTextField(20);
		tickerFieldWithDate.setBounds(80, 180, 120, 25);
		stockSearcherPanel.add(tickerFieldWithDate);

		dateLabel = new JLabel("Date: ");
		dateLabel.setBounds(10, 220, 80, 25);
		stockSearcherPanel.add(dateLabel);

		fetchStockDateField = new JTextField(20);
		fetchStockDateField.setBounds(82, 220, 115, 25);
		stockSearcherPanel.add(fetchStockDateField);

		fetchStockDateField.setUI(new JTextFieldHintUI("MM-DD-YYYY", new Color(120, 138, 137)));

		getStockPriceByDateButton = new JButton("Get Stock Price");

		getStockPriceByDateButton.setBounds(10, 260, 135, 25);
		getStockPriceByDateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stockTicker = tickerFieldWithDate.getText();
				String date = fetchStockDateField.getText();
				double price = 0;
				try {
					price = Stock.getPriceAtDate(date, stockTicker);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				if (stockTicker.equals("")) {
					displayStockPriceByDate.setForeground(new Color(255, 64, 80));
					displayStockPriceByDate.setText("Enter missing ticker");
				} else if (date.equals("")) {
					displayStockPriceByDate.setForeground(new Color(255, 64, 80));
					displayStockPriceByDate.setText("Enter missing date");
				} else if (price == -1) {
					displayStockPriceByDate.setForeground(new Color(255, 64, 80));
					displayStockPriceByDate.setText("That stock doesn't exist");
				} else if (price == -2) {
					displayStockPriceByDate.setForeground(new Color(255, 64, 80));
					displayStockPriceByDate.setText("Either markets were closed or stock wasn't publicly traded");
					displayStockPriceByDate2.setText("");
				} else {
					displayStockPriceByDate.setForeground(new Color(150, 40, 209));
					displayStockPriceByDate
							.setText("On " + date + ", " + stockTicker + " price at close was: " + price);
					displayStockPriceByDate2.setForeground(new Color(150, 40, 209));
					try {
						displayStockPriceByDate2.setText(
								"The adjusted close price was: " + Stock.getAdjustedPriceAtDate(date, stockTicker));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
		stockSearcherPanel.add(getStockPriceByDateButton);

		displayStockPriceByDate = new JLabel("");
		displayStockPriceByDate.setBounds(10, 300, 400, 25);
		stockSearcherPanel.add(displayStockPriceByDate);

		displayStockPriceByDate2 = new JLabel("");
		displayStockPriceByDate2.setBounds(10, 320, 400, 25);
		stockSearcherPanel.add(displayStockPriceByDate2);

		stockSearcherInterfaceReturnToMainButton = new JButton("Return to Main Menu");
		stockSearcherInterfaceReturnToMainButton.setBounds(0, 370, 400, 25);
		stockSearcherPanel.add(stockSearcherInterfaceReturnToMainButton);

		stockSearcherInterfaceReturnToMainButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(stockSearcherPanel);
				mainMenuScreen();

			}

		});
	}

	public void diplayTotalPortfolio() {

		/*
		 * private JPanel displayTotalPortfolioPanel; private JLabel
		 * displayTotalPortfolioTitle; private JTextArea displayTotalPortfolioTextArea;
		 * private JScrollPane totalPortolioScrollPane;
		 * 
		 * private JPanel buttonOnTotalPortfolioDisplay; private JButton
		 * returnToMainFromTotalPortfolioButton;
		 */
		displayTotalPortfolioPanel = new JPanel();

		frame.setSize(new Dimension(400, 301));

		displayTotalPortfolioTitle = new JLabel("Investment Portfolio General Information", SwingConstants.CENTER);
		displayTotalPortfolioTitle.setFont(new Font("Georgia", Font.BOLD, 17));
		displayTotalPortfolioPanel.add(displayTotalPortfolioTitle);

		List<String> lines = Collections.emptyList();
		try {
			File file = new File("src/JavaFinalProject/userPortfolio.txt");
			Scanner sc = new Scanner(file);
			lines = Files.readAllLines(Paths.get("src/JavaFinalProject/userPortfolio.txt"));
			int count = 1;
		} catch (Exception e) {

		}

		String text = "";
		for (String line : lines) {
			String[] arrs = line.split(" ", 0);

			double totalInitialInvestment = 0;

			double totalFinalInvestment = 0;

			if (arrs[0].toLowerCase().equals(userName.toLowerCase())) {
				for (int i = 1; i < arrs.length; i++) {
					String[] arrs2 = arrs[i].split(":");

					if (arrs2[0].equals("Stock")) {

						String[] ticker = arrs2[2].split("-");

						String buyPrice[] = arrs2[3].split("-");
						Double initialPrice = Double.parseDouble(buyPrice[0]);

						String arr6[] = arrs2[4].split("-");
						Double yearsInvested = Double.parseDouble(arr6[0]);

						double currentValue = 0;

						try {
							currentValue = Stock.fetchStockPrice(ticker[0]);
						} catch (Exception except) {
						}

						String arr7[] = arrs2[5].split("-");
						Double shareNum = Double.parseDouble(arr7[0]);

						totalInitialInvestment += initialPrice * shareNum;

						totalFinalInvestment += currentValue * shareNum;

					}

					else if (arrs2[0].equals("Savings")) {

						String[] arr3 = arrs2[5].split("-");

						String arr4[] = arrs2[2].split("-");
						Double moneyInvested = Double.parseDouble(arr4[0]);
						totalInitialInvestment+=moneyInvested;
						
						Double finalSavings = Double.parseDouble(arrs2[6]);
						totalFinalInvestment+=finalSavings;
					}
					
				}
				text+="\n Current Portfolio Value: "+String.format("%.2f",totalFinalInvestment);
				text+="\n Total Return on Investment: " + String.format("%.2f",(totalFinalInvestment/totalInitialInvestment-1)*100)+"%";
			
			}

		}

		/*
		 * private JTextArea displayTotalPortfolioTextArea; private JScrollPane
		 * totalPortolioScrollPane;
		 * 
		 * private JPanel buttonOnTotalPortfolioDisplay; private JButton
		 * returnToMainFromTotalPortfolioButton;
		 */

		displayTotalPortfolioTextArea = new JTextArea();
		if (text.equals("")) {
			displayTotalPortfolioTextArea.setText("\n\n  You have added no investments to your portfolio");
		} else
			displayTotalPortfolioTextArea.setText(text);

		totalPortolioScrollPane = new JScrollPane(displayStockText);

		displayTotalPortfolioTextArea.setBackground(frame.getBackground());
		displayTotalPortfolioTextArea.setEditable(false);
		displayTotalPortfolioTextArea.setSelectionStart(0);
		displayTotalPortfolioTextArea.setSelectionEnd(0);
		totalPortolioScrollPane.setViewportView(displayTotalPortfolioTextArea);

		buttonOnTotalPortfolioDisplay = new JPanel();

		returnToMainFromTotalPortfolioButton = new JButton("Return to Main Menu");
		buttonOnTotalPortfolioDisplay.add(returnToMainFromTotalPortfolioButton);

		frame.add(displayTotalPortfolioPanel, BorderLayout.NORTH);
		frame.add(totalPortolioScrollPane, BorderLayout.CENTER);
		frame.add(returnToMainFromTotalPortfolioButton, BorderLayout.SOUTH);

		returnToMainFromTotalPortfolioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(displayTotalPortfolioPanel);
				frame.remove(totalPortolioScrollPane);
				frame.remove(returnToMainFromTotalPortfolioButton);
				mainMenuScreen();
			}

		});

	}

	public static void main(String[] args) {
		new UserInterface();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
