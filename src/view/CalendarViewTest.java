package view;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CalendarViewTest {
		
	private ArrayList<String> _matches;
	private CalendarView _calendarView;
	
	@Test
	public void testWritteCalendar() {
		initializeWithoutMatches();
		assertTrue(_calendarView.get_matches().size() == 0);
		_calendarView.set_matches(_matches);
		_calendarView.updateCalendar(_matches);
		assertTrue(_calendarView.get_matches().size() == 2);
	}

	@Test
	public void testUpdateCalendar() {
		initializeWithMatches();
		assertTrue(_calendarView.get_matches().size() == 2);
	
		ArrayList<String> newMatches = new ArrayList<>();
		newMatches.add("Arsenal vs Chelsea");
		newMatches.add("Inter de Milan vs Juventus");
		newMatches.add("Universidad de Chile vs Union Española");
		newMatches.add("Milan vs PSG");
		
		_calendarView.updateCalendar(newMatches);
		assertTrue(_calendarView.get_matches().size() == 4);
	}
	
	@Test
	public void testCleanCalendar() {
		initializeWithMatches();
		assertFalse(_calendarView.get_calendarData().getText().equals(""));
		_calendarView.cleanCalendar();
		assertTrue(_calendarView.get_calendarData().getText().equals(""));	
	}
	
	private void initializeWithoutMatches() {
		_matches = new ArrayList<>();	
		_matches.add("River vs Boca");
		_matches.add("Barcelona vs Real Madrid");
		_calendarView = new CalendarView();
	}
	
	private void initializeWithMatches() {
		_matches = new ArrayList<>();	
		_matches.add("River vs Boca");
		_matches.add("Barcelona vs Real Madrid");
		_calendarView = new CalendarView(_matches);
	}
	 
}
