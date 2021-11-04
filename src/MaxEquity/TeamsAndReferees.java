package MaxEquity;

public class TeamsAndReferees {
	
	private int[][] _teamsAndReferees;
	
	public TeamsAndReferees(int numberOfTeams, int numberOfReferees) {
		verifyNotNegative(numberOfReferees);
		verifyNotNegative(numberOfTeams);
		_teamsAndReferees = new int[numberOfTeams][numberOfReferees];
	}
	
	// Retorna cantidad de veces que el referee recibido a arbitrado para el equipo recibido.
	public int getRefereeTimesSelectedForATeam(int team, int referee) {
		verifyTeamIndex(team);
		verifyRefereeIndex(referee);
		return _teamsAndReferees[team][referee];
	}
	
	// Aumenta en 1 la cantidad de veces que un referee arbitrara para el equipo
	// recibido.
	void selectReferee(int team, int referee) {
		verifyTeamIndex(team);
		verifyRefereeIndex(referee);
		int timesRefereeSelectedForTeam = getRefereeTimesSelectedForATeam(team, referee);
		_teamsAndReferees[team][referee] = timesRefereeSelectedForTeam + 1;
	}
	private void verifyNotNegative(int i) {
		if (i < 0) {
			throw new IllegalArgumentException("Valor invalido para: " + i);
		}	
	}
	private void verifyRefereeIndex(int referee) {
		if (referee < 0 || referee > _teamsAndReferees[0].length) {
			throw new IllegalArgumentException("Referi invalido para: " + referee);
		}	
	}
	private void verifyTeamIndex(int team) {
		if (team < 0 || team > _teamsAndReferees.length) {
			throw new IllegalArgumentException("Equipo invalido para: " + team);
		}	
		
	}

}
