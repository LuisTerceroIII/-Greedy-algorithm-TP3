package model;

import java.util.Objects;

public class Match {

	private String _teamA;
	private String _teamB;
	private Integer _referee;

	public Match() {
		
	}
	public Match(String teamA, String teamB) {
		super();
		this._teamA = teamA;
		this._teamB = teamB;
		this._referee = null;
	}

	public Integer getReferee() {
		return _referee;
	}

	public void setReferee(int referee) {
		this._referee = referee;
	}

	public String getTeamA() {
		return _teamA;
	}

	public String getTeamB() {
		return _teamB;
	}

	@Override
	public int hashCode() {
		return Objects.hash(_referee, _teamA, _teamB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		return Objects.equals(_referee, other._referee) && Objects.equals(_teamA, other._teamA)
				&& Objects.equals(_teamB, other._teamB);
	}
}
