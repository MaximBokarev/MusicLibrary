package name.max.musiclibrary.entities;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
	private String name;
	private long id;
	private List<Track> tracks;

	public PlayList() {
		tracks = new ArrayList<>();
	}

	public PlayList(String name, long id) {
		this();
		this.name = name;
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void addTrack(Track track) {
		tracks.add(track);
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "PlayList [name=" + name + ", id=" + id + ", tracks=" + tracks + "]";
	}

}