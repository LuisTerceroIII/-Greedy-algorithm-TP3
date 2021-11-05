package MaxEquity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import data.ReadJsonData;
import model.Calendar;
import model.Tournament;

public class MaxEquityTest {
 
	//Solver se testea indirectamente, se ejecuta cuando se llama a  MaxEquity.generateMaxEquityCalendar(tournament);
	@Test
	public void assingRefereesTest() {
		
		Tournament tournament = ReadJsonData.readTournament("tournament.json");
		Calendar calendar = tournament.getCalendar();
		
		calendar.getMatchesDays()
				.stream()
				.forEach(gameDay -> gameDay.getMatches()
									.stream()
									.forEach(match -> assertTrue(match.getReferee() == null)));
	
		Solution solution = MaxEquity.generateMaxEquityCalendar(tournament);
		Calendar newCalendar = solution.getSolution();
		
		newCalendar.getMatchesDays()
		.stream()
		.forEach(gameDay -> gameDay.getMatches()
							.stream()
							.forEach(match -> assertTrue(match.getReferee() != null)));
	}
	 
	
}
