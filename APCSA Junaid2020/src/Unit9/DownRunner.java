package Unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.*;

public class DownRunner
{
	public static void main( String args[] )
	{					
		Integer[] arr0 = {-99, 1,2,3,4,5,6,7,8,9,10,12345};
		ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList(arr0));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr1 = {10,9,8,7,6,5,4,3,2,1,-99};
		ar = new ArrayList<Integer>(Arrays.asList(arr1));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr2 = {10,20,30,40,50,-11818,40,30,20,10};
		ar = new ArrayList<Integer>(Arrays.asList(arr2));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr3 = {32767};
		ar = new ArrayList<Integer>(Arrays.asList(arr3));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr4 = {255,255};
		ar = new ArrayList<Integer>(Arrays.asList(arr4));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr5 = {9,10,-88,100,-555,1000};
		ar = new ArrayList<Integer>(Arrays.asList(arr5));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr6 = {10,10,10,11,456};
		ar = new ArrayList<Integer>(Arrays.asList(arr6));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr7 = {-111,1,2,3,9,11,20,30};
		ar = new ArrayList<Integer>(Arrays.asList(arr7));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr8 = {9,8,7,6,5,4,3,2,0,-2,-989};
		ar = new ArrayList<Integer>(Arrays.asList(arr8));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr9= {12,15,18,21,23,1000};
		ar = new ArrayList<Integer>(Arrays.asList(arr9));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr10 = {250,19,17,15,13,11,10,9,6,3,2,1,-455};
		ar = new ArrayList<Integer>(Arrays.asList(arr10));
		System.out.println(ListDown.go(ar));
		
		Integer[] arr11 = {9,10,-8,10000,-5000,1000};
		ar = new ArrayList<Integer>(Arrays.asList(arr11));
		System.out.println(ListDown.go(ar));
	}
}