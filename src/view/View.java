package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.Controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.awt.Color;

public class View {

	private JFrame _frame;
	private CalendarView _calendarView;
	private ArrayList<String> _calendarData;
	private Controller _controller;
	private MaxEquityBarGraph graph;

	public View(ArrayList<String> calendarData, Controller controller) {
		super();
		this._calendarData = calendarData;
		_controller = controller;
		init();
	}

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void init() {
		_frame = new JFrame();
		_frame.setBounds(100, 100, 696, 572);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		_frame.setResizable(false);
		
		_frame.getContentPane().setBackground(Color.white);

		_calendarView = new CalendarView(_calendarData);
		_frame.getContentPane().add(_calendarView.getScrollPanel());

		JLabel title = new JLabel("Calendario Campeonato");
		title.setFont(new Font("Tahoma", Font.PLAIN, 28));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setBounds(119, 19, 356, 62);
		_frame.getContentPane().add(title);

		
		JButton showGraph = new JButton("Ver grafico");
		showGraph.setEnabled(false);
		showGraph.setBounds(514, 287, 156, 23);
		_frame.getContentPane().add(showGraph);
		
		JButton assingReferee = new JButton("Asignar Referis");
		assingReferee.setBounds(514, 232, 156, 23);
		_frame.getContentPane().add(assingReferee);
	
		assingReferee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_controller.assignReferees();
				showGraph.setEnabled(true);
			}
		});

		
		showGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graph.showGraph();
			}
		});
	}
	
	public void updateCalendar(ArrayList<String> matches) {
		_calendarView.updateCalendar(matches);

	}
	
	public void setGraph(MaxEquityBarGraph graph) {
		this.graph = graph;
	}

	public MaxEquityBarGraph getGraph() {
		return graph;
	}
	
}
