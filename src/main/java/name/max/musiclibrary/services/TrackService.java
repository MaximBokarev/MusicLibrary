package name.max.musiclibrary.services;

import java.io.IOException;
import java.util.List;

import name.max.musiclibrary.entities.Track;

public interface TrackService {

	List<Track> getFilesAsTracks(String path);

	void fillTags(List<Track> tracks) throws IOException;

	void saveAllTracks(List<Track> tracks);

	List<Track> getAllTracks();
	
	Track getByID(long id);

}
