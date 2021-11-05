package view;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarGraph {
	
	private int[][] countOfRefereesForTeam;
	private ArrayList<String> teams;
	private JFreeChart graph;
	private DefaultCategoryDataset data;
	
	public BarGraph(int[][] countOfRefereesForTeam, ArrayList<String> teams) {
		super();
		this.countOfRefereesForTeam = countOfRefereesForTeam;
		this.teams = teams;
		data = new DefaultCategoryDataset();
		addDataToGraph();
		createGraph();
		
	}

	void addDataToGraph() {
		for (int i = 0; i < countOfRefereesForTeam.length; i++) {
		    for (int j = 0; j < countOfRefereesForTeam[i].length; j++) {
			       data.addValue(countOfRefereesForTeam[i][j], "Referi "+ Integer.valueOf(j+1), teams.get(i));
		    }
		}
	}
	
	void createGraph() {
		 graph = ChartFactory.createBarChart(
					"Cantidad de referis por equipo",
					"Equipos",
					"Veces elegido arbitro",
					data,
					PlotOrientation.VERTICAL,
					true,
					true,
					true
					);
		
	}
	
	void showGraph() {
		ChartPanel panelGraph = new ChartPanel(graph);
		JFrame graphFrame = new JFrame("Graph");
		graphFrame.getContentPane().add(panelGraph);
		graphFrame.pack();
		graphFrame.setVisible(true);
	}
	

	
	
	
}
