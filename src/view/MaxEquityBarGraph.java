package view;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class MaxEquityBarGraph {
	
	private int[][] _countOfRefereesForTeam;
	private ArrayList<String> _teams;
	private JFreeChart _graph;
	private DefaultCategoryDataset _data;
	
	public MaxEquityBarGraph(int[][] countOfRefereesForTeam, ArrayList<String> teams) {
		super();
		this._countOfRefereesForTeam = countOfRefereesForTeam;
		this._teams = teams;
		_data = new DefaultCategoryDataset();
		addDataToGraph();
		createGraph();
		
	}

	void addDataToGraph() {
		for (int i = 0; i < _countOfRefereesForTeam.length; i++) {
		    for (int j = 0; j < _countOfRefereesForTeam[i].length; j++) {
			       _data.addValue(_countOfRefereesForTeam[i][j], "Referi "+ Integer.valueOf(j+1), _teams.get(i));
		    }
		}
	}
	
	void createGraph() {
		 _graph = ChartFactory.createBarChart(
					"Cantidad de veces que cada referi dirige para cada equipo",
					"Equipos",
					"Cantidad de veces elegido",
					_data,
					PlotOrientation.VERTICAL,
					true,
					true,
					true
					);
		
	}
	
	void showGraph() {
		ChartPanel panelGraph = new ChartPanel(_graph);
		JFrame graphFrame = new JFrame("Graph");
		graphFrame.getContentPane().add(panelGraph);
		graphFrame.pack();
		graphFrame.setVisible(true);
	}

	int[][] getCountOfRefereesForTeam() {
		return _countOfRefereesForTeam;
	}

	ArrayList<String> getTeams() {
		return _teams;
	}

	JFreeChart getGraph() {
		return _graph;
	}

	DefaultCategoryDataset getData() {
		return _data;
	}
	
	
	
}
