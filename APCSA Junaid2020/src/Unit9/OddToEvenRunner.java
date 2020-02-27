package Unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.*;



public class OddToEvenRunner
{
	public static void main( String args[] )
	{
		
		Integer[] arr = {7,1,5,3,11,5,6,7,8,9,10,12345,11};
		ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList(arr));
		System.out.println(ListOddToEven.distance(ar));
		
		Integer[] arr1 = {11,9,8,7,6,5,4,3,2,1,-99,7};
		ar = new ArrayList<Integer>(Arrays.asList(arr1));
		System.out.println(ListOddToEven.distance(ar));
		
		Integer[] arr2 = {10,20,30,40,5,41,31,20,11,7};
		ar = new ArrayList<Integer>(Arrays.asList(arr2));
		System.out.println(ListOddToEven.distance(ar));
		
		Integer[] arr3= {32767,70,4,5,6,7};
		ar = new ArrayList<Integer>(Arrays.asList(arr3));
		System.out.println(ListOddToEven.distance(ar));
		
		Integer[] arr4 = {2,7,11,21,5,7};
		ar = new ArrayList<Integer>(Arrays.asList(arr4));
		System.out.println(ListOddToEven.distance(ar));
		
		Integer[] arr5 = {7,255,11,255,100,3,2};
		ar = new ArrayList<Integer>(Arrays.asList(arr5));
		System.out.println(ListOddToEven.distance(ar));
		
		Integer[] arr6 = {9,11,11,11,7,1000,3};
		ar = new ArrayList<Integer>(Arrays.asList(arr6));
		System.out.println(ListOddToEven.distance(ar));
		
		Integer[] arr7 = {7,7,7,11,2,7,7,11,11,2};
		ar = new ArrayList<Integer>(Arrays.asList(arr7));
		System.out.println(ListOddToEven.distance(ar));
		
		Integer[] arr8 = {2,4,6,8,8};
		ar = new ArrayList<Integer>(Arrays.asList(arr8));
		System.out.println(ListOddToEven.distance(ar));
	}
}