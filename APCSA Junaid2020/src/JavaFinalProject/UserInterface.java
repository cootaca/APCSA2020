package JavaFinalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

import org.w3c.dom.Text;

public class UserInterface implements ActionListener {

	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton logInButton;

	private JLabel success;
	private JFrame frame;
	private JPanel panelDem;
	private JPanel panelDemo;
	private JLabel demoLabel;
	private JPanel introPanel;
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
	public UserInterface() {
		frame = new JFrame("Finance App");

		
	//	 firstScreen();
		introScreen();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void introScreen() {
		frame.setSize(400, 251);
		introductionScreenPanel = new JPanel();
		introductionScreenPanel.setLayout(null);
		frame.add(introductionScreenPanel);
		
		introductionScreenTitle = new JLabel("Welcome to the Finance App");
		introductionScreenTitle.setFont(new Font("Georgia",Font.BOLD,25));
		introductionScreenTitle.setBounds(10,20,400,30);
		introductionScreenPanel.add(introductionScreenTitle);
		
		
		String text = "This app will allow you to access information about current stocks. It will also allow you to store "
				+ "and access investment information.";
		String formatted = text.replace("\n", "<br>");
		formatted = "<html><font size='4'>" + formatted + "</font></html>";
		
		introductionScreenText = new JLabel(formatted);
		introductionScreenText.setBounds(10,60,390,100);
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


	/*public void firstScreen() {
		//frame.revalidate();
		frame.setSize(400, 199);
		introPanel = new JPanel();
		introPanel.setLayout(null);

		loginButton = new JButton("Log in");
		loginButton.setBounds(25, 15, 150, 25);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(introPanel);
				logInScreen();

			}
		});

		signUpButton = new JButton("Sign Up Here");
		signUpButton.setBounds(25, 50, 150, 25);
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(introPanel);
				signUpScreen();

			}
		});

		introPanel.add(loginButton);
		introPanel.add(signUpButton);

		frame.add(introPanel);
	}*/

	public void logInScreen() {
		//frame.removeAll();
		
		frame.revalidate();
		
		logInPanel = new JPanel();
		frame.add(logInPanel);
		//frame.setVisible(true);
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
				String user = userText.getText().toLowerCase();
				String password = new String(passwordText.getPassword());
				
				List<String> lines = Collections.emptyList(); 
				try {
					File file = new File("src/JavaFinalProject/Database.txt"); 
					Scanner sc = new Scanner(file); 
					lines = Files.readAllLines(Paths.get("src/JavaFinalProject/Database.txt"));
					for(String line:lines) {
						String[] arrs = line.split(", ", 0); 
						if(arrs[0].toLowerCase().equals(user))
							userExists=true;
						if(arrs[0].toLowerCase().equals(user)&&arrs[1].equals(password))
							correctUserAndPassword=true;
					}
				}
				catch(Exception error) {
					
				}
			  
			    if(correctUserAndPassword) {
			    	//frame.setVisible(false);
					frame.remove(logInPanel);
					stockSearcherInterface();
			    }
			    else if(userExists) {
			    	loginInUnsuccessful.setText("The Password Entered is Not Correct");
			    }
			    else {
			    	loginInUnsuccessful.setText("That Username does not exist");
			    }

			}
		});
		logInPanel.add(logInButton);
		
		goBackToSignUp = new JButton("Go To Sign Up");
		goBackToSignUp.setBounds(10, 125, 125, 25);
		goBackToSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//frame.setVisible(false);
					frame.remove(logInPanel);
					signUpScreen();
					
				}
				
		});
		logInPanel.add(goBackToSignUp);

	}

	public void signUpScreen() {
		//frame.setVisible(true);
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
				if((user.equals("")||password.equals("")||passwordCheck.equals(""))) {
					missingInfo.setText("Please Enter The Missing Information");
				}
				boolean userExists = false;
				
				
				
				List<String> lines = Collections.emptyList(); 
				try {
					File file = new File("src/JavaFinalProject/Database.txt"); 
					Scanner sc = new Scanner(file); 
					lines = Files.readAllLines(Paths.get("src/JavaFinalProject/Database.txt"));
					for(String line:lines) {
						String[] arrs = line.split(", ", 0); 
						if(arrs[0].toLowerCase().equals(user.toLowerCase()))
							userExists=true;
					}
				}
				catch(Exception error) {
					
				}
				if(user.equals("")||password.equals("")||passwordCheck.equals("")) {
					missingInfo.setText("Please Fill In the Missing Information");
				}
				else if(userExists) {
					missingInfo.setText("This User Already Exists");
				}
				else if(password.equals(passwordCheck)){
					try {
						FileWriter writer = new FileWriter("src/JavaFinalProject/Database.txt", true);
						
						BufferedWriter bufferedWriter = new BufferedWriter(writer);
						
						bufferedWriter.write(user + ", " + password + "\n");
						bufferedWriter.close();
	
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					//frame.setVisible(false);
					frame.remove(signUpPanel);
					logInScreen();
					
				}
				else {
					missingInfo.setText("The passwords do not match");
					passwordReenter.setText("");
				}
				

			}
		});

		goBackToLogin = new JButton("Go To Login");
		goBackToLogin.setBounds(10, 165, 110, 25);
		goBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//frame.setVisible(false);
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
	
	public void mainScreen() {
		//Stock
	}
	
	public void stockSearcherInterface() {
		
		frame.revalidate();
		
		stockSearcherPanel = new JPanel();
		frame.add(stockSearcherPanel);
		//frame.setVisible(true);
		frame.setSize(400, 400);

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
					double price=0;
					try {
						price = Stock.fetchStockPrice(stockTicker);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(price==0) {
						displayCurrentStockPrice.setForeground(new Color(255, 64, 80));
						displayCurrentStockPrice.setText("That stock doesn't exist");
					}
					else if(price==-1) {
						displayCurrentStockPrice.setForeground(new Color(255, 64, 80));
						displayCurrentStockPrice.setText("That company is not publicly traded");
					}
					else {
						displayCurrentStockPrice.setForeground(new Color(150, 40, 209));
						displayCurrentStockPrice.setText(stockTicker+" price is: "+price);
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
		fetchStockDateField.setBounds(80, 220, 120, 25);
		stockSearcherPanel.add(fetchStockDateField);  
		fetchStockDateField.setUI(new JTextFieldHintUI("MM-DD-YYYY", new Color(120, 138, 137))); 
		getStockPriceByDateButton = new JButton("Get Stock Price");
		getStockPriceByDateButton.setBounds(10, 260, 135, 25);
		getStockPriceByDateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String stockTicker = tickerFieldWithDate.getText();
					String date = fetchStockDateField.getText();
					double price=0;
					try {
						price = Stock.getPriceAtDate(date, stockTicker);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					if(stockTicker.equals("")) {
						displayStockPriceByDate.setForeground(new Color(255, 64, 80));
						displayStockPriceByDate.setText("Enter missing ticker");
					}
					else if(date.equals("")) {
						displayStockPriceByDate.setForeground(new Color(255, 64, 80));
						displayStockPriceByDate.setText("Enter missing date");
					}
					else if(price==-1) {
						displayStockPriceByDate.setForeground(new Color(255, 64, 80));
						displayStockPriceByDate.setText("That stock doesn't exist");
					}
					else if(price==-2) {
						displayStockPriceByDate.setForeground(new Color(255, 64, 80));
						displayStockPriceByDate.setText("Either markets were closed or stock wasn't publicly traded");
					}
					else {
						displayStockPriceByDate.setForeground(new Color(150, 40, 209));
						displayStockPriceByDate.setText("On "+ date+", "+ stockTicker +" price at close was: "+price);
						displayStockPriceByDate2.setForeground(new Color(150, 40, 209));
						try {
							displayStockPriceByDate2.setText("The adjusted close price was: "+Stock.getAdjustedPriceAtDate(date, stockTicker));
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
		displayStockPriceByDate2.setBounds(10, 315, 400, 60);
		stockSearcherPanel.add(displayStockPriceByDate2);
	}
	
	

	public static void main(String[] args) {
		new UserInterface();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

}
