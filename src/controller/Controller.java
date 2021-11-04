package controller;

import java.util.ArrayList;

import MaxEquity.MaxEquity;
import Tools.TransformData;
import data.ReadJsonData;
import model.Calendar;
import model.Tournament;
import view.View;
/*Metodos : assingReferees y updateCalendar se testean indirectamente,
 *  el primero en el paquete MaxEquity y el segundo en el paquete View*/
public class Controller {

	private View _view;
	private Tournament _tournament;

	public Controller(String tournamentFile) {
		_tournament = fetchTournamentData(tournamentFile);
		Calendar calendar = _tournament.getCalendar();
		ArrayList<String> calendarInString = TransformData.calendarToString(calendar);
		_view = new View(calendarInString, this);
	} 

	Tournament fetchTournamentData(String filename) {
		return ReadJsonData.readTournament(filename);
	}

	public void launchApp() {
		_view.start();
	}

	public void assignReferees() {
		Calendar calendar = MaxEquity.generateMaxEquityCalendar(_tournament);
		updateCalendar(calendar);
	}

	void updateCalendar(Calendar calendar) {
		_view.updateCalendar(TransformData.calendarToString(calendar));
	}

	View getView() {
		return _view;
	}

	Tournament getTournament() {
		return _tournament;
	}
	
	
	

}
