package name.max.musiclibrary.entities;

public class Track {
	
	private String name;
	private String path;
	private ID3 tag;
	private long id;
		
	public Track(String path, long id, String name) {
		this.path = path;
		this.id = id;
		this.name = name;
		this.tag = new ID3();
	}
	
	public ID3 getTag() {
		return tag;
	}
	public String getPath() {
		return path;
	}
	
	public String toString() {
		return id + " " + path + " " + name + tag.toString();
	
	}
	
	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
		

}
