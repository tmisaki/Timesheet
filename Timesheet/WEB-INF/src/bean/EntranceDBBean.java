package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class EntranceDBBean implements Serializable {
	
	private String TODAY;
	private String NOW;
	private String MEMCODE;
	private String COMMENT;
	private ArrayList<String> HOLIDAY;
	
	/**
	 * TODAYを取得します。
	 * @return TODAY
	 */
	public String getTODAY() {
	    return TODAY;
	}
	/**
	 * TODAYを設定します。
	 * @param TODAY TODAY
	 */
	public void setTODAY(String TODAY) {
	    this.TODAY = TODAY;
	}
	/**
	 * NOWを取得します。
	 * @return NOW
	 */
	public String getNOW() {
	    return NOW;
	}
	/**
	 * NOWを設定します。
	 * @param NOW NOW
	 */
	public void setNOW(String NOW) {
	    this.NOW = NOW;
	}
	/**
	 * MEMCODEを取得します。
	 * @return MEMCODE
	 */
	public String getMEMCODE() {
	    return MEMCODE;
	}
	/**
	 * MEMCODEを設定します。
	 * @param MEMCODE MEMCODE
	 */
	public void setMEMCODE(String MEMCODE) {
	    this.MEMCODE = MEMCODE;
	}
	/**
	 * COMMENTを取得します。
	 * @return COMMENT
	 */
	public String getCOMMENT() {
	    return COMMENT;
	}
	/**
	 * COMMENTを設定します。
	 * @param COMMENT COMMENT
	 */
	public void setCOMMENT(String COMMENT) {
	    this.COMMENT = COMMENT;
	}
	/**
	 * HOLIDAYを取得します。
	 * @return HOLIDAY
	 */
	public ArrayList<String> getHOLIDAY() {
	    return HOLIDAY;
	}
	/**
	 * HOLIDAYを設定します。
	 * @param HOLIDAY HOLIDAY
	 */
	public void setHOLIDAY(ArrayList<String> HOLIDAY) {
	    this.HOLIDAY = HOLIDAY;
	}
	

}
