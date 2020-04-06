package name.max.musiclibrary.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import name.max.musiclibrary.entities.Track;

public class DBTrackDAO extends AbstractDAO<Track> implements TrackDAO {

	public void save(Track track) {
		try (Connection connection = super.getConnection()) {
			Statement st = connection.createStatement();
			st.executeUpdate("insert into track (id, path) values (" + track.getId() + ", " + track.getPath() + ")");

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
				String name = rs.getString("name");
				track = new Track(path, id1, name);

			}

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

		List<Track> tracks = new ArrayList<Track>();
		try (Connection connection = super.getConnection()) {
			Statement st = connection.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM TRACK");

			while (rs.next()) {
				String path = rs.getString("path");
				long id = rs.getLong("id");
				String name = rs.getString("name");
				Track track = new Track(path, id, name);
				tracks.add(track);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return tracks;

	}

}
