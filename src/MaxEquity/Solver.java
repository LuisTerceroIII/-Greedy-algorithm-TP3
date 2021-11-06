package MaxEquity;

import java.util.ArrayList;

import Tools.Util;
import model.Calendar;
import model.GameDay;
import model.Match;

public class Solver {
	
	private Instance _instance;
	private TeamsAndReferees _teamsAndReferees;
	
	public Solver(Instance problemInstance) {
		this._instance = problemInstance;
		_teamsAndReferees = new TeamsAndReferees(_instance.numberOfTeams(), _instance.numberOfReferees());
	}
	 
	//Se testea indirectamente, si MaxEquity.generateMaxEquityCalendar es correcto este metodo funciona.
	public  Calendar resolve() {
		Calendar ret = new Calendar();
		ArrayList<GameDay> matchesDays = _instance.getMatchesDays();
		matchesDays.stream()
				   .forEach(gameDay -> {
					   var refereesToSelect = _instance.getReferees();
					   gameDay.getMatches()
							  .stream()
							  .forEach(match -> {
								  	var choosedReferee = chooseReferee(match,refereesToSelect);
									addRefereeToMatch(match, choosedReferee);
									match.setReferee(choosedReferee + 1); //se suma uno para compesar convertir la lista de referees con index 0.
									refereesToSelect.remove(Integer.valueOf(choosedReferee));//Agredo esto para que no se confunda el indice con el "nombre" del arbitro.
								});
					});
		ret.setMatchesDay(matchesDays);
		return ret;
	}

	//Si solo queda un referee retorna el referi 0.
	 int chooseReferee(Match match, ArrayList<Integer> referees) {
		int refereeSelected = 0;
		double lowerAverage = 100;
		
		for (Integer referee : referees) {
			int timesSelectedForTeamA = getRefereeTimesSelectedForATeam(match.getTeamA(), referee);
			int timesSelectedForTeamB = getRefereeTimesSelectedForATeam(match.getTeamB(), referee);
			double equityAverage = Util.averageOfTwoNumber(timesSelectedForTeamA, timesSelectedForTeamB);

			if (equityAverage < lowerAverage) {
				refereeSelected = referee;
				lowerAverage = equityAverage;
			}	
		}
		return refereeSelected;
	}
	
	// Aumenta en 1 la cantidad de veces que un referee arbitrara para el equipo recibido.
	void addRefereeToMatch(Match match, int referee) {
		verifyRefereeNumber(referee);
		verifyTeamName(match.getTeamA());
		verifyTeamName(match.getTeamB());

		int teamAMatrixIndex = _instance.getIndexOfTeam(match.getTeamA());
		_teamsAndReferees.selectReferee(teamAMatrixIndex, referee);

		int teamBMatrixIndex = _instance.getIndexOfTeam(match.getTeamB());
		_teamsAndReferees.selectReferee(teamBMatrixIndex, referee);
	}
	
	public int getRefereeTimesSelectedForATeam(String team, int referee) {
		verifyRefereeNumber(referee);
		verifyTeamName(team);
		int teamNumber = _instance.getIndexOfTeam(team);
		return _teamsAndReferees.getRefereeTimesSelectedForATeam(teamNumber, referee);
	}
	
	TeamsAndReferees getTeamsAndReferees() {
		return _teamsAndReferees;
	}

	void verifyRefereeNumber(int referee) {
		if (!_instance.refereeExist(referee))
			throw new IllegalArgumentException("Referi : " + referee + " no existe");
	}

	void verifyTeamName(String team) {
		if (!_instance.teamExist(team))
			throw new IllegalArgumentException("Equipo : " + team + " no existe");
	}
	
}
