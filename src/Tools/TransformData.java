package Tools;

import java.util.ArrayList;

import model.Calendar;
import model.GameDay;
import model.Match;

public class TransformData {

	public static ArrayList<String> calendarToString(Calendar c) {
		ArrayList<String> ret = new ArrayList<>();
		StringBuilder stringMatch = new StringBuilder();

		for (GameDay gameDay : c.getMatchesDays()) {
			stringMatch.append("*********************************************************************************************\n").append("   Fecha ")
					.append(gameDay.getDayNumber()).append("\n\n");

			for (Match match : gameDay.getMatches()) {
				
				String referee = match.getReferee() != null ? match.getReferee().toString() : " ";
				
				stringMatch.append("   Equipos : ")
						.append(match.getTeamA()).append(" vs ").append(match.getTeamB())
						.append("\n").append("   Arbitro : ").append(referee).append("\n")
						.append("\n");
			}

			ret.add(stringMatch.toString());
			stringMatch.setLength(0); // To clean the string builder.
		}
		return ret;

	}
}
