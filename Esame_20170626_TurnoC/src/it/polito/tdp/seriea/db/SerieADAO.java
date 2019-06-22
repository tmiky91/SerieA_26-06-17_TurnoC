package it.polito.tdp.seriea.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.seriea.model.Risultato;
import it.polito.tdp.seriea.model.RisultatoPartita;
import it.polito.tdp.seriea.model.Season;
import it.polito.tdp.seriea.model.Team;

public class SerieADAO {

	public List<Season> listSeasons() {
		String sql = "SELECT season, description FROM seasons";
		List<Season> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new Season(res.getInt("season"), res.getString("description")));
			}

			conn.close();
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Team> listTeams() {
		String sql = "SELECT team FROM teams";
		List<Team> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new Team(res.getString("team")));
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<RisultatoPartita> getRisultatiPartite(Map<Integer, Integer> idMap) {
		final String sql=	"select m.FTHG as goalCasa, m.FTAG as goalTrasferta, count(*) as peso " + 
							"from matches as m " + 
							"group by goalCasa, goalTrasferta";
		List<RisultatoPartita> result = new LinkedList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Integer goal1 = idMap.get(res.getObject("goalCasa"));
				Integer goal2 = idMap.get(res.getObject("goaltrasferta"));
				if(goal1!=null && goal2!=null) {
					RisultatoPartita risultato = new RisultatoPartita(goal1, goal2, res.getDouble("peso"));
					result.add(risultato);
				}
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Integer> getGoalCasa(Map<Integer, Integer> idMap) {
		final String sql=	"select distinct m.FTHG as goalCasa " + 
							"from matches as m " + 
							"group by goalCasa";
		List<Integer> result = new LinkedList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				if(!idMap.containsKey(res.getInt("goalCasa"))) {
					Integer goal = new Integer(res.getInt("goalCasa"));
					result.add(goal);
					idMap.put(res.getInt("goalCasa"), goal);
				}else {
					result.add(idMap.get(res.getInt("goalCasa")));
				}
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List<Risultato> getRisultati(Map<Integer, Integer> idMap, Integer numGoalCasa) {
		final String sql=	"select m1.FTHG as goalCasa, m1.FTAG as goalTras, count(*) as cnt " + 
							"from matches as m1 " + 
							"where m1.FTHG=? " + 
							"group by goalCasa, goalTras " + 
							"order by cnt desc";
		List<Risultato> result = new LinkedList<>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, numGoalCasa);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Integer goal1 = idMap.get(res.getObject("goalCasa"));
				Integer goal2 = idMap.get(res.getObject("goalTras"));
				if(goal1!=null && goal2!=null) {
					Risultato risultato = new Risultato(goal1, goal2, res.getDouble("cnt"));
					result.add(risultato);
				}
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
