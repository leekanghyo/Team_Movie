package team_movie.model;

public class LatestviewBean {
	private int vnum; // ������ȣ
	private int vcount; // ��û�� 1 / �⺻ 0
	private int vmnum ;  // ��ȭ ������ȣ
	private int vunum ; // ���� ������ȣ
	
	

	public LatestviewBean() {
		super();
	}

	public LatestviewBean(int vnum, int vcount, int vmnum, int vunum) {
		super();
		this.vnum = vnum;
		this.vcount = vcount;
		this.vmnum = vmnum;
		this.vunum = vunum;
	}
	
	public int getVnum() {
		return vnum;
	}
	public void setVnum(int vnum) {
		this.vnum = vnum;
	}
	public int getVcount() {
		return vcount;
	}
	public void setVcount(int vcount) {
		this.vcount = vcount;
	}
	public int getVmnum() {
		return vmnum;
	}
	public void setVmnum(int vmnum) {
		this.vmnum = vmnum;
	}
	public int getVunum() {
		return vunum;
	}
	public void setVunum(int vunum) {
		this.vunum = vunum;
	}
	
	
}
