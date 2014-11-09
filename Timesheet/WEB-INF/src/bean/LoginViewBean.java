package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginViewBean implements Serializable {
	
	String ID;
	String PW;
	ArrayList<String> errList;
	
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String PW) {
		this.PW = PW;
	}
	public ArrayList<String> getErrList() {
		return errList;
	}
	public void setErrList(ArrayList<String> errList) {
		this.errList = errList;
	}

}
