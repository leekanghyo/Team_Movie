package team_movie.model;

public class GenreBean {
	private int gnum; // ������ȣ
	private String gname; // �帣 ��

	public GenreBean() {

	}

	public GenreBean(int gnum, String gname) {
		super();
		this.gnum = gnum;
		this.gname = gname;
	}

	public int getGnum() {
		return gnum;
	}

	public void setGnum(int gnum) {
		this.gnum = gnum;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

}
