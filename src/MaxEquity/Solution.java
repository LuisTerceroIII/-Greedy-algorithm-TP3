package MaxEquity;

import model.Calendar;
import view.BarGraph;

public class Solution {

	private BarGraph _graph;
	private Calendar _solution;
	private TeamsAndReferees _graphData;
	private Instance _instance;
	
	public Solution(Calendar _solution, Instance _instance) {
		super();
		this._solution = _solution;
		this._instance = _instance;
	}

	public BarGraph getGraph() {
		return _graph;
	}

	public void setGraph(BarGraph _graph) {
		this._graph = _graph;
	}

	public Calendar getSolution() {
		return _solution;
	}

	public void setSolution(Calendar _solution) {
		this._solution = _solution;
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
