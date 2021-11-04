package data;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;

import model.Tournament;

public class ReadJsonData {

	public static Tournament readTournament(String tournamentFile) {
		Gson gson = new Gson();
		Tournament ret = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(tournamentFile));
			ret = gson.fromJson(br, Tournament.class);
		} catch (Exception e) {
			System.out.println("Error reading file : " + tournamentFile);
			System.out.println(e.getClass());			
		}
		return ret;
	}
}
