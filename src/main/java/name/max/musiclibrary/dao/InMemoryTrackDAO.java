package name.max.musiclibrary.dao;

import java.util.List;
import java.util.Map;

import name.max.musiclibrary.entities.Track;

public class InMemoryTrackDAO implements TrackDAO {

	Map<Long, Track> tracks = Map.of(1l, new Track("/Users/anton.panchenko/tmp/m/Come as You Are (Evokings Remix) (TerritoryDeepHouse).mp3", 1));
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
