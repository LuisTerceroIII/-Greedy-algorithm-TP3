package controller;

import java.util.ArrayList;

import MaxEquity.MaxEquity;
import MaxEquity.Solution;
import Tools.TransformData;
import data.ReadJsonData;
import model.Calendar;
import model.Tournament;
import view.MaxEquityBarGraph;
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
		Solution solution = MaxEquity.generateMaxEquityCalendar(_tournament);
		Calendar calendar = solution.getSolution();
		MaxEquityBarGraph graph = new MaxEquityBarGraph(solution.getGraphData(), solution.getInstance().getTeams());
		_view.setGraph(graph);
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
