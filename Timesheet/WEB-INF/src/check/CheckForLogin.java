package check;

import java.util.ArrayList;

import bean.LoginInputBean;

import common.ErrorMsg;

public class CheckForLogin {

	public ArrayList<String> doCheck(LoginInputBean inputBean, ArrayList<String> errList) {
		
		//IDのnull,空チェック
		if(inputBean.getID() == null || inputBean.getID().length() == 0){
			System.out.println("IDが未入力です");
			errList.add(ErrorMsg.ID_EMPTY);
		}
		
		//IDのlengthチェック
		if(inputBean.getID().length() > 10){
			System.out.println("IDが10文字を超えています");
			errList.add(ErrorMsg.ID_OVER_LENGTH);
		}
		
		//PWのnull,空チェック
		if(inputBean.getPW() == null || inputBean.getPW().length() == 0){
			System.out.println("PWが未入力です");
			errList.add(ErrorMsg.PW_EMPTY);
		}
		
		//PWのlengthチェック
		if(inputBean.getPW().length() > 12){
			System.out.println("PWが13文字を超えています");
			errList.add(ErrorMsg.PW_OVER_LENGTH);
		}
		
		return errList;
	}

}
