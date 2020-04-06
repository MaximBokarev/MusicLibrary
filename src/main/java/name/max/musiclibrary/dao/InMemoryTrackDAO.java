package name.max.musiclibrary.dao;

import java.util.List;
import java.util.Map;

import name.max.musiclibrary.entities.Track;

public class InMemoryTrackDAO implements TrackDAO {

	Map<Long, Track> tracks = Map.of(1l, new Track("F:\\Tracks/Andreas Henneberg - Better Than This (Original Mix)", 1, "Andreas Henneberg - Better Than This (Original Mix)"));
	@Override
	public void save(Track t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Track getByID(long id) {
		return tracks.get(id);
	}

	@Override
	public List<Track> getAll() {
		return List.copyOf(tracks.values());
	}

	@Override
	public void setPlaylist(long idPlaylist, List<Track> tracks) {
		// TODO Auto-generated method stub
		
	}

}
