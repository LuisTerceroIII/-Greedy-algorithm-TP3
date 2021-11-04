package MaxEquity;

import java.util.ArrayList;

import model.Calendar;
import model.GameDay;


/*
 * La instancia del problema son los equipos, los arbitros y una matriz 
 * que representa cuantas veces un arbitro a dirigido para cada equipo.
 * Los equipos son las filas, los referes las columnas,
 * en un campeonato donde n = 3, la matrix es 6*3.
 * */
class Instance {
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
	
	ArrayList<String> getTeams() {
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
