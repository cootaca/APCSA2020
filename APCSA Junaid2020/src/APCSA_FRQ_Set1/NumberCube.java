package APCSA_FRQ_Set1;

public class NumberCube {
	int arr[];
	public static int[] getCubeTosses(NumberCube cube, int numTosses) {
		int arr[]=new int[numTosses];
		for(int i=0;i<numTosses;i++) {
			arr[i]=cube.toss();
		}
		return arr;
	}
	public static int getLongestRun(int[] values) {
		int max =1;
		int j=0;
		for(int i =j;i<values.length;i++) {
			int count =1;
			for(j=i+1;j<values.length;j++) {
				if(values[i]==values[j]) {
					count++;
				}
				else
					break;
				if(count>max)
					max=count;
				
			}
		}
		if(max>1)
			return max;
		return -1;
	}
}
