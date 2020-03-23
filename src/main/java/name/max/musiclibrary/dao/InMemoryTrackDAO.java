package name.max.musiclibrary.dao;

import java.util.List;

import name.max.musiclibrary.entities.Track;

public class InMemoryTrackDAO implements TrackDAO {

	@Override
	public void save(Track t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Track getByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Track> getAll() {
		return List.of(new Track("/home/music/Brejcha_Track1.mp3", 1),
				new Track("/home/music/Brejcha_Track2.mp3", 2));
	}

	@Override
	public void setPlaylist(long idPlaylist, List<Track> tracks) {
		// TODO Auto-generated method stub
		
	}

}
