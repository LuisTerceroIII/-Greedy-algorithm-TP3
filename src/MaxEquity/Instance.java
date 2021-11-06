package MaxEquity;

import java.util.ArrayList;

import model.Calendar;
import model.GameDay;

public class Instance {
	private ArrayList<String> _teams;
	private ArrayList<Integer> _referees;
	private  Calendar _calendar;
	
	public Instance(ArrayList<String> teams, ArrayList<Integer> referees, Calendar calendar) {
		_teams = teams;
		_referees = referees;
		_calendar = calendar;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getReferees() {
		return (ArrayList<Integer>) _referees.clone();
	}
	
	public ArrayList<String> getTeams() {
		return _teams;
	}
	
	public ArrayList<GameDay> getMatchesDays() {
		return _calendar.getMatchesDays();
	}
	
	public int numberOfTeams() {
		return _teams.size();
	}
	public int numberOfReferees() {
		return _referees.size();
	}

	public boolean refereeExist(int referee) {
		return _referees.contains(referee);
	}
	public boolean teamExist(String team) {
		return _teams.contains(team);
	}
	public int getIndexOfTeam(String team) {
		return _teams.indexOf(team);
	}

}
