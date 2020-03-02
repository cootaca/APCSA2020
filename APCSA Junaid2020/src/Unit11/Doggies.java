package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		pups = new Dog[size];	
	}
	
	public void set(int spot, int age, String name)
	{
		pups[spot]=new Dog(age,name);
	}

	public String getNameOfOldest()
	{
		int max = 0;
		int index = 0;
		for(int i = 0;i<pups.length;i++) {
			if(pups[i].getAge()>max) {
				max = pups[i].getAge();
				index = i;
			}
		}
		return pups[index].getName();
	}

	public String getNameOfYoungest()
	{
		int min = pups[0].getAge();
		int index = 0;
		for(int i = 1;i<pups.length;i++) {
			if(pups[i].getAge()<min) {
				min = pups[i].getAge();
				index = i;
			}
		}
		return pups[index].getName();
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}