package model;

import java.util.ArrayList;
import java.util.Objects;

public class Tournament {

	private ArrayList<Integer> _referees;
	private ArrayList<String> _teams;
	private Calendar _calendar;

	public Tournament(Calendar _calendar, ArrayList<Integer> referees, ArrayList<String> teams) {
		super();
		this._calendar = _calendar;
		this._referees = referees;
		this._teams = teams;
	}

	public Calendar getCalendar() {
		return _calendar;
	}

	public ArrayList<Integer> getReferees() {
		return _referees;
	}

	public ArrayList<String> getTeams() {
		return _teams;
	}

	@Override
	public int hashCode() {
		return Objects.hash(_calendar, _referees, _teams);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tournament other = (Tournament) obj;
		return Objects.equals(_calendar, other._calendar) && Objects.equals(_referees, other._referees)
				&& Objects.equals(_teams, other._teams);
	}
	


}
