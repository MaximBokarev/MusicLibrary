package name.max.musiclibrary.entities;

public enum Genre {
	Electronic(1), Rock(2), Blues(3), Jazz(4), Pop(5);
	private int genre;
	
	Genre(int genre) {
		this.genre = genre;
	}
	public int getGenre() {
		return genre;
	}

}
