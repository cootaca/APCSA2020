package APCSA_FRQ_Set1;

import java.util.Arrays;

public class NumberCubeRunner {

	public static void main(String[] args) {
		int arr[] = NumberCube.getCubeTosses(50);
		System.out.println(Arrays.toString(arr));
		int num = NumberCube.getLongestRun(arr);
		System.out.println(num);

	}

}
