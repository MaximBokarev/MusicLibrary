package name.max.musiclibrary.dao;

import java.util.List;

import name.max.musiclibrary.entities.Track;

public interface TrackDAO extends DAO<Track> {

	void setPlaylist(long idPlaylist, List<Track> tracks);

}
