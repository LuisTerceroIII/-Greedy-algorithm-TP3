package view;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MaxEquityBarGraphTest {
	
	private int[][] countOfRefereesForTeam;
	private ArrayList<String> teams;
	private MaxEquityBarGraph graph;
	
	@Test
	public void testMaxEquityBarGraph() {
		assertTrue(graph.getCountOfRefereesForTeam() != null);
		assertTrue(graph.getTeams().equals(teams));
		assertTrue(graph.getData() != null);
		assertTrue(graph.getGraph() != null);	
	}
	
	@Test
	public void testAddDataToGraph() {
		assertTrue(graph.getData().getColumnCount() == 6);
		assertTrue(graph.getData().getRowCount() == 3);
	}

	@Test
	public void testCreateGraph() {
		assertTrue(graph.getGraph().getTitle().getText().equals("Cantidad de veces que cada referi dirige para cada equipo"));
	}
	
	@Before
	public void init() {
		teams = new ArrayList<>();
		teams.add("Boca");
		teams.add("River");
		teams.add("Racing");
		teams.add("Independiente");
		teams.add("Huracan");
		teams.add("San Lorenzo");
		
		countOfRefereesForTeam = new int[6][3];
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
		
		graph = new MaxEquityBarGraph(countOfRefereesForTeam, teams);
	}	

}
