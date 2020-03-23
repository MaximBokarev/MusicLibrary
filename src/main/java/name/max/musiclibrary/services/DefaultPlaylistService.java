package name.max.musiclibrary.services;

import java.util.List;

import name.max.musiclibrary.dao.PlaylistDAO;
import name.max.musiclibrary.dao.DBTrackDAO;
import name.max.musiclibrary.entities.PlayList;
import name.max.musiclibrary.entities.Track;

public class DefaultPlaylistService implements PlayListService{

	private PlaylistDAO pld;
	private DBTrackDAO trd;
	
	public DefaultPlaylistService(PlaylistDAO pld, DBTrackDAO trd) {
		this.pld = pld;
		this.trd = trd;
		
	}

	public void createPlaylist(String name) {
		PlayList playlist = new PlayList(name, (long) Math.random() * 100);
		pld.save(playlist);

	}

	public void addTracks(List<Track> tracks, String playlistName) {
		PlayList pl = pld.getByName(playlistName);
		long playlistID = pl.getId();
//		System.out.println("PlayListID " + plID);
		trd.setPlaylist(playlistID, tracks);

	}

	public PlayList getPlaylist(String name) {
		return pld.getByName(name);
	}

	@Override
	public PlayList getByID(long id) {
		return pld.getByID(id);
	}

}