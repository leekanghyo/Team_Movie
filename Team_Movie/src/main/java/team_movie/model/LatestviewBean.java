package team_movie.model;

public class LatestviewBean {
	private int vnum; // ������ȣ
	private int vviewcnt;
	private int vmnum ;  // ��ȭ ������ȣ
	private int vunum ; // ���� ������ȣ
	
	
	public LatestviewBean() {
		super();
	}
	public LatestviewBean(int vnum, int vviewcnt, int vmnum, int vunum) {
		super();
		this.vnum = vnum;
		this.vviewcnt = vviewcnt;
		this.vmnum = vmnum;
		this.vunum = vunum;
	}
	public int getVnum() {
		return vnum;
	}
	public void setVnum(int vnum) {
		this.vnum = vnum;
	}
	public int getVviewcnt() {
		return vviewcnt;
	}
	public void setVviewcnt(int vviewcnt) {
		this.vviewcnt = vviewcnt;
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
