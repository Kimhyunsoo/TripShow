package kr.ac.mju.capstone.tripshow.main;

public class SideMenuData {
	private int imgId;
	private String name;
	
	public SideMenuData(int imgId, String name) {
		this.imgId = imgId;
		this.name = name;
	}
	
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
