package controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import data.ReadJsonData;
import model.Tournament;

public class ControllerTest {
	
	private Controller _controller;
	private String jsonFile = "tournament.json";
	
	@Before
	public void init() {
		_controller = new Controller(jsonFile);
	}
	@Test
	public void testMainController() {
		assertTrue(_controller.getTournament() != null);
		assertTrue(_controller.getView() != null);
	}

	@Test
	public void testFetchTournamentData() {
		Tournament  t = ReadJsonData.readTournament(jsonFile);
		assertEquals(t, _controller.getTournament());
	}
}
