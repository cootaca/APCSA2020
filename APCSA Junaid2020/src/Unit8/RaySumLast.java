package Unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RaySumLast
{
	public static int go(int[] ray)
	{
		int count = 0;
		for(int i =0; i<ray.length-1;i++) {
			if(ray[i]>ray[ray.length-1]) {
				count+=ray[i];
			}
		}
		if(count >0) {
			return count;
		}
		else {
			return -1;
		}
	}
}