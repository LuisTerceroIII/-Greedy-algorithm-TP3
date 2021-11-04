package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import data.ReadJsonData;

public class CalendarTest {
	
	private Calendar _calendar;
	private Calendar _cloneCalendar;
	
	@Before
	public void obtainCalendar() {
		_calendar = ReadJsonData.readTournament("tournament.json").getCalendar();
		_cloneCalendar = _calendar.clone();
	}

	@Test
	public void cloneTest() {
		assertTrue(_calendar != _cloneCalendar);
	}
	
	@Test
	public void cloneElemTest() {
		for (GameDay gameDay : _calendar.getMatchesDays()) 
			for(GameDay gameDayCopy : _cloneCalendar.getMatchesDays()) 
				if(gameDay.equals(gameDayCopy)) 
					assertArrayEquals(gameDay.getMatches().toArray(),gameDayCopy.getMatches().toArray());
	}
	
	@Test
	public void equalsElemsTest() {
		assertTrue(_calendar.equals(_cloneCalendar) && _cloneCalendar.equals(_calendar));
		assertTrue(_calendar.hashCode() == _cloneCalendar.hashCode());
	}
	@Test
	public void notEqualsElemsTest() {
		Calendar c = new Calendar();
		assertFalse(_calendar.equals(c) && c.equals(_calendar));
		assertFalse(_calendar.hashCode() == c.hashCode());
	}
	
}
