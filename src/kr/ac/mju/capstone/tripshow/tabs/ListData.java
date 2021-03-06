package kr.ac.mju.capstone.tripshow.tabs;

public class ListData {
	private int userImg;
	private int mainImg;
	private String name;
	private String date;
	private String location;
	private String comment_cnt;
	private String favorite_cnt;
	public ListData(int userImg, int mainImg, String name, String date,
			String location, String comment_cnt, String favorite_cnt) {
		super();
		this.userImg = userImg;
		this.mainImg = mainImg;
		this.name = name;
		this.date = date;
		this.location = location;
		this.comment_cnt = comment_cnt;
		this.favorite_cnt = favorite_cnt;
	}
	/**
	 * @return the userImg
	 */
	public int getUserImg() {
		return userImg;
	}
	/**
	 * @return the mainImg
	 */
	public int getMainImg() {
		return mainImg;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @return the comment_cnt
	 */
	public String getComment_cnt() {
		return comment_cnt;
	}
	/**
	 * @return the favorite_cnt
	 */
	public String getFavorite_cnt() {
		return favorite_cnt;
	}
	
	

}
