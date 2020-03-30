package name.max.musiclibrary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import name.max.musiclibrary.entities.PlayList;
import name.max.musiclibrary.entities.Track;

public class PlaylistDAO extends AbstractDAO<PlayList> {
	public void save(PlayList playlist) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:F:/Database/musiclibrary", "SA", "");
			Statement st = connection.createStatement();
			st.executeUpdate(
					"insert into playlist (id, name) values(" + playlist.getId() + ", " + playlist.getName() + ")");

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public PlayList getByID(long id) {
		PlayList playlist = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:F:/Database/musiclibrary", "SA", "");
			Statement st = connection.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM TRACK RIGHT JOIN PLAYLIST ON TRACK.PLAYLIST_ID = PLAYLIST.ID"
					+ " where playlist.id = " + id);
			List<Track> tracks = new ArrayList<Track>();

			while (rs.next()) {
				long id1 = rs.getLong("PLAYLIST.ID");
				String name = rs.getString("name");
				playlist = new PlayList(name, id1);

				long trackID = rs.getLong("Track.id");
				String path = rs.getString("Track.path");
				Track track = new Track(path, trackID);
				tracks.add(track);

			}
			for (Track track : tracks) {
				playlist.addTrack(track);
			}
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return playlist;
	}

	public PlayList getByName(String name) {
		PlayList playlist = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:F:/Database/musiclibrary", "SA", "");
			PreparedStatement st = connection.prepareStatement(
					"SELECT * FROM TRACK RIGHT JOIN PLAYLIST ON TRACK.PLAYLIST_ID = PLAYLIST.ID  WHERE PLAYLIST.NAME = ?");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			List<Track> tracks = new ArrayList<Track>();
//			System.out.println("Size " + rs.getFetchSize());

			while (rs.next()) {
				String name1 = rs.getString("name");
				long id = rs.getLong("PLAYLIST.ID");

				System.out.println("ID " + id);

				playlist = new PlayList(name1, id);

				long trackID = rs.getLong("Track.id");
				String path = rs.getString("Track.path");
				Track track = new Track(path, trackID);
				tracks.add(track);

			}
			for (Track track : tracks) {
				playlist.addTrack(track);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return playlist;

	}

	public List<PlayList> getAll() {
		List<PlayList> playlists = new ArrayList<PlayList>();

		try(Connection connection = super.getConnection()) {
			Statement st = connection.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM PLAYLIST");

			while (rs.next()) {
				String name = rs.getString("name");
				long id = rs.getLong("id");
				PlayList playlist = new PlayList(name, id);
				playlists.add(playlist);

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return playlists;

	}

}
