package Unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class DownRunner
{
	public static void main( String args[] )
	{						
		int[] arr0 = {-99,1,2,3,4,5,6,7,8,9,10,12345};
		System.out.println(RayDown.go(arr0));
		
		int[] arr1 = {10,9,8,7,6,5,4,3,2,1,-99};
		System.out.println(RayDown.go(arr1));
		
		int[] arr2 = {10,20,30,40,50,-11818,40,30,20,10};
		System.out.println(RayDown.go(arr2));
		
		int[] arr3 = {32767};
		System.out.println(RayDown.go(arr3));
		
		int[] arr4 = {255,255};
		System.out.println(RayDown.go(arr4));
		
		int[] arr5 = {9,10,-88,100,-555,1000};
		System.out.println(RayDown.go(arr5));
		
		int[] arr6 = {10,10,10,11,456};
		System.out.println(RayDown.go(arr6));
		
		int[] arr7 = {-111,1,2,3,9,11,20,30};
		System.out.println(RayDown.go(arr7));
		
		int[] arr8 = {9,8,7,6,5,4,3,2,0,-2,-989};
		System.out.println(RayDown.go(arr8));
		
		int[] arr9= {12,15,18,21,23,1000};
		System.out.println(RayDown.go(arr9));
		
		int[] arr10 = {250,19,17,15,13,11,10,9,6,3,2,1,-455};
		System.out.println(RayDown.go(arr10));
		
		int[] arr11 = {9,10,-8,10000,-5000,1000};
		System.out.println(RayDown.go(arr11));
		
	}
}