package MaxEquity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Calendar;
import model.GameDay;
import model.Match;
import view.MaxEquityBarGraph;

public class SolutionTest {

	private Instance _instance;
	private Solver _solver;

	@Test
	public void testSolution() {
		Solution s = new Solution(_solver.resolve(), _instance);
		assertTrue(s != null);
		assertTrue(s.getInstance() != null);
		assertTrue(s.getSolution() != null);
	}
	
	@Test
	public void testGetGraph() {
		Solution s = new Solution(_solver.resolve(), _instance);
		assertTrue(s.getGraph() == null);
	}

	@Test
	public void testSetGraph() {
		Solution s = new Solution(_solver.resolve(), _instance);
		assertTrue(s.getGraph() == null);
		s.setGraph(generateGraph());
		assertTrue(s.getGraph() != null);
	} 
	
	@Test
	public void testGetSolution() {
		Solution s = new Solution(_solver.resolve(), _instance);
		assertTrue(s.getSolution().equals(_solver.resolve()));
	}

	@Test
	public void testSetYGetGraphData() {
		Solution s = new Solution(_solver.resolve(), _instance);
		s.setGraphData(new TeamsAndReferees(6,3));
		assertTrue(s.getGraphData().length == 6);
		assertTrue(s.getGraphData()[0].length == 3);
	}


	@Test
	public void testGetInstance() {
		Solution s = new Solution(_solver.resolve(), _instance);
		assertTrue(s.getInstance().equals(_instance));
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
		
		_instance = new Instance(teams, referees,calendar);
		
		_solver = new Solver(_instance);
		
		/****************************************/
	
	}	
	
	private MaxEquityBarGraph generateGraph() {
		ArrayList<String> teams = new ArrayList<>();
		teams.add("Boca");
		teams.add("River");
		teams.add("Racing");
		teams.add("Independiente");
		teams.add("Huracan");
		teams.add("San Lorenzo");
		
		int[][] countOfRefereesForTeam = new int[6][3];
		countOfRefereesForTeam[0][0] = 4;
		countOfRefereesForTeam[1][0] = 4;
		countOfRefereesForTeam[2][0] = 3;
		countOfRefereesForTeam[3][0] = 3;
		countOfRefereesForTeam[4][0] = 3;
		countOfRefereesForTeam[5][0] = 3;
	/**********************************************/
		countOfRefereesForTeam[0][1] = 3;
		countOfRefereesForTeam[1][1] = 3;
		countOfRefereesForTeam[2][1] = 4;
		countOfRefereesForTeam[3][1] = 3;
		countOfRefereesForTeam[4][1] = 4;
		countOfRefereesForTeam[5][1] = 3;
		countOfRefereesForTeam[5][0] = 3;
	/**********************************************/
		countOfRefereesForTeam[0][2] = 3;
		countOfRefereesForTeam[1][2] = 3;
		countOfRefereesForTeam[2][2] = 3;
		countOfRefereesForTeam[3][2] = 4;
		countOfRefereesForTeam[4][2] = 3;
		countOfRefereesForTeam[5][2] = 4;
		countOfRefereesForTeam[5][0] = 3;	
		
		return new MaxEquityBarGraph(countOfRefereesForTeam, teams);
	}
		

}
