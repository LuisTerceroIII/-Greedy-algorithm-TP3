package MaxEquity;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TeamsAndRefereesTest {

	private TeamsAndReferees _teamsAndReferees;
	private int numberOfTeams = 6;
	private int numberOfReferees = 3;

	@Before
	public void init() {
		_teamsAndReferees = new TeamsAndReferees(numberOfTeams, numberOfReferees);
		// Equipo 0 a sido dirigido por arbitro 0, dos veces.
		_teamsAndReferees.selectReferee(0, 0);
		_teamsAndReferees.selectReferee(0, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verifyRefereeInContrtuctorNegativeIndex() {
		@SuppressWarnings("unused")
		TeamsAndReferees tr = new TeamsAndReferees(0, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verifyTeamInContrtuctorNegativeIndex() {
		@SuppressWarnings("unused")
		TeamsAndReferees tr = new TeamsAndReferees(-1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verifyTeamIndexOutBound() {
		_teamsAndReferees.getRefereeTimesSelectedForATeam(7, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verifyTeamNegativeIndex() {
		_teamsAndReferees.getRefereeTimesSelectedForATeam(-1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verifyRefereeIndexOutBound() {
		_teamsAndReferees.getRefereeTimesSelectedForATeam(5, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verifyRefereeNegativeIndex() {
		_teamsAndReferees.getRefereeTimesSelectedForATeam(5, -1);
	}

	@Test
	public void testGetRefereeTimesSelectedForATeam() {
		assertTrue(_teamsAndReferees.getRefereeTimesSelectedForATeam(0, 0) == 2);
	}

	@Test
	public void testSelectReferee() {
		_teamsAndReferees.selectReferee(0, 0);
		assertTrue(_teamsAndReferees.getRefereeTimesSelectedForATeam(0, 0) == 3);
	}


}
