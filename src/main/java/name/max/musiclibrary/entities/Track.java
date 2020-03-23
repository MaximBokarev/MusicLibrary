package name.max.musiclibrary.entities;

public class Track {
	
	private String path;
	private ID3 tag;
	private long id;
		
	public Track(String path, long id) {
		this.path = path;
		this.id = id;
		this.tag = new ID3();
	}
	
	public ID3 getTag() {
		return tag;
	}
	public String getPath() {
		return path;
	}
	
	public String toString() {
		return id + " " + path + " " + tag.toString();
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
		

}
