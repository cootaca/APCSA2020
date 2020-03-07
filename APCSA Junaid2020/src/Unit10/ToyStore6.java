package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore6
{
	private ArrayList<Toy> toyList;

	public ToyStore6()
	{
		toyList = new ArrayList<Toy>();
	}
	
	public ToyStore6(ArrayList<Toy> toss) {
		toyList = toss;
	}
	
	public ToyStore6(String str) {
		String[] sting = str.split(" ", 0);
		toyList = new ArrayList<Toy>();
		//String og = sting[0];
		for(int i =0; i<sting.length;i++) {
			int count = 0;
			for(int j = i; j<sting.length;j++) {
				if(sting[i].equals(sting[j])) {
					count++;
				}
			}
			
			toyList.add(new Toy(sting[i], count));
		}
		for(int j =0; j<toyList.size();j++) {
			Toy ty = toyList.get(j);
			String search = ty.getName();
			for(int i =j+1; i<toyList.size();i++) {
				if(search.equals(toyList.get(i).getName())) {
					toyList.remove(i);
					i--;
				}
				
			}
		}
	}

	public void loadToy( String toys , int count)
	{
		Toy toy = new Toy(toys,count);
		toyList.add(toy);
	}
  public void loadToys(String toys) {
	  	String[] sting = toys.split(" ", 0);
	  	int num = toyList.size();
		for(int i =0; i<sting.length;i++) {
			int count = 0;
			for(int j = i; j<sting.length;j++) {
				if(sting[i].equals(sting[j])) {
					count++;
				}
			}
			/*for(int f =0;f<num;f++) {
				if(sting[i].equals(toyList.get(f).getName())) {
					toyList.get(f).setCount(toyList.get(f).getCount()+count);
				}
			}*/
			toyList.add(new Toy(sting[i], count));
		}
		for(int j=0;j<num;j++) {
			for(int y =num;y<toyList.size();y++) {
				if(toyList.get(j).getName().equals(toyList.get(y).getName())) {
					toyList.get(j).setCount(toyList.get(j).getCount()+toyList.get(y).getCount());
					break;
				}
			}
		}
		for(int j =0; j<toyList.size();j++) {
			Toy ty = toyList.get(j);
			String search = ty.getName();
			for(int i =j+1; i<toyList.size();i++) {
				if(search.equals(toyList.get(i).getName())) {
					toyList.remove(i);
					i--;
				}
				
			}
		}
  }
  	public Toy getThatToy( String nm )
  	{
  		for(Toy toy:toyList) {
  			if(toy.getName()==nm) {
  				return toy;
  			}
  		}
  		 return null;
  	}
  
  	public String getMostFrequentToy()
  	{
  	
  		Toy max = toyList.get(0);
  		for(int i =1;i<toyList.size();i++) {
  			if(max.getCount()<toyList.get(i).getCount()) {
  				max = toyList.get(i);
  			}
  		}
  		return max.getName();
  	}  
  
  	
  	@Override
	public String toString()
	{
  		if(toyList.size()==0) {
  			return "[]";
  		}
  		String str = "["; 
  		for(Toy toy: toyList) {
  			str+= toy.getName() +" "+ toy.getCount()+", ";
  		}
  		str = str.substring(0,str.length()-2);
  		str+= "]";
	    return str;
	}
	public String myName(){
		return "Junaid Ahmad";
	}
}
