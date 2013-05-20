package kr.ac.mju.capstone.tripshow.tabs;

public class ListData {
	private String userImg;
	private String mainImg;
	private String name;
	private String date;
	private String location;
	private int comment_cnt;
	private int favorite_cnt;
	
	public ListData(String userImg, String mainImg, String name, String date,
			String location, int comment_cnt, int favorite_cnt) {
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
	public String getUserImg() {
		return userImg;
	}

	/**
	 * @return the mainImg
	 */
	public String getMainImg() {
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
	public int getComment_cnt() {
		return comment_cnt;
	}

	/**
	 * @return the favorite_cnt
	 */
	public int getFavorite_cnt() {
		return favorite_cnt;
	}
	
	

}
