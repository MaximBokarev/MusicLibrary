package name.max.musiclibrary.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import name.max.musiclibrary.dao.DBTrackDAO;
import name.max.musiclibrary.entities.Track;

public class DefaultTrackService implements TrackService {
	private DBTrackDAO td = new DBTrackDAO();
	
	
	public List<Track> getFilesAsTracks(String path) {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		List<Track> tracks = new ArrayList<>();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				String trackPath = file.getAbsolutePath();
				Track track = new Track(trackPath, 0);
				tracks.add(track);
			}
		}
		return tracks;
	}


	public void fillTags(List<Track> tracks) throws IOException {
		for (Track track : tracks) {
			System.out.println(track.getPath());
			try(InputStream is = new FileInputStream(track.getPath())) {
				byte[] b = new byte[3];

				while (is.read(b) != -1) {
					String flag = new String(b, StandardCharsets.US_ASCII);
					// System.out.println(flag);

					if (flag.equals("TAG")) {
						System.out.println("it works");
					}
				}
			} 
		}
		
	}

	public void saveAllTracks(List<Track> tracks) {
		for (Track track : tracks) {
			td.save(track);
		}

	}

	public List<Track> getAllTracks() {
		return td.getAll();

	}



	public Track getByID(long id) {
		return td.getByID(id);
}


	@Override
	public InputStream play(Track track) {
		try {
			return new FileInputStream(new File(track.getPath()));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}