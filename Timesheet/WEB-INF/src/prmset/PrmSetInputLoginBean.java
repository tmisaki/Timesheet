package prmset;

import bean.LoginInputBean;

public class PrmSetInputLoginBean {
	
	public LoginInputBean setInputLoginBean(LoginInputBean bean, String ID, String PW){
		
		//ID,PWをセット
		bean.setID(ID);
		bean.setPW(PW);
		
		return bean;
	}

}
