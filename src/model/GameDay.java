package model;

import java.util.ArrayList;
import java.util.Objects;

public class GameDay {

	private int _dayNumber;
	private ArrayList<Match> _matches;

	public GameDay() {}
	public GameDay(ArrayList<Match> matches, int dayNumber) {
		super();
		this._matches = matches;
		this._dayNumber = dayNumber;
	}

	public ArrayList<Match> getMatches() {
		return _matches;
	}

	public int getDayNumber() {
		return _dayNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(_dayNumber, _matches);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameDay other = (GameDay) obj;
		return _dayNumber == other._dayNumber && Objects.equals(_matches, other._matches);
	}
}
