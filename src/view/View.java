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

public class View {

	private JFrame _frame;
	private CalendarView _calendarView;
	private ArrayList<String> _calendarData;
	private Controller _controller;
	private BarGraph graph;

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
					UIManager.setLookAndFeel(
							UIManager.getSystemLookAndFeelClassName());
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

		_calendarView = new CalendarView(_calendarData);
		_frame.getContentPane().add(_calendarView.getScrollPanel());

		JLabel title = new JLabel("Calendario Campeonato");
		title.setFont(new Font("Tahoma", Font.PLAIN, 28));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setBounds(119, 19, 356, 62);
		_frame.getContentPane().add(title);

		
		JButton verGrafico = new JButton("Ver grafico");
		verGrafico.setEnabled(false);
		verGrafico.setBounds(514, 287, 156, 23);
		_frame.getContentPane().add(verGrafico);
		
		JButton asignarReferis = new JButton("Asignar Referis");
		asignarReferis.setBounds(514, 232, 156, 23);
		_frame.getContentPane().add(asignarReferis);
	
		asignarReferis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_controller.assignReferees();
				verGrafico.setEnabled(true);
			}
		});

		
		verGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graph.showGraph();
			}
		});
	}
	
	

	public void updateCalendar(ArrayList<String> matches) {
		_calendarView.updateCalendar(matches);

	}
	
	public void setGraph(BarGraph graph) {
		this.graph = graph;
	}
}
