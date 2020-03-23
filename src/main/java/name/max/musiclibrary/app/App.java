package name.max.musiclibrary.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import name.max.musiclibrary.dao.PlaylistDAO;
import name.max.musiclibrary.dao.TrackDAO;
import name.max.musiclibrary.dao.DBTrackDAO;
import name.max.musiclibrary.entities.Track;
import name.max.musiclibrary.services.DefaultPlaylistService;
import name.max.musiclibrary.services.DefaultTrackService;



public class App {

	public static void main(String[] args) throws IOException, SQLException {
		DefaultTrackService defaultTrackService = new DefaultTrackService();
//		List<Track> tracks = defaultTrackService.getFilesAsTracks("F:\\Tracks");
		PlaylistDAO pld = new PlaylistDAO();
		TrackDAO trd = new DBTrackDAO();
//		DefaultPlaylistService dpls = new DefaultPlaylistService(pld, trd);
//		List<Track> getAll = defaultTrackService.getAllTracks();
		
		
//		System.out.println(pld.getByID(3));
//		System.out.println(dpls.getPlaylist("new playlist"));

//		System.out.println(trd.getAll());
		
//		dpls.addTracks(getAll, "new playlist");
		
//		System.out.println(dpls.getPlaylist("new playlist"));
//		for (Track track: getAll) {
//		      System.out.println(track);
//		    }
//		System.out.println(defaultTrackService.getAllTracks());

//		for(Track track : pls.getPlaylist("123").getTracks()) {
//		track.getTag().setGenre(Genre.Electronic);

//		}
//		
//		for(Track track : dpls.getPlaylist("new playlist").getTracks()) {
//			System.out.println(track);
//		}
//		
		// trackService.fillTags(tracks);
		System.out.println(defaultTrackService.getByID(1));
	}

}
