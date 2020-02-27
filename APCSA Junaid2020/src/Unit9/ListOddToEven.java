package Unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	public static boolean go( List<Integer> ray )
	{
		return false;
	}
	public static int distance(List<Integer> ray) {
		Integer odd = null;
		Integer even=null;
		int i = 0;
		
		int count =0;
		for (i=0;i<ray.size();i++) {
			if(ray.get(i)%2==1) {
				odd = ray.get(i);
				break;
			}
			
		}
		for ( int y=i;y<ray.size();y++) {
			if(ray.get(y)%2==0) {
				even = ray.get(y);
				count = y;
			}
		}
		if(odd==null||even==null) {
			return -1;
		}
		else {
			return count-i;
		}
	}
}