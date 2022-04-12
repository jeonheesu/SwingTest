package dto;

public class memberDTO {

	private int mNum;
	private String mID;
	private String mPW;
	/**
	 * @return the mNum
	 */
	public int getmNum() {
		return mNum;
	}
	/**
	 * @param mNum the mNum to set
	 */
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	/**
	 * @return the mID
	 */
	public String getmID() {
		return mID;
	}
	/**
	 * @param mID the mID to set
	 */
	public void setmID(String mID) {
		this.mID = mID;
	}
	/**
	 * @return the mPW
	 */
	public String getmPW() {
		return mPW;
	}
	/**
	 * @param mPW the mPW to set
	 */
	public void setmPW(String mPW) {
		this.mPW = mPW;
	}
	@Override
	public String toString() {
		return "memberDTO [mNum=" + mNum + ", mID=" + mID + ", mPW=" + mPW + ", getmNum()=" + getmNum() + ", getmID()="
				+ getmID() + ", getmPW()=" + getmPW() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
