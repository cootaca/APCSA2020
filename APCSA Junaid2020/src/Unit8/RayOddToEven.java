package Unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static boolean go(int[] ray)
	{
		return false;
	}
	
	public static int checker(int arr[]) {
		int odd1 = 0;
		int even1 = 0;
		for(int i=0; i<arr.length;i++) {
			if(arr[i]%2==1) {
				odd1 = i;
				break;
			}
		}
		for(int i=odd1+1; i<arr.length;i++) {
			if(arr[i]%2==0) {
				even1 = i;
				break;
			}
		}
		if(even1-odd1>0) {
			return even1-odd1;
		}
		else {
			return -1;
		}
	}
}