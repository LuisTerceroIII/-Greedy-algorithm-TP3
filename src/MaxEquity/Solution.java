package MaxEquity;

import model.Calendar;
import view.MaxEquityBarGraph;

public class Solution {

	private MaxEquityBarGraph _graph;
	private Calendar _solution;
	private TeamsAndReferees _graphData;
	private Instance _instance;
	
	public Solution(Calendar _solution, Instance _instance) {
		super();
		this._solution = _solution;
		this._instance = _instance;
	}

	public MaxEquityBarGraph getGraph() {
		return _graph;
	}

	public void setGraph(MaxEquityBarGraph _graph) {
		this._graph = _graph;
	}

	public Calendar getSolution() {
		return _solution;
	}

	public int[][] getGraphData() {
		return _graphData.getTeamsAndReferees();
	}

	public void setGraphData(TeamsAndReferees _graphData) {
		this._graphData = _graphData;
	}

	public Instance getInstance() {
		return _instance;
	}

	
}
