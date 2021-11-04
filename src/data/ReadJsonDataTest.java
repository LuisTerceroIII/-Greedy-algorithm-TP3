package data;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import model.Calendar;
import model.Tournament;

public class ReadJsonDataTest {
	
	private Tournament readTorunamentFile() {
		return ReadJsonData.readTournament("tournament.json");
	}
	
	@Test()
	public void fileNotFoundTest() throws FileNotFoundException {
		ReadJsonData.readTournament("failTestCase.json");
	}
		
	@Test//Esto verifica que el archivo se leyo correctamente.
	public void tournamentNotNullTest() {
		Tournament tournament = readTorunamentFile(); 
		assertTrue(tournament != null);
	}
	
	@Test
	public void tournamentCalendarNotNullTest() {
		Tournament tournament = readTorunamentFile();
		Calendar calendar = tournament.getCalendar();
		assertTrue(calendar != null);
	}
	
	@Test
	public void tournamentRefereesNotNullTest() {
		Tournament tournament = readTorunamentFile();
		ArrayList<Integer> referees = tournament.getReferees();
		assertTrue(referees != null);
	}
	
	@Test
	public void tournamentTeamsNotNullTest() {
		Tournament tournament = readTorunamentFile();
		ArrayList<String> teams = tournament.getTeams();
		assertTrue(teams != null);
	}
	
}
	