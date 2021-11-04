package model;

import java.util.ArrayList;
import java.util.Objects;

public class Calendar {

	private ArrayList<GameDay> _matchesDays;

	public Calendar() {
		super();

	}

	public Calendar(ArrayList<GameDay> _matchesDay) {
		super();
		this._matchesDays = _matchesDay;
	}

	@SuppressWarnings("unchecked")
	public Calendar clone() {
		return new Calendar((ArrayList<GameDay>) _matchesDays.clone());
	}
 
	
	public void setMatchesDay(ArrayList<GameDay> _matchesDay) {
		this._matchesDays = _matchesDay;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<GameDay> getMatchesDays() {
		return (ArrayList<GameDay>) _matchesDays.clone();
	}

	@Override
	public int hashCode() {
		return Objects.hash(_matchesDays);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendar other = (Calendar) obj;
		return Objects.equals(_matchesDays, other._matchesDays);
	}
	


}
