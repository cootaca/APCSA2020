package APCSA_FRQ_Set2;

public class Mountain {
	//part a
	public static int getPeakIndex(int[] array) {
		
		for(int i=1;i<array.length-1;i++) {
			if(array[i]>array[i-1]&&array[i]>array[i+1]) {
				return i;
			}
		}
		return -1;
	}
	//part b
	public static boolean isMountain(int[] array) {
		int num = getPeakIndex(array);
		if(num==-1) {
			return false;
		}
		if(isIncreasing(array,num)&&isDecreasing(array,num))
			return true;
		return false;
	}
}
