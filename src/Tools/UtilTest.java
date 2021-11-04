package Tools;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import data.ReadJsonData;
import model.Tournament;

public class UtilTest {

	@Test
	public void testAverageOfTwoNumberNaturalNumberResult() {
		int num1 = 10;
		int num2 = 30;
		double average = (double) (num1+num2)/2;
		assertTrue(average == Util.averageOfTwoNumber(num1, num2));
	}
	@Test
	public void testAverageOfTwoNumberRationalNumberResult() {
		int num1 = 8;
		int num2 = 3;
		double average = (double) (num1+num2)/2;
		assertTrue(average == Util.averageOfTwoNumber(num1, num2));
	}
	@Test
	public void testAverageOfTwoNumberIsRationalNumberResult() {
		int num1 = 8;
		int num2 = 3;
		double average = (double) (num1+num2)/2;
		assertTrue(average == 5.5);
	}
	
	@Test
	public void convertRefereesZeroIndex() {
		Tournament tournament = ReadJsonData.readTournament("tournament.json");
		ArrayList<Integer> referees = tournament.getReferees();
		ArrayList<Integer> zeroIndexReferee = Util.zeroIndexReferees(referees);
		for (int i = 0; i < zeroIndexReferee.size(); i++) {
			assertTrue(zeroIndexReferee.get(i)+1 == referees.get(i));
		}
	}

}
