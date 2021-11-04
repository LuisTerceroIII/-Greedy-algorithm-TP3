package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import data.ReadJsonData;

public class TournamentTest {

	private Tournament _tournament;
	private Tournament _tournamentCopy;
	
	@Test
	public void equalsElemsTest() {
		assertTrue(_tournament.equals(_tournamentCopy) && _tournamentCopy.equals(_tournament));
		assertTrue(_tournament.hashCode() == _tournamentCopy.hashCode());
	}
	@Test
	public void notEqualsElemsTest() {
		Match mt = new Match();
		assertFalse(_tournament.equals(mt) && mt.equals(_tournament));
		assertFalse(_tournament.hashCode() == mt.hashCode());
	}
	
	@Before
	public void init() {
		_tournament = ReadJsonData.readTournament("tournament.json");
		_tournamentCopy = ReadJsonData.readTournament("tournament.json");
	}

}
