package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GameDayTest {
	
	private GameDay _gameDay;
	private GameDay _gameDayCopy;
	
	@Test
	public void equalsElemsTest() {
		assertTrue(_gameDay.equals(_gameDayCopy) && _gameDayCopy.equals(_gameDay));
		assertTrue(_gameDay.hashCode() == _gameDayCopy.hashCode());
	}
	@Test
	public void notEqualsElemsTest() {
		GameDay gd = new GameDay();
		assertFalse(_gameDay.equals(gd) && gd.equals(_gameDay));
		assertFalse(_gameDay.hashCode() == gd.hashCode());
	}
	
	@Before
	public void init() {
		Match matchA = new Match("Arsenal", "Manchester City");
		Match matchB = new Match("Arsenal", "Chelsea");
		ArrayList<Match> matchesDay = new ArrayList<>();
		matchesDay.add(matchA);
		matchesDay.add(matchB);
		_gameDay = new GameDay(matchesDay, 1);
		_gameDayCopy = new GameDay(matchesDay, 1);
	}

}
