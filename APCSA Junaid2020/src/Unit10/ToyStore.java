package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
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
}