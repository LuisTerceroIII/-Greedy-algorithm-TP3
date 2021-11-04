package Tools;

import java.util.ArrayList;

public class Util {
	
	public static double averageOfTwoNumber(int num1, int num2) {
		return (double)(num1+num2)/2;
	}

	public static ArrayList<Integer> zeroIndexReferees(ArrayList<Integer> referees) {
		ArrayList<Integer> ret = new ArrayList<>();
		for(int i = 0; i < referees.size() ; i++) {
			ret.add(i);
		}
		return ret;
	}
}
