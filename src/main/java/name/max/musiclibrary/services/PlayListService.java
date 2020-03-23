package name.max.musiclibrary.services;

import java.util.List;

import name.max.musiclibrary.entities.PlayList;
import name.max.musiclibrary.entities.Track;

public interface PlayListService {

	void createPlaylist(String name);

	void addTracks(List<Track> tracks, String playlistName);

	PlayList getPlaylist(String name);
	
	PlayList getByID(long id);

}
