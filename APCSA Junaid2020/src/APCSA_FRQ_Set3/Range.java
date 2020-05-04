package APCSA_FRQ_Set3;

import java.util.*;

interface NumberGroup {
	public boolean contains(int num);
}

public class Range implements NumberGroup {
	private int min;
	private int max;

	public Range() {
		min = 0;
		max = 1;
	}

	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public boolean contains(int num) {
		if (num >= min && num <= max) {
			return true;
		}
		return false;
	}
}

class MultipleGroups {
	private List<NumberGroup> groupList;

	public MultipleGroups() {
		groupList = null;
	}

	public MultipleGroups(ArrayList<NumberGroup> numbers) {
		groupList = numbers;
	}

	public boolean contains(int num) {
		for(NumberGroup nums:groupList)
		{
			if(nums.contains(num))
					return true;
		}
		return false;
	}
}
