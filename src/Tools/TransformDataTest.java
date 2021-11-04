package Tools;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import data.ReadJsonData;
import model.Calendar;

public class TransformDataTest {
	
	private Calendar obtainCalendar() {
		return ReadJsonData.readTournament("tournament.json").getCalendar();
	}

	@Test
	public void stringCalendarTest() {
		Calendar calendar = obtainCalendar();
		ArrayList<String> calendarString = TransformData.calendarToString(calendar);
		assertTrue(calendar.getMatchesDays().size() == calendarString.size());
	}

}
