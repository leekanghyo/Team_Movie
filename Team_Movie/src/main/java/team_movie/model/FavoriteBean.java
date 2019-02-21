package team_movie.model;

public class FavoriteBean {
	private int fnum; //������ȣ
	private int funum; // ȸ�� ������ȣ
	private int fmnum; // ���ã�� ��� ��ȭ ���� ��ȣ (TMOVIE ���̺� ���� ��ȣ)	
	private int ftype; // ���ƿ� 0 / ���ã�� 1 ����
	
	public FavoriteBean(){
		
	}
	
	public FavoriteBean(int fnum, int funum, int fmnum, int ftype) {
		super();
		this.fnum = fnum;
		this.funum = funum;
		this.fmnum = fmnum;
		this.ftype = ftype;
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
	public int getFtype() {
		return ftype;
	}
	public void setFtype(int ftype) {
		this.ftype = ftype;
	}
	
	
	
}
