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
		int choosedReferee = 0;
		ArrayList<Integer> refereesToSelect;

		for (GameDay gameDay : matchesDays) {
			refereesToSelect = _instance.getReferees();
			
			for (Match match : gameDay.getMatches()) {
				choosedReferee = chooseReferee(match,refereesToSelect);
				addRefereeToMatch(match, choosedReferee);
				match.setReferee(choosedReferee + 1); //se suma uno para compesar convertir la lista de referees con index 0.
				refereesToSelect.remove(Integer.valueOf(choosedReferee));//Agredo esto para que no se confunda el indice con el "nombre" del arbitro.
			}
		}
		
		ret.setMatchesDay(matchesDays);
		return ret;
	}

	/*
	 * El criterio para elegir un réferi es: Para cada encuentro (Match) se elige al
	 * réferi con menor promedió de elección entre los dos equipos y que se encuentre disponible,
	 * es decir que no se halla elegido ya para otro partido en el mismo dia.
	 *  Ejemplo: 
	 *  Referis = {0,1,2} 
	 *  -El Réferi “0” a arbitrado 2 veces al equipo “A”, y 3 veces al
	 * equipo “B”, es decir el promedio de equidad es (2+3) /2 = 2,5 
	 * -El Réferi “1” a arbitrado 1 veces al equipo “A”, y 2 veces al equipo “B”, es decir el
	 * promedio de equidad es (1+2) /2 = 1,5 
	 * -El Réferi “2” a arbitrado 4 veces al equipo “A”, y 3 veces al equipo “B”,
	 *  es decir el promedio de equidad es (4+3)/2 = 3,5
	 *  
	 * Esto significa que el réferi elegido para este encuentro será el réferi “1”,
	 * ya que ofrece un promedio de equidad mayor hasta ahora.
	 */
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
	
	// Aumenta en 1 la cantidad de veces que un referee arbitrara para el equipo
	// recibido. ----- Idealmente seria privado.
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
	
	void verifyRefereeNumber(int referee) {
		if (!_instance.refereeExist(referee))
			throw new IllegalArgumentException("Referi : " + referee + " no existe");
	}

	void verifyTeamName(String team) {
		if (!_instance.teamExist(team))
			throw new IllegalArgumentException("Equipo : " + team + " no existe");
	}
	
}
