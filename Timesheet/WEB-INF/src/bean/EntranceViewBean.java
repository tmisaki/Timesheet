package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class EntranceViewBean implements Serializable {

	private String[] DAY = new String[62];
	private String[][] time = new String[31][2];
	private int rows;

	private String name;
	private ArrayList<String> start;
	private ArrayList<String> end;
	private ArrayList<String> commont;

	private int today;
	private String[] START;
	private String[] END;
	private String[] COMMENT;
	private ArrayList<String> errList;
	

	/**
	 * DAYを取得します。
	 * @return DAY
	 */
	public String[] getDAY() {
		return DAY;
	}

	/**
	 * DAYを設定します。
	 * @param DAY DAY
	 */
	public void setDAY(String[] DAY) {
		this.DAY = DAY;
	}

	/**
	 * timeを取得します。
	 * @return time
	 */
	public String[][] getTime() {
		return time;
	}

	/**
	 * timeを設定します。
	 * @param time time
	 */
	public void setTime(String[][] time) {
		this.time = time;
	}

	/**
	 * todayを取得します。
	 * @return today
	 */
	public int getToday() {
		return today;
	}

	/**
	 * todayを設定します。
	 * @param today today
	 */
	public void setToday(int today) {
		this.today = today;
	}

	/**
	 * rowsを取得します。
	 * @return rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * rowsを設定します。
	 * @param rows rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * nameを取得します。
	 * @return name
	 */
	public String getName() {
	    return name;
	}

	/**
	 * nameを設定します。
	 * @param name name
	 */
	public void setName(String name) {
	    this.name = name;
	}

	/**
	 * startを取得します。
	 * @return start
	 */
	public ArrayList<String> getStart() {
	    return start;
	}

	/**
	 * startを設定します。
	 * @param start start
	 */
	public void setStart(ArrayList<String> start) {
	    this.start = start;
	}

	/**
	 * endを取得します。
	 * @return end
	 */
	public ArrayList<String> getEnd() {
	    return end;
	}

	/**
	 * endを設定します。
	 * @param end end
	 */
	public void setEnd(ArrayList<String> end) {
	    this.end = end;
	}

	/**
	 * commontを取得します。
	 * @return commont
	 */
	public ArrayList<String> getCommont() {
	    return commont;
	}

	/**
	 * commontを設定します。
	 * @param commont commont
	 */
	public void setCommont(ArrayList<String> commont) {
	    this.commont = commont;
	}

	/**
	 * STARTを取得します。
	 * @return START
	 */
	public String[] getSTART() {
	    return START;
	}

	/**
	 * STARTを設定します。
	 * @param START START
	 */
	public void setSTART(String[] START) {
	    this.START = START;
	}

	/**
	 * ENDを取得します。
	 * @return END
	 */
	public String[] getEND() {
	    return END;
	}

	/**
	 * ENDを設定します。
	 * @param END END
	 */
	public void setEND(String[] END) {
	    this.END = END;
	}

	/**
	 * COMMENTを取得します。
	 * @return COMMENT
	 */
	public String[] getCOMMENT() {
	    return COMMENT;
	}

	/**
	 * COMMENTを設定します。
	 * @param COMMENT COMMENT
	 */
	public void setCOMMENT(String[] COMMENT) {
	    this.COMMENT = COMMENT;
	}

	/**
	 * errListを取得します。
	 * @return errList
	 */
	public ArrayList<String> getErrList() {
	    return errList;
	}

	/**
	 * errListを設定します。
	 * @param errList errList
	 */
	public void setErrList(ArrayList<String> errList) {
	    this.errList = errList;
	}
	
}
