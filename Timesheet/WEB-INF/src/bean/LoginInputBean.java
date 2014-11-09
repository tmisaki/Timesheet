package bean;

import java.io.Serializable;

public class LoginInputBean implements Serializable {

	String ID;
	String PW;

	
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

}
