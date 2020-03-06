package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		toyList = null;
	}
	
	public ToyStore(ArrayList<Toy> toss) {
		toyList = toss;
	}
	
	public ToyStore(String str) {
		String[] sting = str.split(" ", 0);
		//List<String> relString = new ArrayList<String>(Arrays.asList(sting));
		//String og = sting[0];
		for(int i =0; i<sting.length;i++) {
			int count = 0;
			for(int j = i+1; i<sting.length;j++) {
				if(sting[i]==sting[j]) {
					count++;
				}
			}
			String ret = sting[i] + count;
			toyList.add(ret);
		}
	}

	public void loadToys( String toys , int count)
	{
		Toy toy = new Toy(toys,count);
		toyList.add(toy);
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
  		return "";
  	}  
  
  	public void sortToysByCount()
  	{
  	}  
  	  
	public String toString()
	{
	   return "";
	}
	public String myName(){
		return "Junaid Ahmad";
	}
}