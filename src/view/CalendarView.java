package view;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CalendarView {

	private JTextArea _calendarData;
	private JScrollPane _scrollPanel;

	private ArrayList<String> _matches;

	public CalendarView() {
		this._matches = new ArrayList<>();
		_calendarData = new JTextArea(); 
		_calendarData.setLineWrap(true);
		_calendarData.setEditable(false);

		writteCalendar();
		this._scrollPanel = new JScrollPane(_calendarData);
		this._scrollPanel.setBounds(107, 92, 484, 373);
	}
	public CalendarView(ArrayList<String> matches) {
		this._matches = matches;
		_calendarData = new JTextArea();
		_calendarData.setLineWrap(true);
		_calendarData.setEditable(false);

		writteCalendar();
		this._scrollPanel = new JScrollPane(_calendarData);
		this._scrollPanel.setBounds(107, 92, 484, 373);
	}

	JScrollPane getScrollPanel() {
		return _scrollPanel;
	}

	void writteCalendar() {
		for (String match : _matches) {
			if (_calendarData.getText() == null) {
				_calendarData.setText(match);
			} else {
				_calendarData.setText(_calendarData.getText() + match);
			}
		}
	}

	public void updateCalendar(ArrayList<String> updatedMatches) {
		_matches = updatedMatches;
		cleanCalendar();
		writteCalendar();
	}

	void cleanCalendar() {
		_calendarData.setText("");
	}
	JTextArea get_calendarData() {
		return _calendarData;
	}
	
	ArrayList<String> get_matches() {
		return _matches;
	}
	void set_matches(ArrayList<String> _matches) {
		this._matches = _matches;
	}
	
	

}
