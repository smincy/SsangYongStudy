package sist.com.music;

import java.io.Serializable;

// ∞¥√º ¥‹¿ß∑Œ

public class Music implements Serializable {

	private int no;
	private int idcrment;
	private String stat;
	private String title;
	private String singer;
	private String album;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getIdcrment() {
		return idcrment;
	}

	public void setIdcrment(int idcrment) {
		this.idcrment = idcrment;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Music(int no, int idcrment, String stat, String title, String singer, String album) {
		super();
		this.no = no;
		this.idcrment = idcrment;
		this.stat = stat;
		this.title = title;
		this.singer = singer;
		this.album = album;
	}

}
