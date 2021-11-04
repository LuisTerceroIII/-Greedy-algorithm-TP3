package MaxEquity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import data.ReadJsonData;
import model.Calendar;
import model.GameDay;
import model.Match;
import model.Tournament;

public class MaxEquityTest {
 
	//Solver se testea indirectamente, se ejecuta cuando se llama a  MaxEquity.generateMaxEquityCalendar(tournament);
	@Test
	public void assingRefereesTest() {
		
		Tournament tournament = ReadJsonData.readTournament("tournament.json");
		Calendar calendar = tournament.getCalendar();
	
		for(GameDay gameDay : calendar.getMatchesDays()) {
			for(Match match : gameDay.getMatches()) {
				assertTrue(match.getReferee() == null);
			}
		}
		
		Calendar newCalendar = MaxEquity.generateMaxEquityCalendar(tournament);
		
		for(GameDay gameDay : newCalendar.getMatchesDays()) {
			for(Match match : gameDay.getMatches()) {
				assertTrue(match.getReferee() != null);
			}
		}
	}
	 
	@Test
	public void  assingDiferentRefereesEachDayTest() {
		
	}
	
}
