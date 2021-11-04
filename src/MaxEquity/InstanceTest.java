package MaxEquity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Calendar;
import model.GameDay;
import model.Match;

public class InstanceTest {
	
	private Instance _instance;
	private ArrayList<String> _teams;
	private ArrayList<Integer> _referees;
	private  Calendar _calendar;
	
	//Se testea porque se retorna una copia, no el original
	@Test
	public void getRefereesDeepCopyTest() {
		assertFalse(_instance.getReferees() == _referees);
	}
	@Test
	public void getRefereesSameSizesTest() {
		assertEquals(_instance.getReferees().size(), _referees.size());
	}
	
	@Test
	public void getRefereesAllEqualsElemsTest() {
		for(Integer referee :_instance.getReferees())
			assertTrue(_referees.contains(referee));
	}
	
	@Test
	public void getTeamsSameSizesTest() {
		assertEquals(_instance.getTeams().size(), _teams.size());
	}
	
	@Test
	public void getTeamsAllEqualsElemsTest() {
		for(String team :_instance.getTeams())
			assertTrue(_teams.contains(team));
	}
	
	@Test
	public void getMatchesDaysSameSizeTest() {
		assertEquals(_instance.getMatchesDays(), _calendar.getMatchesDays());
	}
	
	@Test
	public void getIndexOfTeamTest() {
		int teamIndex = _teams.indexOf("Chelsea");
		assertEquals(teamIndex, _instance.getIndexOfTeam("Chelsea"));
	}
	
	@Test
	public void numberOfTeamsTest() {
		assertTrue(_teams.size() == _instance.numberOfTeams());	
	}
	
	@Test
	public void numberOfRefereesTest() {
		assertTrue(_referees.size() == _instance.numberOfReferees());	
	}
	
	@Test
	public void refereeExistTest() {
		assertTrue(_instance.refereeExist(1));
	}
	
	@Test
	public void refereeNotExistTest() {
		assertFalse(_instance.refereeExist(2));
	}
	
	@Test
	public void teamExistTest() {
		assertTrue(_instance.teamExist("Arsenal"));
	}

	@Test
	public void teamNotExistTest() {
		assertFalse(_instance.teamExist("Boca"));
	}
	@Before
	public void init() {
		ArrayList<String> teams = new ArrayList<>();
		ArrayList<Integer> referees = new ArrayList<>();
		teams.add("Arsenal");
		teams.add("Manchester City");
		teams.add("Manchester United");
		teams.add("Chelsea");
		referees.add(0);
		referees.add(1);

		Match matchA = new Match("Arsenal", "Manchester City");
		Match matchB = new Match("Arsenal", "Chelsea");
		Match matchC = new Match("Manchester United", "Chelsea");
		Match matchD = new Match("Manchester United", "Manchester City");
		
		ArrayList<Match> matchesDayOne = new ArrayList<>();
		ArrayList<Match> matchesDayTwo = new ArrayList<>();
		matchesDayOne.add(matchA);
		matchesDayOne.add(matchB);
		matchesDayTwo.add(matchC);
		matchesDayTwo.add(matchD);
		GameDay gameDay1 = new GameDay(matchesDayOne, 1);
		GameDay gameDay2 = new GameDay(matchesDayTwo, 2);
		
		ArrayList<GameDay> gameDays = new ArrayList<>();
		gameDays.add(gameDay1);
		gameDays.add(gameDay2);
		
		Calendar calendar = new Calendar();
		calendar.setMatchesDay(gameDays);	
		
		_referees = referees;
		_teams = teams;
		_calendar = calendar;
		_instance = new Instance(teams, referees,calendar);
	}
	
	
}
