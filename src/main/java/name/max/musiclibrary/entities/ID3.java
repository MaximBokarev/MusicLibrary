package name.max.musiclibrary.entities;

public class ID3 {
	private String title;
	private String artist;
	private String album;
	private String comment;
	private Genre genre;
	
	public ID3() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "ID3 [title=" + title + ", artist=" + artist + ", album=" + album + ", comment=" + comment + ", genre="
				+ genre + "]";
	}
	
	

}
