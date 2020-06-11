package JavaFinalProject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Stock extends InvestmentVehicle{
	private double buyPrice;
	private double adjustedBuyPrice;
	private double currentPrice;
	private double currentRateOfReturn;
	private double yearsHeld;
	private double numberOfShares;
	private URL webURL; 
	private double stockProfit;
	public Stock() {
		super();
		buyPrice =0;
		adjustedBuyPrice =0;
		currentPrice=0;
		currentRateOfReturn=0;
		stockProfit=0;
	}
	public Stock(String nam){
		setName(nam);
		buyPrice =0;
		adjustedBuyPrice =0;
		currentPrice=0;
		currentRateOfReturn=0;
		stockProfit=0;
	}
	public Stock(String nam, double money){
		super(nam,money);
		buyPrice =0;
		adjustedBuyPrice =0;
		currentPrice=0;
		currentRateOfReturn=0;
		stockProfit=0;
	}
	public Stock(String nam, double money, double rateOfReturn){
		super(nam,money, rateOfReturn);
		buyPrice =0;
		adjustedBuyPrice =0;
		currentPrice=0;
		currentRateOfReturn=0;
		stockProfit=0;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public void setNumberOfShares(double numberOfShares) {
		this.numberOfShares=numberOfShares;
	}
	public void setAdjustedBuyPrice(double adjustedBuyPrice) {
		this.adjustedBuyPrice=adjustedBuyPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public void setCurrentRateOfReturn(double currentRateOfReturn) {
		this.currentRateOfReturn = Math.pow(this.currentPrice/this.adjustedBuyPrice,1/this.yearsHeld)-1;
		
	}
	public void setYearsHeld(double yearsHeld) {
		this.yearsHeld=yearsHeld;
	}
	public void setStockProfit() {
		stockProfit=(currentPrice-adjustedBuyPrice)*numberOfShares;
	}
	public double getBuyPrice() {
		return this.buyPrice;
	}
	public double getCurrentPrice() {
		return this.currentPrice;
	}
	public double getCurrentRateOfReturn() {
		return this.currentRateOfReturn;
	}
	public double getStockProfit() {
		return stockProfit;
	}
	public double getYearsHeld() {
		return yearsHeld;
	}
	public double getAdjustedStockPrice() {
		return adjustedBuyPrice;
	}
	public double getNumberOfShares() {
		return numberOfShares;
	}
	public void changeCurrentPrice(String ticker) throws IOException {
		try {
			webURL = new URL("https://finance.yahoo.com/quote/"+ticker);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Ticker non-existent");
		}
		Scanner sc = new Scanner(webURL.openStream());
	    StringBuffer sb = new StringBuffer();
	    while(sc.hasNext()) {
	         sb.append(sc.next());
	      }
	    String result = sb.toString();
	      String str  = "<spanclass=\"Trsdu(0.3s)Trsdu(0.3s)Fw(b)Fz(36px)Mb(-4px)D(b)\"data-reactid=\"14\">";
	      String str2 = "</span>";
	      if(result.contains(str)) {
	    	  int index = result.indexOf(str);
	    	  int index1 = result.indexOf(str2, index);
	    	  currentPrice= Double.parseDouble(result.substring(index+str.length(),index1).replace(",", ""));
	      }
	}
	public static double fetchStockPrice(String ticker) throws IOException {
		URL url = new URL("https://finance.yahoo.com/quote/aapl");
		try {
			url = new URL("https://finance.yahoo.com/quote/"+ticker);
		}
		catch(Error e) {
			return 0;
		}
		Scanner sc = new Scanner(url.openStream());
	    StringBuffer sb = new StringBuffer();
	    
	    while(sc.hasNext()) {
	         sb.append(sc.next());
	      }
	      String result = sb.toString();
	      String str  = "<spanclass=\"Trsdu(0.3s)Trsdu(0.3s)Fw(b)Fz(36px)Mb(-4px)D(b)\"data-reactid=\"14\">";
	      String str2 = "</span>";
	      if(result.contains(str)) {
	    	  int index = result.indexOf(str);
	    	  int index1 = result.indexOf(str2, index);
	    	  if(index+str.length()==index1) {
	    		  return -1;
	    	  }
	    	  return Double.parseDouble(result.substring(index+str.length(),index1).replace(",", ""));
	    	  
	    	  
	      }
	      return 0;
	}
	public void setPriceAtDate(String date, String ticker) throws IOException {
		Integer time = dateToSeconds(date+"T00:00:00.000-0000");
		Integer time2 = 86400;
		
		if(time>0) {
			time2+=time;
		}
		Document doc = Jsoup.connect("https://finance.yahoo.com/quote/"+ticker+"/history?period1="+time+"&period2="+time2+"&interval=1d&filter=history&frequency=1d").get();
		System.out.println("https://finance.yahoo.com/quote/"+ticker+"/history?period1="+time+"&period2="+time2+"&interval=1d&filter=history&frequency=1d");
		String title = doc.title();
	
		Elements datum = doc.getElementsByClass("Py(10px) Pstart(10px)");
		if(datum.size()>=1) {
			Element priceSpan = datum.get(3).getElementsByTag("span").get(0);
			String priceAsString = priceSpan.text();
			this.buyPrice= Double.parseDouble(priceAsString.replace(",", ""));
		}
		double yearsPassed=((double)time-(double)time2)/(31540000.0);
		this.yearsHeld= yearsPassed;
	}
	public void setAdjustedPriceAtDate(String date, String ticker) throws IOException {
		Integer time = dateToSeconds(date+"T00:00:00.000-0000");
		Integer time2 = 86400;
		if(time>0) {
			time2+=time;
		}
		Document doc = Jsoup.connect("https://finance.yahoo.com/quote/"+ticker+"/history?period1="+time+"&period2="+time2+"&interval=1d&filter=history&frequency=1d").get();
		String title = doc.title();
		Elements datum = doc.getElementsByClass("Py(10px) Pstart(10px)");
		if(datum.size()>=1) {
			Element priceSpan = datum.get(4).getElementsByTag("span").get(0);
			String priceAsString = priceSpan.text();
			this.adjustedBuyPrice= Double.parseDouble(priceAsString.replace(",", ""));
		}
		double yearsPassed=((double)time-(double)time2)/(31540000.0);
		this.yearsHeld= yearsPassed;
		
	}
	/*public static double getPriceAtDate(String date, String ticker) throws IOException {
		URL url = new URL("https://finance.yahoo.com/quote/TSLA");
		Integer time = dateToSeconds(date+"T00:00:00.000-0000");
		
		Integer time2 = 86400;
		if(time>0) {
			time2+=time;
		}
		try {
		url = new URL("https://finance.yahoo.com/quote/"+ticker+"/history?period1="+time+"&period2="+time2+"&interval=1d&filter=history&frequency=1d");
		System.out.println(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(url.openStream());
	    StringBuffer sb = new StringBuffer();
	    while(sc.hasNextLine()) {
	         sb.append(sc.nextLine());
	      }
	      String result = sb.toString();
	      //System.out.println(result);
	      String str  = "<span data-reactid=\"63\">";
	      String str2 = "</span>";
	      /*if(result.contains(str)) {
	    	  int index = result.indexOf(str);
	    	  int index1 = result.indexOf(str2, index);
	    	  return Double.parseDouble(result.substring(index+str.length(),index1).replace(",", ""));
	      }
	     
	      return 0;
	}*/
	public static double getPriceAtDate(String date, String ticker) throws IOException{
		Integer time = dateToSeconds(date+"T00:00:00.000-0000");
		Integer time2 = 86400;
		if(time>0) {
			time2+=time;
		}
		
		Document doc = Jsoup.connect("https://finance.yahoo.com/quote/AAPL/history?period1=1248134400&period2=1248220700&interval=1d&filter=history&frequency=1d").get();
		try {
			doc = Jsoup.connect("https://finance.yahoo.com/quote/"+ticker+"/history?period1="+time+"&period2="+time2+"&interval=1d&filter=history&frequency=1d").get();
		} catch (IOException e) {
			return -1;
		}
		System.out.println("https://finance.yahoo.com/quote/"+ticker+"/history?period1="+time+"&period2="+time2+"&interval=1d&filter=history&frequency=1d");
		String title = doc.title();
	
		Elements datum = doc.getElementsByClass("Py(10px) Pstart(10px)");
		if(datum.size()>=1) {
			Element priceSpan = datum.get(3).getElementsByTag("span").get(0);
			String priceAsString = priceSpan.text();
			return Double.parseDouble(priceAsString.replace(",", ""));
		}
		else if(fetchStockPrice(ticker)==0) {
			return -1;
		}
		else {
			return -2;
		}
		
	}
	public static double getAdjustedPriceAtDate(String date, String ticker) throws IOException {
		Integer time = dateToSeconds(date+"T00:00:00.000-0000");
		Integer time2 = 86400;
		if(time>0) {
			time2+=time;
		}
		Document doc = Jsoup.connect("https://finance.yahoo.com/quote/"+ticker+"/history?period1="+time+"&period2="+time2+"&interval=1d&filter=history&frequency=1d").get();
		String title = doc.title();
		Elements datum = doc.getElementsByClass("Py(10px) Pstart(10px)");
		if(datum.size()>=1) {
			Element priceSpan = datum.get(4).getElementsByTag("span").get(0);
			String priceAsString = priceSpan.text();
			return Double.parseDouble(priceAsString.replace(",", ""));
		}
		else {
			return 0;
		}
	}

//
		public static Integer dateToSeconds(String timestamp){
		  if(timestamp == null) return null;
		  try {
		    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy'T'HH:mm:ss.SSSZ");
		    Date dt = sdf.parse(timestamp);
		    long epoch = dt.getTime();
		    return (int)(epoch/1000);
		  } catch(ParseException e) {
		    return 0;
		  }
		  
		}
			
	   public static void main(String args[]) throws IOException{
		   	  Scanner scan = new Scanner(System.in);
		      System.out.println("Enter A date: ");
		      String date = scan.next();
		      System.out.println("Enter A ticker: ");
		      String ticker = scan.next();
		      System.out.println(Stock.fetchStockPrice(ticker));
		      System.out.println(Stock.getPriceAtDate(date, ticker));
		      System.out.println(Stock.getAdjustedPriceAtDate(date, ticker));
		      
		   }
}
