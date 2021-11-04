package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MatchTest {

	private Match _match;
	private Match _matchCopy;
	
	@Test
	public void equalsElemsTest() {
		assertTrue(_match.equals(_matchCopy) && _matchCopy.equals(_match));
		assertTrue(_match.hashCode() == _matchCopy.hashCode());
	}
	@Test
	public void notEqualsElemsTest() {
		Match mt = new Match();
		assertFalse(_match.equals(mt) && mt.equals(_match));
		assertFalse(_match.hashCode() == mt.hashCode());
	}
	
	@Before
	public void init() {
		_match = new Match("Arsenal", "Manchester City");
		_matchCopy = new Match("Arsenal", "Manchester City");;
	}

}
