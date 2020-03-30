package name.max.musiclibrary.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import name.max.musiclibrary.entities.Track;

public class DBTrackDAO extends AbstractDAO<Track> {

	public void save(Track track) {
		try (Connection connection = super.getConnection()) {
			Statement st = connection.createStatement();
			st.executeUpdate("inser into track (id, path) values (" + track.getId() + ", " + track.getPath() + ")");

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public Track getByID(long id) {
		Track track = null;
		try (Connection connection = super.getConnection()) {
			Statement st = connection.createStatement();

			ResultSet rs = st.executeQuery("select * from track where id = " + id);
			while (rs.next()) {
				long id1 = rs.getLong("id");
				String path = rs.getString("path");
				track = new Track(path, id1);

			}
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return track;

	}

	public void setPlaylist(long idPlaylist, List<Track> tracks) {
		try (Connection connection = super.getConnection()) {
			Statement st = connection.createStatement();
			String trackID = "";
			int index = 0;
			for (Track track : tracks) {
				long s = track.getId();
				trackID = trackID + s;

				if (index != tracks.size() - 1) {
					trackID = trackID + ", ";
				}
				index = index + 1;
			}

			String str = "UPDATE TRACK SET PLAYLIST_ID = " + idPlaylist + " WHERE ID IN (" + trackID + ")";
			System.out.println(str);
			st.executeUpdate(str);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Track> getAll() {

		Connection connection = null;
		List<Track> tracks = new ArrayList<Track>();
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");

			connection = super.getConnection();
			Statement st = connection.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM TRACK");

			while (rs.next()) {
				String path = rs.getString("path");
				long id = rs.getLong("id");
				Track track = new Track(path, id);
				tracks.add(track);

			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tracks;

	}

}
