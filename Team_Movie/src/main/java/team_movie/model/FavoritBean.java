package team_movie.model;

public class FavoritBean {
	private int fnum; //������ȣ
	private int funum; // ȸ�� ������ȣ
	private int fmnum; // ���ã�� ��� ��ȭ ���� ��ȣ (TMOVIE ���̺� ���� ��ȣ)	
	
	public FavoritBean(){
		
	}
	
	public FavoritBean(int fnum, int funum, int fmnum) {
		super();
		this.fnum = fnum;
		this.funum = funum;
		this.fmnum = fmnum;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getFunum() {
		return funum;
	}
	public void setFunum(int funum) {
		this.funum = funum;
	}
	public int getFmnum() {
		return fmnum;
	}
	public void setFmnum(int fmnum) {
		this.fmnum = fmnum;
	}
	
	
	
}
